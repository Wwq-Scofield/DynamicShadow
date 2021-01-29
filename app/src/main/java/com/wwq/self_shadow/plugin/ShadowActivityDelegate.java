package com.wwq.self_shadow.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import com.wwq.pluginlibrary.GeneratedShadowActivityDelegate;
import com.wwq.pluginlibrary.HostActivityDelegate;
import com.wwq.pluginlibrary.HostActivityDelegator;
import com.wwq.pluginlibrary.MixResources;
import com.wwq.pluginlibrary.ShadowActivity;
import com.wwq.self_shadow.Constant;
import com.wwq.self_shadow.MainActivity;
import com.wwq.self_shadow.PPService;

import java.io.FileInputStream;
import java.io.IOException;

import static com.wwq.self_shadow.PPService.baseDexClassLoader;


public class ShadowActivityDelegate extends GeneratedShadowActivityDelegate implements HostActivityDelegate {
    private HostActivityDelegator mHostActivityDelegator;
    public static Resources mPluginResources;
    private boolean mDependenciesInjected = false;

    @Override
    public void setDelegator(HostActivityDelegator delegator) {
        mHostActivityDelegator = delegator;
    }

    @Override
    public Object getPluginActivity() {
        return pluginActivity;
    }

    @Override
    public String getLoaderVersion() {
        return null;
    }

    @Override
    public boolean isChangingConfigurations() {
        return false;
    }

    @Override
    public void finish() {
        mHostActivityDelegator.superFinish();
    }

    @Override
    public ClassLoader getClassLoader() {
        return baseDexClassLoader;
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return null;
    }

    @Override
    public Resources getResources() {
        if (mDependenciesInjected) {
            return mMixResources;
        } else {
            //预期只有android.view.Window.getDefaultFeatures会调用到这个分支，此时我们还无法确定插件资源
            //而getDefaultFeatures只需要访问系统资源
            return Resources.getSystem();
        }
    }

    @Override
    public boolean onNavigateUpFromChild(Activity arg0) {
        return false;
    }

    private MixResources mMixResources;

    @Override
    public void onCreate(Bundle arg0, Object arg1) {
        mMixResources = new MixResources(mHostActivityDelegator.superGetResources(), mPluginResources);
        mDependenciesInjected = true;
    }

    @Override
    public void onChildTitleChanged(Activity arg0, CharSequence arg1) {

    }


    private ShadowActivity shadowActivity;

    @Override
    public void onCreate(Bundle arg0) {

        Log.d("shadow_ca", "onCreate..."+mPluginResources);
        Log.e(Constant.TAG,"currentProcess activity 1: "+getCurrentProcessName());
//        try {
            mMixResources = new MixResources(mHostActivityDelegator.superGetResources(), mPluginResources);
            mDependenciesInjected=true;
        Object o1 = null;
        try {
            String className = arg0.getString("className");
            Log.d(Constant.TAG,"className = "+className);
            // "com.wwq.shadow_demo.MainActivity"
            o1 = baseDexClassLoader.loadClass(className).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//            Object o1 = baseDexClassLoader.loadClass("com.wwq.shadow_demo.TestService").newInstance();
//            final Service service = (Service) o1;
//            Log.d("shadow_ca", "onCreate...shadowActivity ="+o);
//            service.onCreate();

            shadowActivity = (ShadowActivity) o1;

            Log.d("shadow_ca", "onCreate...1 ="+shadowActivity);
            shadowActivity.setHostActivityDelegator(mHostActivityDelegator);
            shadowActivity.setPluginResources(mPluginResources);
            shadowActivity.setPluginClassLoader(baseDexClassLoader);
            shadowActivity.setApplicationInfo(PPService.applicationInfo);
            shadowActivity.setHostContextAsBase((Context) mHostActivityDelegator.getHostActivity());
            shadowActivity.setPluginComponentLauncher(new PluginComponentLauncherImpl());
            super.pluginActivity = shadowActivity;
            Log.e(Constant.TAG,"pluginActivity 2: "+pluginActivity);
            shadowActivity.setTheme(PPService.applicationInfo.theme);
            shadowActivity.onCreate(arg0);
            Log.e(Constant.TAG,"currentProcess activity 2: "+getCurrentProcessName());
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d("shadow_ca", "onCreate...shadowActivity ="+e.toString());
//        }
    }
    public static String getCurrentProcessName() {
        FileInputStream in = null;
        try {
            String fn = "/proc/self/cmdline";
            in = new FileInputStream(fn);
            byte[] buffer = new byte[256];
            int len = 0;
            int b;
            while ((b = in.read()) > 0 && len < buffer.length) {
                buffer[len++] = (byte) b;
            }
            if (len > 0) {
                String s = new String(buffer, 0, len, "UTF-8");
                return s;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
