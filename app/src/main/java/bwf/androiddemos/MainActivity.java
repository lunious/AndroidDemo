package bwf.androiddemos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import java.util.HashMap;
import java.util.List;

import bwf.androiddemos.http.MyRequest;
import bwf.androiddemos.utils.ToastUtil;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener, Handler.Callback {

    private BlankFragment fragment_blank;
    private RelativeLayout activity_main;

    private SwipeRefreshLayout refresh;//下拉刷新

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        getSupportActionBar().hide();

        activity_main = (RelativeLayout) findViewById(R.id.activity_main);
        fragment_blank = (BlankFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_blank);

        refresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
//        refresh.setColorSchemeColors();
//        refresh.canChildScrollUp();
//        refresh.setProgressBackgroundColorSchemeColor();

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ToastUtil.showToast("下拉刷新了");
                refresh.setRefreshing(false);
            }
        });

//        testFragment();
//        testIntent();
//        testService();
//        testMain();
//        testHandler();

//        testReceiver();
//        testAsynctask();

//        testException();




    }

    private void testException() {
        MyUnCauthHandler.init();
        String str = null;
        str.equals("1");
    }

    private void testAsynctask() {
        MyRequest myRequest = new MyRequest();
        myRequest.params = new HashMap<>();
        myRequest.params.put("name","lizhang");
        MySyncTask mySyncTask = new MySyncTask();
        mySyncTask.execute(myRequest);
    }

    private void testFragment() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();

        for (Fragment fragment : fragments){
            if (fragment instanceof BlankFragment){
                fragment_blank = (BlankFragment) fragment;
                //....
            }
        }
    }

    private void testReceiver() {
        sendBroadcast(new Intent("com.bwf.action.test"));

        //手动注册广播(优先级一样的时候手动注册比静态注册先收到)
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("com.bwf.action.test");
//        intentFilter.setPriority(1000);
//        //注册
//        registerReceiver(new MyRevicer(), intentFilter);

        //取消注册
//        unregisterReceiver(new MyRevicer());
    }

    private void testHandler() {
        Handler handle = new Handler(this);
        handle.sendEmptyMessage(1);

        Bitmap bitmap = null;
        Message message = Message.obtain();
        message.what = 1;//消息的id
        message.obj = bitmap;//传递数据的
        message.arg1 = 2;
    }

    private void testIntent() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);

        Intent intent2 = new Intent(Intent.ACTION_CALL);
        Intent intent1 = new Intent();
        intent.setClassName("com.bwf.wx","com.bwf.wx.MainActivity");
    }

    private void testService() {
        Intent serviceIntent = new Intent(this, MyService.class);
        //启动了Service
        startService(serviceIntent);

        //绑定service
//        bindService(serviceIntent, new ServiceConnection() {
//            @Override
//            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//
//            }
//
//            @Override
//            public void onServiceDisconnected(ComponentName componentName) {
//
//            }
//        },CONTEXT_IGNORE_SECURITY);
    }

    private void testMain() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });

        activity_main.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }


    @Override
    public void onFragmentInteraction(String uri) {

    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//    }

//    @Override
//    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//    }

    //被系统杀死保存数据
    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        outState.putParcelable("key");
        super.onSaveInstanceState(outState);
    }

    //被系统杀死恢复
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {

        }

        super.onRestoreInstanceState(savedInstanceState);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        if (hasFocus){
            //此处可以获取View的高度
        }
        super.onWindowFocusChanged(hasFocus);

    }
}
