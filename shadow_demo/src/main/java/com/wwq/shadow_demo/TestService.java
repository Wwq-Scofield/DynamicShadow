package com.wwq.shadow_demo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.webkit.WebView;

import com.wwq.pluginlibrary.ITest;

import java.io.File;
import java.util.concurrent.CountDownLatch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TestService extends Service implements ITest {
    private Handler handler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.d("shadow_ca","service is running->onStartCommand");
            handler.sendEmptyMessageDelayed(1,1000);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("shadow_ca","service is running");

    }

    @Override
    public void onCreate(Bundle bundle) {
        Log.d("shadow_ca","service onCreate bundle");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("shadow_ca","service is running->onStartCommand");
        handler.sendEmptyMessageDelayed(1,1000);
        return super.onStartCommand(intent, flags, startId);
    }

    private void createResource() {
        File file = new File(getFilesDir(), "shadow_demo-debug.apk");
        PackageInfo packageArchiveInfo = getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(),
                PackageManager.GET_ACTIVITIES
                        | PackageManager.GET_META_DATA
                        | PackageManager.GET_SERVICES
                        | PackageManager.GET_PROVIDERS
                        | PackageManager.GET_SIGNATURES);
        packageArchiveInfo.applicationInfo.nativeLibraryDir = null;
        File dataDir = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dataDir = getDataDir();
        } else {
            dataDir = new File(getDataDir(), "dataDir");
        }
        dataDir.mkdirs();
        packageArchiveInfo.applicationInfo.dataDir = dataDir.getAbsolutePath();
        try {
            Resources resources = create(packageArchiveInfo, file.getAbsolutePath(), this);
            String string = resources.getString(R.string.app_name);

            Log.d("shadow_ca", "string = " + string);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.e("shadow_ca", "msg = " + e.toString());
        }
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


}
