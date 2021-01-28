package com.wwq.pluginlibrary;

import android.util.Log;

import java.io.File;

import dalvik.system.BaseDexClassLoader;

public class PluginClassLoader extends BaseDexClassLoader {
    public PluginClassLoader(String dexPath, File optimizedDirectory, String librarySearchPath, ClassLoader parent) {
        super(dexPath, optimizedDirectory, librarySearchPath, parent);
    }
    @Override
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
//        if (className.contains("wwq")) {
//            return loaderClassLoader.loadClass(className);
//        }
        return super.loadClass(className, resolve);
    }
}
