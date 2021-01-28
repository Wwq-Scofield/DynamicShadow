package com.wwq.self_shadow;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wwq.pluginlibrary.GlobalContext;
import com.wwq.self_shadow.pps.FailedException;
import com.wwq.self_shadow.pps.PpsController;

import java.io.File;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ProgressBar tips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        tips = findViewById(R.id.tips);
        Log.d(Constant.TAG, "MainActivity onCreate");
        startService(new Intent(this, TestService.class));
        new Thread(new Runnable() {
            @Override
            public void run() {
                File file = new File(getFilesDir(), "shadow_demo-debug.apk");
                CopyFileFromAssets.copy(MainActivity.this, "shadow_demo-debug.apk", file);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

//                        startActivity(new Intent(MainActivity.this,TestActivity.class));
                        connectPPService();
                    }
                });

            }
        }).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                try {
////                    ppsController.exit();
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                } catch (FailedException e) {
//                    e.printStackTrace();
//                }
            }
        }, 3000);
    }

    public void loadPlugin(View view) {
        try {
//            ppsController.startPluginActivity();
            // TODO:
            //  1. 如果是在主进程中，通过actiivty  startActivityForResult是可以启动的
//            Intent intent = new Intent(this, PluginDefaultActivity.class);
//            startActivityForResult(intent,2000);
            // TODO:
            //  2. 如果是在子进程中，从宿主启动插件，插件也是在子进程启动的，没有actiivty支撑startActivityForResult的环境，因为
            //  startActivityForResult是activity的方法
            // TODO:
            //  3. 如果一定要做，通过启动一个透明的activity来作为这个startForResult的环境，再通过通信告诉宿主
            tips.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ppsController.loadPlugin();
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tips.setVisibility(View.GONE);
                                try {
                                    ppsController.startPluginActivity();
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(Constant.TAG, "requestCode =" + requestCode + " resultCode= " + resultCode);
    }

    PpsController ppsController;

    private void connectPPService() {
        File file = new File(getFilesDir(), "shadow_demo-debug.apk");
        CopyFileFromAssets.copy(MainActivity.this, "shadow_demo-debug.apk", file);
        Intent intent = new Intent();

        intent.setComponent(new ComponentName(getApplication().getApplicationContext(), "com.wwq.self_shadow.PPService"));
        startService(intent);
        GlobalContext.getAppContext().bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d(Constant.TAG, "onServiceConnected ： " + name.getClassName());
                ppsController = PPService.wrapBinder(service);
                try {
                    ppsController.setUUID("uuuuuuuuuu");
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (FailedException e) {
                    e.printStackTrace();
                }
                try {
                    ppsController.startService("4345");
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (FailedException e) {
                    e.printStackTrace();
                }
                try {
                    Log.d(Constant.TAG, "userInfo = " + ppsController.getUserInfo().name);
//                    Log.d(Constant.TAG,"userInfo = "+Constant.userInfo.name);
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (FailedException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d(Constant.TAG, "onServiceDisconnected: " + name.getClassName());
            }
        }, BIND_AUTO_CREATE);
    }


}
