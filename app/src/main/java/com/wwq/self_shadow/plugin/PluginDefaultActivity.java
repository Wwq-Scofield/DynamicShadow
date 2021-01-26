package com.wwq.self_shadow.plugin;

import com.wwq.pluginlibrary.PluginContainerActivity;

public class PluginDefaultActivity extends PluginContainerActivity {
    @Override
    protected String getDelegateProviderKey() {
        return "test";
    }
}
