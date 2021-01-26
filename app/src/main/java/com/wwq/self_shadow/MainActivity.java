package com.wwq.self_shadow;

import androidx.appcompat.app.AppCompatActivity;
import dalvik.system.BaseDexClassLoader;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.webkit.WebView;

import com.wwq.pluginlibrary.DelegateProviderHolder;
import com.wwq.pluginlibrary.GlobalContext;
import com.wwq.pluginlibrary.PluginClassLoader;
import com.wwq.pluginlibrary.ShadowContext;
import com.wwq.self_shadow.plugin.PluginDefaultActivity;
import com.wwq.self_shadow.plugin.ShadowActivityDelegate;
import com.wwq.self_shadow.plugin.ShadowProvider;

import java.io.File;
import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity {
    public static PluginClassLoader baseDexClassLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalContext.setApplication(this.getApplicationContext());
        DelegateProviderHolder.setDelegateProvider("test",new ShadowProvider());
//        connectPPService();
//        startService(new Intent(this,TestService.class));

        new Thread(new Runnable() {
            @Override
            public void run() {
                File file = new File(getFilesDir(), "shadow_demo-debug.apk");
                CopyFileFromAssets.copy(MainActivity.this,"shadow_demo-debug.apk",file);
                final Resources resource = createResource();
                ShadowActivityDelegate.mPluginResources = resource;

                File odexFile = new File(getCacheDir(), "");
                if (file.exists()) {
                    Log.d(Constant.TAG, "apkPath " + file.getAbsolutePath());
                } else {
                    Log.d(Constant.TAG, "apkPath 不存在，" + file.getAbsolutePath());
                }
                ClassLoader classLoader = MainActivity.class.getClassLoader();
                baseDexClassLoader = new PluginClassLoader(file.getAbsolutePath(), odexFile, null,classLoader);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this, PluginDefaultActivity.class));
                    }
                });

            }
        }).start();

    }
    public static ApplicationInfo applicationInfo;
    private Resources createResource() {
        File file = new File(getFilesDir(), "shadow_demo-debug.apk");
        PackageInfo packageArchiveInfo = getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(),
                PackageManager.GET_ACTIVITIES
                        | PackageManager.GET_META_DATA
                        | PackageManager.GET_SERVICES
                        | PackageManager.GET_PROVIDERS
                        | PackageManager.GET_SIGNATURES);
        packageArchiveInfo.applicationInfo.nativeLibraryDir = null;
        ShadowContext shadowContext = new ShadowContext(MainActivity.this, 0);
        File dataDir = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dataDir = shadowContext.getDataDir();
        } else {
            dataDir = new File(shadowContext.getFilesDir(), "dataDir");
        }
        dataDir.mkdirs();
        packageArchiveInfo.applicationInfo.dataDir = dataDir.getAbsolutePath();
        try {
            Resources resources = create(packageArchiveInfo, file.getAbsolutePath(), this);
            applicationInfo = packageArchiveInfo.applicationInfo;
            String string = resources.getString(R.string.app_name);
            Log.d("shadow_ca", "string = " + string);
            return resources;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.e("shadow_ca", "msg = " + e.toString());
        }
        return null;
    }

    public Resources create(PackageInfo packageArchiveInfo, String archiveFilePath,
                            final Context hostAppContext) throws PackageManager.NameNotFoundException {
        //先用宿主context初始化一个WebView，以便WebView的逻辑去修改sharedLibraryFiles，将webview.apk添加进去
        final CountDownLatch latch = new CountDownLatch(1);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                new WebView(hostAppContext);
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PackageManager packageManager = hostAppContext.getPackageManager();
        packageArchiveInfo.applicationInfo.publicSourceDir = archiveFilePath;
        packageArchiveInfo.applicationInfo.sourceDir = archiveFilePath;
        packageArchiveInfo.applicationInfo.sharedLibraryFiles = hostAppContext.getApplicationInfo().sharedLibraryFiles;
        return packageManager.getResourcesForApplication(packageArchiveInfo.applicationInfo);
    }



    private void connectPPService() {
        File file = new File(getFilesDir(), "shadow_demo-debug.apk");
        CopyFileFromAssets.copy(MainActivity.this,"shadow_demo-debug.apk",file);
        Intent intent = new Intent();

        intent.setComponent(new ComponentName(getApplication().getApplicationContext(), "com.wwq.self_shadow.PPService"));
        getApplicationContext().bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d(Constant.TAG,"onServiceConnected ： "+name.getClassName());
                PpsController ppsController = PPService.wrapBinder(service);
                try {
                    ppsController.setUUID("123");
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (FailedException e) {
                    e.printStackTrace();
                }
                try {
                    ppsController.startService("4345");
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (FailedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d(Constant.TAG,"onServiceDisconnected: "+name.getClassName());
            }
        },BIND_AUTO_CREATE);
    }
}
