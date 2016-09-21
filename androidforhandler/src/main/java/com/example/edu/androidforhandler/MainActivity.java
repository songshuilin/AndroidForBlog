package com.example.edu.androidforhandler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtn;
    private TextView mTv;
    int tempNumber;

    //定义一个hangler，并重写了里面的方法、
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (tempNumber == 99) {
                Toast.makeText(MainActivity.this, "100完成", Toast.LENGTH_SHORT).show();
            }
            if (msg.what == 0x123) {
                mTv.setText(tempNumber + "");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = (Button) findViewById(R.id.btn);
        mTv = (TextView) findViewById(R.id.number_tv);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask task=new MyTask(mTv,MainActivity.this);
                task.execute();  
            }
        });



//        //为按钮添加点击事件
//        mBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        for (int i = 0; i < 100; i++) {
//                            tempNumber = i;
//                            handler.sendEmptyMessage(0x123);
//                            try {
//                                Thread.sleep(50);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//
//                        }
//
//                    }
//                }).start();
//            }
//        });

    }
}
