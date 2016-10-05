package com.example.edu.androidforbroadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * 这是绑定按钮添加的事件
     * @param view
     */
    public void send(View view) {
        Intent intent = new Intent();
        intent.setAction("edu.jju.broadcastreceiver");
        sendOrderedBroadcast(intent,null);//发送有序广播
      //  sendBroadcast(intent);//发送普通广播
    }
}
