package bwf.androiddemos;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Lizhangfeng on 2016/11/21 0021.
 * Description:
 */

public class MyService extends Service {

    private Timer timer;
    private TimerTask task;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        startTask();

        return super.onStartCommand(intent, flags, startId);
    }

    public void startTask(){

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {

                if (!isNetDeviceAvailable(MyService.this)){
                    //
//                    new Handler().post(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(MyService.this,"断网了",Toast.LENGTH_SHORT).show();
//                        }
//                    });

                    Looper.prepare();
                    Toast.makeText(MyService.this,"断网了",Toast.LENGTH_SHORT).show();
                    Looper.loop();
                    Log.e("tag","断网了");//此处不会执行
                }

            }
        };

        timer.schedule(task,1000,5*1000);

    }

    /*
     * 判断网络连接是否已开 2012-08-20true 已打开 false 未打开
     */
    public static boolean isNetDeviceAvailable(Context context) {
        boolean bisConnFlag = false;
        ConnectivityManager conManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = conManager.getActiveNetworkInfo();
        if (network != null) {
            bisConnFlag = conManager.getActiveNetworkInfo().isAvailable();
        }
        return bisConnFlag;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
    }

}
