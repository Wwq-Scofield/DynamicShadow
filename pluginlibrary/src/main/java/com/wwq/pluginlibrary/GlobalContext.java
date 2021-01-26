package com.wwq.pluginlibrary;

import android.app.Application;
import android.content.Context;

public class GlobalContext {
    private GlobalContext() {
    }

    private static Context sAppContext;

    public static void setApplication(Context application) {
        if (application != null) {
            sAppContext = application.getApplicationContext();
        }
    }

    public static Context getAppContext() {
        assert sAppContext != null;
        return sAppContext;
    }

}