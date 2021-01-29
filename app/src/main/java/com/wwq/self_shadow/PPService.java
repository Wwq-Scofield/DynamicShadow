package com.wwq.self_shadow;

import android.app.Service;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import com.wwq.pluginlibrary.PluginClassLoader;
import com.wwq.pluginlibrary.ShadowService;
import com.wwq.self_shadow.plugin.PluginDefaultActivity;
import com.wwq.self_shadow.plugin.ShadowActivityDelegate;
import com.wwq.self_shadow.pps.PPSBinder;
import com.wwq.self_shadow.pps.PpsController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;

import static com.wwq.self_shadow.plugin.ShadowActivityDelegate.getCurrentProcessName;

public class PPService extends Service {
    private Handler mUiHandler = new Handler(Looper.getMainLooper());

    private static Object sSingleInstanceFlag = null;
    private PPSBinder binder = new PPSBinder(this);

    @Override
    public void onCreate() {
        super.onCreate();
        if (sSingleInstanceFlag == null) {
            Log.d(Constant.TAG, "首次创建service");
        } else {
            Log.e(Constant.TAG, "service 创建了多实例");
        }
        Log.d(Constant.TAG, "service onCreate");

    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(Constant.TAG, "service onRebind");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Constant.TAG, "service onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(Constant.TAG, "service onBind : " + binder);
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(Constant.TAG, "service onUnbind : " + intent);
        return super.onUnbind(intent);
    }

    public static PpsController wrapBinder(IBinder ppsBinder) {
        return new PpsController(ppsBinder);
    }

    public void startService() throws Exception {
        File file = new File(getFilesDir(), Constant.apk);
        if (file.exists()) {
            Log.d(Constant.TAG, "apkPath " + file.getAbsolutePath());
        } else {
            Log.d(Constant.TAG, "apkPath 不存在，" + file.getAbsolutePath());
        }
        Log.e(Constant.TAG,"currentProcess service: "+getCurrentProcessName());

        Object o = baseDexClassLoader.loadClass("com.wwq.shadow_demo.TestService").newInstance();
        final ShadowService service = (ShadowService) o;
//        if (isUiThread()) {
            service.onCreate();
            service.onStartCommand(new Intent(), 0, 10);
//        } else {
//            final CountDownLatch waitUiLock = new CountDownLatch(1);
//            mUiHandler.post(new Runnable() {
//                @Override
//                public void run() {
//                    service.onCreate();
//                    service.onStartCommand(new Intent(), 0, 10);
//                    waitUiLock.countDown();
//                }
//            });
//            waitUiLock.await();
//        }
    }

    private boolean isUiThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
    private UserInfo userInfo;
    public void setUserName(String arg0) {
        Log.e(Constant.TAG,"currentProcess service 1 : "+getCurrentProcessName());
        userInfo = new UserInfo();
        userInfo.name = arg0;
        Constant.userInfo = userInfo;
        Log.d(Constant.TAG,"setUserName = "+arg0);
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void exit() {
        System.exit(0);
        try {
            wait();
            Log.e(Constant.TAG,"exit...");
        } catch (InterruptedException ignored) {
        }
    }

    public static PluginClassLoader baseDexClassLoader;
    public void starPluginActivity() {
        Intent intent = new Intent(this, PluginDefaultActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle bundle= new Bundle();
        bundle.putString("className","com.wwq.shadow_demo.MainActivity");
        intent.putExtras(bundle);
        startActivity(intent);
        Log.e(Constant.TAG,"currentProcess service 2 : "+getCurrentProcessName());
    }
    public void starPluginActivityForResult() {
//        Intent intent = new Intent(this, PluginDefaultActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//        Log.e(Constant.TAG,"currentProcess service 2 : "+getCurrentProcessName());
    }
    Map<String, PluginClassLoader> classLoaderMap = new HashMap<>();
    Map<String, Resources> resourcesMap = new HashMap<>();
    public void loadPlugin(String pluginKey){
        if(pluginKey.equalsIgnoreCase("min")){
            Constant.apk = Constant.apk_min;
        }else{
            Constant.apk = Constant.apk_max;
        }
        Log.e(Constant.TAG, "start load plugin : "+pluginKey);
        if(classLoaderMap.containsKey(pluginKey)&&classLoaderMap.get(pluginKey)!=null){
            baseDexClassLoader=classLoaderMap.get(pluginKey);
            ShadowActivityDelegate.mPluginResources =resourcesMap.get(pluginKey);
            Log.d(Constant.TAG, "baseDexClassLoader 1 ="+baseDexClassLoader);
            return;
        }
        File file = new File(getFilesDir(), Constant.apk);
        Resources resource = PackageResManager.createResource(this,file,pluginKey);
        Log.d(Constant.TAG, "service onCreate,resource="+resource);
        ShadowActivityDelegate.mPluginResources =resource;
        resourcesMap.put(pluginKey,resource);
        ClassLoader classLoader = PPService.class.getClassLoader();
        File odexFile = new File(getCacheDir(), pluginKey);
        if(!odexFile.exists()){
            odexFile.mkdirs();
        }
        baseDexClassLoader = new PluginClassLoader(file.getAbsolutePath(), odexFile, null,classLoader);
        Log.d(Constant.TAG, "baseDexClassLoader 2 ="+baseDexClassLoader);
        classLoaderMap.put(pluginKey,baseDexClassLoader);
    }
}
