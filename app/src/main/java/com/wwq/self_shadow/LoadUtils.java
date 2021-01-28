package com.wwq.self_shadow;

import android.app.Service;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;

import java.util.concurrent.CountDownLatch;

public class LoadUtils  {
    public   void startService(String s) {
        Log.d(Constant.TAG,"s = "+s);
//        try {
//            Object o = getClassLoader().loadClass("com.wwq.shadow_demo.TestService").newInstance();
//            Service service=(Service)o;
//            service.onCreate();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
    }

}
