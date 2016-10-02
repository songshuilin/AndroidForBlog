package com.example.edu.androidforservicesimple;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    private Intent intent;


    ServiceConnection myConn = new ServiceConnection() {
        //当服务被绑定时调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected:.... ");
        }

        //当服务被解绑是调用
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: ...........");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, MyService.class);
    }

    public void start(View view) {
        bindService(intent, myConn, BIND_AUTO_CREATE);
    }

    public void stop(View view) {
        unbindService(myConn);

    }
}
