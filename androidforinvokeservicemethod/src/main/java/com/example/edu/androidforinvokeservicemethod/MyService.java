package com.example.edu.androidforinvokeservicemethod;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    public class MyBinder extends Binder {
        public void getName() {
            getMethodInService();
        }
    }

    public void getMethodInService() {
        Log.i("TAG", "我是来自服务中的方法");
    }

    @Override
    public IBinder onBind(Intent intent) {

        return new MyBinder();
    }
}
