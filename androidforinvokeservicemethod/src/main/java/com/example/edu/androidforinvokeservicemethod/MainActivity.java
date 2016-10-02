package com.example.edu.androidforinvokeservicemethod;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private MyService.MyBinder myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, MyService.class);
    }

    ServiceConnection myConn = new ServiceConnection() {
        //绑定服务时调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder) service;
        }

        //解除绑定时调用
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    /**
     * 绑定服务
     *
     * @param view
     */
    public void bind(View view) {
        bindService(intent, myConn, BIND_AUTO_CREATE);
    }

    /**
     * 解绑服务
     *
     * @param view
     */
    public void unbind(View view) {
        unbindService(myConn);
    }

    /**
     * 调用服务中的方法
     *
     * @param view
     */
    public void invoke(View view) {

        myBinder.getName();
    }
}
