package com.wwq.self_shadow;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import java.io.File;
import java.util.concurrent.CountDownLatch;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import dalvik.system.BaseDexClassLoader;

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
        File file = new File(getFilesDir(), "shadow_demo-debug.apk");
        File odexFile = new File(getCacheDir(), "");
        if (file.exists()) {
            Log.d(Constant.TAG, "apkPath " + file.getAbsolutePath());
        } else {
            Log.d(Constant.TAG, "apkPath 不存在，" + file.getAbsolutePath());
        }
        BaseDexClassLoader baseDexClassLoader = new BaseDexClassLoader(file.getAbsolutePath(), odexFile, null, PPService.class.getClassLoader().getParent());
        Object o = baseDexClassLoader.loadClass("com.wwq.shadow_demo.TestService").newInstance();
        final Service service = (Service) o;
        if (isUiThread()) {
            service.onCreate();
            service.onStartCommand(new Intent(), 0, 10);
        } else {
            final CountDownLatch waitUiLock = new CountDownLatch(1);
            mUiHandler.post(new Runnable() {
                @Override
                public void run() {
                    service.onCreate();
                    service.onStartCommand(new Intent(), 0, 10);
                    waitUiLock.countDown();
                }
            });
            waitUiLock.await();
        }

    }

    private boolean isUiThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
