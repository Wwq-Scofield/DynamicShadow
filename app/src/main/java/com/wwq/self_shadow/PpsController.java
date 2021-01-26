package com.wwq.self_shadow;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import static android.os.IBinder.FIRST_CALL_TRANSACTION;
import static com.wwq.self_shadow.PPSBinder.TRANSACTION_CODE_FAILED_EXCEPTION;
import static com.wwq.self_shadow.PPSBinder.TRANSACTION_CODE_NO_EXCEPTION;

/**
 *
 */
public class PpsController {
    final private IBinder mRemote;

    public PpsController(IBinder ppsBinder) {
        mRemote = ppsBinder;
    }

    public void setUUID(String uuid) throws RemoteException, FailedException{
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        try {
            _data.writeInterfaceToken(PPSBinder.DESCRIPTOR);
            _data.writeString(uuid);
            mRemote.transact(PPSBinder.TRANSACTION_SET_UUID, _data, _reply, 0);
            int i = _reply.readInt();
            if (i == TRANSACTION_CODE_FAILED_EXCEPTION) {
                throw new FailedException(_reply);
            } else if (i != TRANSACTION_CODE_NO_EXCEPTION) {
                throw new RuntimeException("不认识的Code==" + i);
            }
        } finally {
            _reply.recycle();
            _data.recycle();
        }
    }
    public void startService(String uuid) throws RemoteException, FailedException{
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        try {
            _data.writeInterfaceToken(PPSBinder.DESCRIPTOR);
            _data.writeString(uuid);
            mRemote.transact(PPSBinder.TRANSACTION_START_SERVICE, _data, _reply, 0);
            int i = _reply.readInt();
            if (i == TRANSACTION_CODE_FAILED_EXCEPTION) {
                throw new FailedException(_reply);
            } else if (i != TRANSACTION_CODE_NO_EXCEPTION) {
                throw new RuntimeException("不认识的Code==" + i);
            }
        } finally {
            _reply.recycle();
            _data.recycle();
        }
    }

}
