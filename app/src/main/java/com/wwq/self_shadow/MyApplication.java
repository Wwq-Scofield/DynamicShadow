package com.wwq.self_shadow;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import com.wwq.pluginlibrary.DelegateProviderHolder;
import com.wwq.pluginlibrary.GlobalContext;
import com.wwq.self_shadow.plugin.ShadowProvider;

import java.io.File;
import java.lang.reflect.Method;

public class MyApplication extends Application {
    public static Resources resources;
    @Override
    public void onCreate() {
        super.onCreate();
        GlobalContext.setApplication(this.getApplicationContext());
        DelegateProviderHolder.setDelegateProvider("test",new ShadowProvider());
        File file = new File(getFilesDir(), "resource.apk");
        CopyFileFromAssets.copy( this, "resource.apk", file);

        try {
//            PackageManager mPm= getPackageManager();
//            PackageInfo mInfo=mPm.getPackageArchiveInfo(file.getAbsolutePath(),PackageManager.GET_ACTIVITIES);
//            AssetManager assetManager = AssetManager.class.newInstance();
//            Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
//            addAssetPath.invoke(assetManager, file.getAbsolutePath());
//            Resources superRes = getResources();
//            resources=new Resources(assetManager, superRes.getDisplayMetrics(), superRes.getConfiguration());
        }catch (Exception E){

        }
    }
}
