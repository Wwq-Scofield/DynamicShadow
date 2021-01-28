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
import com.wwq.pluginlibrary.ShadowService;

import java.io.File;
import java.util.concurrent.CountDownLatch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TestService extends ShadowService implements ITest {
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
        return super.onStartCommand(intent, flags, startId);
    }
}
