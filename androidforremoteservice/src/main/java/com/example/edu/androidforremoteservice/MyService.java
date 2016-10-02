package com.example.edu.androidforremoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    public class MyBinder extends Person.Stub {

        @Override
        public void getName() throws RemoteException {
            getMethodInService();
        }
    }

    public void getMethodInService(){

        Log.i("TAG", " 我是来自远程服务中的方法。。。。 ");

    }
    @Override
    public IBinder onBind(Intent intent) {

        return new MyBinder();
    }
}
