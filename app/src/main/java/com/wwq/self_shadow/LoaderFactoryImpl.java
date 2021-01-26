package com.wwq.self_shadow;

import android.content.Context;

public class LoaderFactoryImpl implements LoaderFactory {
    @Override
    public PluginLoaderImpl buildLoader(String uuid, Context context) {
        return new PluginLoaderBinder(new DynamicPluginLoader(uuid,context));
    }
}
