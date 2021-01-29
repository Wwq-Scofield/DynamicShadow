package com.wwq.self_shadow;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wwq.pluginlibrary.GlobalContext;
import com.wwq.self_shadow.pps.PpsController;

import java.io.File;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ProgressBar tips;
    private TextView tvtips;
    private LinearLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        tips = findViewById(R.id.tips);
        tvtips = findViewById(R.id.tvtips);
        parent = findViewById(R.id.parent);
        Log.d(Constant.TAG, "MainActivity onCreate");
        startService(new Intent(this, TestService.class));
        new Thread(new Runnable() {
            @Override
            public void run() {

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
//            startActivities();
            tips.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Constant.apk = Constant.apk_max;
                        File file = new File(getFilesDir(), Constant.apk);
                        CopyFileFromAssets.copy(MainActivity.this, Constant.apk, file);
                        ppsController.loadPlugin("max");
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tips.setVisibility(View.GONE);
                                try {
                                    ppsController.startPluginActivity();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        Log.e(Constant.TAG, e.toString());
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadPluginMin(View view) {
        tips.setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Constant.apk = Constant.apk_min;
                    File file = new File(getFilesDir(), Constant.apk);
                    CopyFileFromAssets.copy(MainActivity.this, Constant.apk, file);
                    ppsController.loadPlugin("min");
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tips.setVisibility(View.GONE);
                            try {
                                ppsController.startPluginActivity();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (RemoteException e) {
                    e.printStackTrace();
                    Log.d(Constant.TAG, "--- " + e.toString());
                }
            }
        }).start();
    }

    public void loadResource(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {


                    File file = new File(getFilesDir(), "resource.apk");
                    CopyFileFromAssets.copy(MainActivity.this, "resource.apk", file);
                    final Resources resTest = PackageResManager.createResource(MainActivity.this, file, "resTest");
                    //下面注释的这种方式获取resource，需要安装才能获取到
//                    Context packageContext = createPackageContext("com.wwq.restest", Context.CONTEXT_IGNORE_SECURITY);
//                    final Resources resTest = packageContext.getResources();
                    final int identifier = resTest.getIdentifier("plugin_color", "color", "com.wwq.restest");
                    Log.d(Constant.TAG, " - " + resTest.getColor(identifier));
                    int identifier1 = resTest.getIdentifier("plugin_tips", "string", "com.wwq.restest");
                    final int identifier2 = resTest.getIdentifier("waring", "drawable", "com.wwq.restest");
                    final CharSequence string = resTest.getText(identifier1);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvtips.setText(string);
                            tvtips.setTextColor(resTest.getColor(identifier));
                            tvtips.setBackgroundDrawable(resTest.getDrawable(identifier2));
                        }
                    });
                    Log.d(Constant.TAG, "string= " + string);
                } catch (Exception e) {
                    Log.d(Constant.TAG, " - " + e.toString());
                }
            }
        }).start();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(Constant.TAG, "requestCode =" + requestCode + " resultCode= " + resultCode);
    }

    PpsController ppsController;

    private void connectPPService() {
        File file = new File(getFilesDir(), Constant.apk);
        CopyFileFromAssets.copy(MainActivity.this, Constant.apk, file);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getApplication().getApplicationContext(), "com.wwq.self_shadow.PPService"));
        startService(intent);
        GlobalContext.getAppContext().bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d(Constant.TAG, "onServiceConnected ： " + name.getClassName());
                ppsController = PPService.wrapBinder(service);
//                try {
//                    ppsController.setUUID("uuuuuuuuuu");
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                } catch (FailedException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    ppsController.startService("4345");
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                } catch (FailedException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    Log.d(Constant.TAG, "userInfo = " + ppsController.getUserInfo().name);
////                    Log.d(Constant.TAG,"userInfo = "+Constant.userInfo.name);
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                } catch (FailedException e) {
//                    e.printStackTrace();
//                } catch (NullPointerException e) {
//                    e.printStackTrace();
//                }

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d(Constant.TAG, "onServiceDisconnected: " + name.getClassName());
            }
        }, BIND_AUTO_CREATE);
    }


}
