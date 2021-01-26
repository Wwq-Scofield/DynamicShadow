package com.wwq.self_shadow;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 *
 */
public class PPSBinder extends Binder {
    static final String DESCRIPTOR = PPSBinder.class.getName();
    static final int TRANSACTION_CODE_NO_EXCEPTION = 0;
    static final int TRANSACTION_CODE_FAILED_EXCEPTION = 1;
    static final int TRANSACTION_SET_UUID = 2;
    static final int TRANSACTION_START_SERVICE = 3;


    private PPService ppService;

    public PPSBinder(PPService ps) {
        this.ppService = ps;
    }

    @Override
    protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
        data.enforceInterface(DESCRIPTOR);
        String _arg0  = data.readString();
        Log.d(Constant.TAG, " code = " + code+" _arg0 ="+_arg0);
        switch (code){
            case TRANSACTION_SET_UUID:
                break;
            case TRANSACTION_START_SERVICE:
                try {
                    ppService.startService();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(Constant.TAG,"e = "+e.toString());
                }
                break;
        }
        return super.onTransact(code, data, reply, flags);
    }
}
