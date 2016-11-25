package bwf.androiddemos;

import android.util.Log;

/**
 * Created by Lizhangfeng on 2016/11/21 0021.
 * Description:
 */

public class MyUnCauthHandler implements Thread.UncaughtExceptionHandler {

    private static MyUnCauthHandler cauthHandler;

    public MyUnCauthHandler() {


    }
    public static void init(){
        cauthHandler = new MyUnCauthHandler();
        //替换系统捕获异常的对象
        Thread.setDefaultUncaughtExceptionHandler(cauthHandler);
    }

    //捕获到异常
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {

        if (ex != null)
            Log.e("Exception",ex.getMessage());

    }
}
