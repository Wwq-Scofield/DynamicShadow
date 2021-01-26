package com.wwq.self_shadow;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class CopyFileFromAssets {
    /**
     * @param myContext
     * @param ASSETS_NAME 要复制的文件名
     *                    testCopy(Context context)是一个测试例子。
     */
    public static void copy(Context myContext, String ASSETS_NAME,
                            File file) {
        // 如果目录不中存在，创建这个目录
        try {
            if ((file).exists()) {
                (file).delete();
            }
            if (!(file).exists()) {
                InputStream is = myContext.getResources().getAssets()
                        .open(ASSETS_NAME);
                if (is == null) {
                    Log.d(Constant.TAG,"is is null ");
                    return;
                }
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buffer = new byte[7168];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
                if(file.exists()){
                    Log.d(Constant.TAG,"file exist "+file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(Constant.TAG,"e = "+e.toString());
        }
    }


}