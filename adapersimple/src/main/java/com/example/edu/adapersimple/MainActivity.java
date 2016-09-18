package com.example.edu.adapersimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView mLv;
    private List<PersonBean>list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();//初始化控件
        initDatas();//获取数据
        /*
        两个参数的含义：
        1，数据源 2，上下文
        这是第三步
        */
      MyAdapter adapter=new MyAdapter(list,MainActivity.this);
        //这是第四步
        mLv.setAdapter(adapter);

    }

    //初始化控件
    private void initWidgets() {
        //这是第一步 。初始化ListView
        mLv= (ListView) findViewById(R.id.listView);
    }
    //初始化数据
    private void initDatas(){
        //这是第二部。获取数据
        for (int i = 0; i <15 ; i++) {
          PersonBean bean=new PersonBean();
            bean.setIdImg(R.mipmap.ic_launcher);
            bean.setName("我真不是程序员"+i);
            list.add(bean);
        }
    }
}
