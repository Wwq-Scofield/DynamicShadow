package com.wwq.self_shadow.other;

import android.content.Context;
import android.util.Log;

import com.wwq.self_shadow.Constant;

public class DynamicPluginLoader {
    public DynamicPluginLoader(String uuid, Context context) {

    }

    public void startService(String s) {
        Log.d(Constant.TAG,"DynamicPluginLoader -> startService");
    }
}
