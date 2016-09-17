package com.example.edu.androidforblog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button mBtn_com, mBtn_progress, mBtn_time,mBtn_date;
    private AlertDialog.Builder mDialog;
    private ProgressDialog mProgressDialog;
    private TimePickerDialog mTimeDialog;
    private DatePickerDialog mDateDialog;



    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x123) {
                Toast.makeText(MainActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();//初始化控件
//普通按钮点击事件
        mBtn_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog = new AlertDialog.Builder(MainActivity.this);
                mDialog.setTitle("this is title");//设置标题
                mDialog.setIcon(R.mipmap.ic_launcher);//设置图标
                mDialog.setMessage("this is a content");//对话框里的内容
                mDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                mDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你点击了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                mDialog.setCancelable(false);
                mDialog.show();//此方法是显示对话框

            }
        });
        //为进度条按钮添加点击事件
        mBtn_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressDialog = new ProgressDialog(MainActivity.this);
                mProgressDialog.setIcon(R.mipmap.ic_launcher);
                mProgressDialog.setTitle("this is a title");
                mProgressDialog.setMessage("this is a content");

                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//水平的进度条
                // mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//环形进度条
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        for (int i = 0; i < 100; i++) {
                            mProgressDialog.setProgress(i);
                            try {
                                sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        mProgressDialog.dismiss();
                        handler.sendEmptyMessage(0x123);
                    }
                }.start();

                mProgressDialog.setCancelable(false);
                mProgressDialog.show();
            }
        });
        //时间按钮添加点击事件
        mBtn_time.setOnClickListener(new View.OnClickListener() {
            Calendar clc=Calendar.getInstance();//获取日历对象
           int  HOUR= clc.get(Calendar.HOUR_OF_DAY);//获取当前的时
            int MINTUE=clc.get(Calendar.MINUTE);//获取当前的分

            @Override
            public void onClick(View v) {
                mTimeDialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(MainActivity.this,"你选的时间为："+hourOfDay+":"+minute,Toast.LENGTH_SHORT).show();
                    }
                },HOUR,MINTUE,true);

                mTimeDialog.setCancelable(false);
                mTimeDialog.show();
            }
        });
        //为日期按钮添加点击事件
        mBtn_date.setOnClickListener(new View.OnClickListener() {
            Calendar clc=Calendar.getInstance();//获取日历对象
            int YEAR=clc.get(Calendar.YEAR);//获取当前年份
            int MONTH=clc.get(Calendar.MONTH);//获取当前的月份
            int DAY=clc.get(Calendar.DAY_OF_MONTH);//获取当前的天
            @Override
            public void onClick(View v) {
                mDateDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Toast.makeText(MainActivity.this,"你选的日期为："+year+"-"+(monthOfYear+1)+"-"+dayOfMonth,Toast.LENGTH_SHORT).show();
                    }
                },YEAR,MONTH,DAY);
                mDateDialog.setCancelable(false);
                mDateDialog.show();
            }
        });
    }

    //初始化各控件
    private void initWidgets() {
        mBtn_com = (Button) findViewById(R.id.id_commen);
        mBtn_progress = (Button) findViewById(R.id.id_progress);
        mBtn_time = (Button) findViewById(R.id.id_time);
        mBtn_date= (Button) findViewById(R.id.id_date);
    }
}
