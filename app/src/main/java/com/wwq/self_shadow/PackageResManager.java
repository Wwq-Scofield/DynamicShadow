package com.wwq.self_shadow;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;

import com.wwq.pluginlibrary.ShadowContext;

import java.io.File;

public class PackageResManager {
    public static ApplicationInfo applicationInfo;

    public static Resources createResource(Context context,File file,String pluginKey) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(),
                PackageManager.GET_ACTIVITIES
                        | PackageManager.GET_META_DATA
                        | PackageManager.GET_SERVICES
                        | PackageManager.GET_PROVIDERS
                        | PackageManager.GET_SIGNATURES);
        packageArchiveInfo.applicationInfo.nativeLibraryDir = null;

        File dataDir = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dataDir = context.getDataDir();
        } else {
            dataDir = new File(context.getFilesDir(), pluginKey);
        }
        dataDir.mkdirs();
        packageArchiveInfo.applicationInfo.dataDir = dataDir.getAbsolutePath();
        applicationInfo = packageArchiveInfo.applicationInfo;
        try {
            Resources resources = create(packageArchiveInfo, file.getAbsolutePath(), context);
            return resources;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.e(Constant.TAG, "msg = " + e.toString());
        }
        return null;
    }

    public static Resources create(
            //插件的packageInfo
            PackageInfo packageArchiveInfo,
            //插件的apk地址
            String archiveFilePath,
            final Context hostAppContext) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = hostAppContext.getPackageManager();
        packageArchiveInfo.applicationInfo.publicSourceDir = archiveFilePath;
        packageArchiveInfo.applicationInfo.sourceDir = archiveFilePath;
        packageArchiveInfo.applicationInfo.sharedLibraryFiles = hostAppContext.getApplicationInfo().sharedLibraryFiles;
        return packageManager.getResourcesForApplication(packageArchiveInfo.applicationInfo);
    }
}
