package com.example.edu.androidforlinstener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyButton mBtn;//声明mBtn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = (MyButton) findViewById(R.id.btn);//获取mBtn对象
        mBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("TAG", " 该按钮触摸事件被处理了。。。");

                //false代表的意思是该事件传到这里不截断，还是向外抛
                return false;
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TAG", " MainActivity 这个类中的onTouchEvent这个方法被被执行。。。");

        //false代表的意思是该事件传到这里不截断，还是向外抛
        return false;
    }
}
