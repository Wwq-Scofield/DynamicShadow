package com.wwq.self_shadow.plugin;

import android.util.Log;

import com.wwq.pluginlibrary.PluginContainerActivity;
import com.wwq.self_shadow.Constant;

import static com.wwq.self_shadow.plugin.ShadowActivityDelegate.getCurrentProcessName;

public class PluginDefaultActivity extends PluginContainerActivity {
    public PluginDefaultActivity() {

    }

    @Override
    protected String getDelegateProviderKey() {
        return "test";
    }
}
