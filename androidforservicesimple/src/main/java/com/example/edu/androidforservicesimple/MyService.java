package com.example.edu.androidforservicesimple;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG="TAG";
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: .....");
        return null;
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate: ........");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ...........");
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 已过时的方法
     * @param intent
     * @param startId
     */
    @Override
    public void onStart(Intent intent, int startId) {
        Log.i(TAG, "onStart: .........");
        super.onStart(intent, startId);
    }
    
    

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: ..........");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG, "onRebind: .........");
        super.onRebind(intent);
    }


    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ..............");
        super.onDestroy();
    }
}
