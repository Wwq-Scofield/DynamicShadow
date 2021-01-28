package com.wwq.self_shadow;

import android.content.Context;

import com.wwq.self_shadow.pps.PluginLoaderBinder;
import com.wwq.self_shadow.pps.PluginLoaderImpl;

public class LoaderFactoryImpl implements LoaderFactory {
    @Override
    public PluginLoaderImpl buildLoader(String uuid, Context context) {
        return new PluginLoaderBinder(new DynamicPluginLoader(uuid,context));
    }
}
