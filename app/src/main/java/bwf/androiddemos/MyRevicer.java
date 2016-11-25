package bwf.androiddemos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Lizhangfeng on 2016/11/21 0021.
 * Description:
 */

public class MyRevicer extends BroadcastReceiver {

    //接收消息
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"断网了",Toast.LENGTH_SHORT).show();

    }
}
