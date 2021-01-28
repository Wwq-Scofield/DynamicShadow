package com.wwq.self_shadow.other;

import android.content.Context;

import com.wwq.self_shadow.other.DynamicPluginLoader;
import com.wwq.self_shadow.other.LoaderFactory;
import com.wwq.self_shadow.pps.PluginLoaderBinder;
import com.wwq.self_shadow.pps.PluginLoaderImpl;

public class LoaderFactoryImpl implements LoaderFactory {
    @Override
    public PluginLoaderImpl buildLoader(String uuid, Context context) {
        return new PluginLoaderBinder(new DynamicPluginLoader(uuid,context));
    }
}
