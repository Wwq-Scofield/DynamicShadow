package com.wwq.pluginlibrary;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

public class ShadowAppComponentFactory {

    public ShadowApplication instantiateApplication(ClassLoader cl,
                                                    String className)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ShadowApplication) cl.loadClass(className).newInstance();
    }



    public BroadcastReceiver instantiateReceiver(ClassLoader cl,
                                                 String className, Intent intent)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (BroadcastReceiver) cl.loadClass(className).newInstance();
    }


    public ContentProvider instantiateProvider(ClassLoader cl,
                                               String className)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ContentProvider) cl.loadClass(className).newInstance();
    }
}
