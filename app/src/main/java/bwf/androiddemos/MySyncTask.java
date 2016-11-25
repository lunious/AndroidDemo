package bwf.androiddemos;

import android.os.AsyncTask;
import android.util.Log;

import bwf.androiddemos.http.MyRequest;
import bwf.androiddemos.http.Result;

/**
 * Created by Lizhangfeng on 2016/11/21 0021.
 * Description:
 */

public class MySyncTask extends AsyncTask<MyRequest,Integer,Result> {

    @Override
    protected Result doInBackground(MyRequest... params) {//相当于Thread 的run方法（执行子线程操作的）
        MyRequest myRequest = null;
        if (params != null)
            myRequest = params[0];

        Log.e("params",""+myRequest.params.toString());

        //此处为网络请求...

        Result result = new Result();
        result.result = "";
        return result;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        Log.e("tag","------接口请求的进度为："+values);
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Result result) {//主线程操作,result为doInBackground完成之后返回的

        super.onPostExecute(result);
    }
}
