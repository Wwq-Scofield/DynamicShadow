package com.wwq.self_shadow.plugin;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Pair;

import com.wwq.pluginlibrary.GeneratedHostActivityDelegator;
import com.wwq.pluginlibrary.ShadowContext;

public class PluginComponentLauncherImpl implements ShadowContext.PluginComponentLauncher {
    @Override
    public boolean startActivity(ShadowContext shadowContext, Intent intent, Bundle options) {
        Intent pluginIntent = new Intent(shadowContext, PluginDefaultActivity.class);
        Bundle bundle= new Bundle();
        bundle.putString("className","com.wwq.shadow_demo.SecendActivity");
        pluginIntent.putExtras(bundle);
        shadowContext.superStartActivity(pluginIntent, options);
       return true;
    }

    @Override
    public boolean startActivityForResult(GeneratedHostActivityDelegator delegator, Intent intent, int requestCode, Bundle option, ComponentName callingActivity) {
        return false;
    }

    @Override
    public Pair<Boolean, ComponentName> startService(ShadowContext context, Intent service) {
        return null;
    }

    @Override
    public Pair<Boolean, Boolean> stopService(ShadowContext context, Intent name) {
        return null;
    }

    @Override
    public Pair<Boolean, Boolean> bindService(ShadowContext context, Intent service, ServiceConnection conn, int flags) {
        return null;
    }

    @Override
    public Pair<Boolean, ?> unbindService(ShadowContext context, ServiceConnection conn) {
        return null;
    }

    @Override
    public Intent convertPluginActivityIntent(Intent pluginIntent) {
        return null;
    }
}
