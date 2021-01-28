package com.wwq.self_shadow.pps;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;

import com.wwq.self_shadow.DynamicPluginLoader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PluginLoaderBinder extends Binder implements PluginLoaderImpl {
    private DynamicPluginLoader mDynamicPluginLoader;
    public PluginLoaderBinder(DynamicPluginLoader dynamicPluginLoader) {
        this.mDynamicPluginLoader = dynamicPluginLoader;
    }

    @Override
    public void setUuidManager(UuidManager uuidManager) {

    }

    @Override
    protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
        switch (code){
            case PPSBinder.TRANSACTION_START_SERVICE:
                data.enforceInterface(PPSBinder.DESCRIPTOR);
                String s = data.readString();
                mDynamicPluginLoader.startService(s);
                break;
        }
        return super.onTransact(code, data, reply, flags);
    }
}
