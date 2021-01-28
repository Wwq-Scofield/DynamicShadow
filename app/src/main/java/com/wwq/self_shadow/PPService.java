package com.wwq.self_shadow;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import com.wwq.pluginlibrary.PluginClassLoader;
import com.wwq.pluginlibrary.ShadowContext;
import com.wwq.pluginlibrary.ShadowService;
import com.wwq.self_shadow.plugin.PluginDefaultActivity;
import com.wwq.self_shadow.plugin.ShadowActivityDelegate;
import com.wwq.self_shadow.pps.PPSBinder;
import com.wwq.self_shadow.pps.PpsController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import androidx.annotation.Nullable;
import dalvik.system.BaseDexClassLoader;

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
        File odexFile = new File(getCacheDir(), "");
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
    public static ApplicationInfo applicationInfo;
    public static PluginClassLoader baseDexClassLoader;
    private Resources createResource(String pluginKey) {
        File file = new File(getFilesDir(), Constant.apk);
        PackageInfo packageArchiveInfo = getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(),
                PackageManager.GET_ACTIVITIES
                        | PackageManager.GET_META_DATA
                        | PackageManager.GET_SERVICES
                        | PackageManager.GET_PROVIDERS
                        | PackageManager.GET_SIGNATURES);
        packageArchiveInfo.applicationInfo.nativeLibraryDir = null;
        ShadowContext shadowContext = new ShadowContext(this, 0);
        File dataDir = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dataDir = shadowContext.getDataDir();
        } else {
            dataDir = new File(shadowContext.getFilesDir(), pluginKey);
        }
        dataDir.mkdirs();
        packageArchiveInfo.applicationInfo.dataDir = dataDir.getAbsolutePath();
        try {
            Resources resources = create(packageArchiveInfo, file.getAbsolutePath(), this);
            applicationInfo = packageArchiveInfo.applicationInfo;
//            String string = resources.getString(R.string.app_name);
//            Log.d("shadow_ca", "string = " + string);
            return resources;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.e("shadow_ca", "msg = " + e.toString());
        }
        return null;
    }

    public Resources create(
            //插件的packageInfo
            PackageInfo packageArchiveInfo,
            //插件的apk地址
            String archiveFilePath,
            final Context hostAppContext) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = hostAppContext.getPackageManager();
        packageArchiveInfo.applicationInfo.publicSourceDir = archiveFilePath;
        packageArchiveInfo.applicationInfo.sourceDir = archiveFilePath;
        packageArchiveInfo.applicationInfo.sharedLibraryFiles = hostAppContext.getApplicationInfo().sharedLibraryFiles;
        return packageManager.getResourcesForApplication(packageArchiveInfo.applicationInfo);
    }

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
        Log.e(Constant.TAG, "start load plugin");
        if(classLoaderMap.containsKey(pluginKey)&&classLoaderMap.get(pluginKey)!=null){
            baseDexClassLoader=classLoaderMap.get(pluginKey);
            ShadowActivityDelegate.mPluginResources =resourcesMap.get(pluginKey);
            Log.d(Constant.TAG, "baseDexClassLoader 1 ="+baseDexClassLoader);
            return;
        }
        Resources resource = createResource(pluginKey);
        Log.d(Constant.TAG, "service onCreate,resource="+resource);
        ShadowActivityDelegate.mPluginResources =resource;
        resourcesMap.put(pluginKey,resource);
        ClassLoader classLoader = PPService.class.getClassLoader();
        File odexFile = new File(getCacheDir(), pluginKey);
        if(!odexFile.exists()){
            odexFile.mkdirs();
        }
        File file = new File(getFilesDir(), Constant.apk);
        baseDexClassLoader = new PluginClassLoader(file.getAbsolutePath(), odexFile, null,classLoader);
        Log.d(Constant.TAG, "baseDexClassLoader 2 ="+baseDexClassLoader);
        classLoaderMap.put(pluginKey,baseDexClassLoader);
    }
}
