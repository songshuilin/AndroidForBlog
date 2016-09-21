package com.example.edu.androidforhandler;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/21.
 */

public class MyTask extends AsyncTask<Integer, Integer, String> {
    private TextView mTv;
    private Context mContext;

    public MyTask() {
    }

    public MyTask(TextView mTv, Context mContext) {
        this.mTv = mTv;
        this.mContext = mContext;
    }

    /*
    一般这个方法用来初始化工作
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    /*
    任务执行完然后调用，
     */
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mTv.setText(values[0] + "");
    }

    /*
    这个方法是在子线程执行的。我们必须要实现的方法
     */
    @Override
    protected String doInBackground(Integer... params) {
        for (int i = 0; i < 100; i++) {
            publishProgress(i);//执行这个方法，会回调onProgressUpdate这个方法。
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "100完成";
    }
}
