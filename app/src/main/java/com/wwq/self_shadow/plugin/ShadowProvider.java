package com.wwq.self_shadow.plugin;

import com.wwq.pluginlibrary.DelegateProvider;
import com.wwq.pluginlibrary.DelegateProviderHolder;
import com.wwq.pluginlibrary.HostActivityDelegate;
import com.wwq.pluginlibrary.HostActivityDelegator;

public class ShadowProvider implements DelegateProvider {

    @Override
    public HostActivityDelegate getHostActivityDelegate(Class<? extends HostActivityDelegator> delegator) {
        return new ShadowActivityDelegate();
    }
}
