package com.wwq.self_shadow;

import android.app.Application;

import com.wwq.pluginlibrary.DelegateProviderHolder;
import com.wwq.pluginlibrary.GlobalContext;
import com.wwq.self_shadow.plugin.ShadowProvider;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GlobalContext.setApplication(this.getApplicationContext());
        DelegateProviderHolder.setDelegateProvider("test",new ShadowProvider());
    }
}
