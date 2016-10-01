package com.example.edu.androidforsqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.edu.androidforsqlite.edu.jju.help.MyHelper;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private MyHelper helper;
    private EditText mEtName, mEtAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       helper=new MyHelper(MainActivity.this,"song.db",null,1);
       db = helper.getWritableDatabase();//返回一个SQLiteDatabase实例

        initWidgets();
    }

    /**
     * 初始化各控件
     */
    private void initWidgets() {
        mEtAge = (EditText) findViewById(R.id.age);
        mEtName = (EditText) findViewById(R.id.name);
    }

    /**
     * 插入数据
     *
     * @param view
     */
    public void insert(View view) {
        String name = mEtName.getText().toString();
        String age = mEtAge.getText().toString();
        db.execSQL("insert into  person (name,age)"
                        + "values(?,?)",
                new String[]{name, age}
        );
        Toast.makeText(MainActivity.this,"插入成功",Toast.LENGTH_SHORT).show();

    }
    /**
     * 查询所有数据
     */
    public void select (View view){
        db.rawQuery("select * from person",null);
        Toast.makeText(MainActivity.this,"查询成功",Toast.LENGTH_SHORT).show();
    }
    /**
     * 修改数据
     */
    public void update(View view){
        //我传进去的数据写死了，我只是给演示下。
        db.execSQL("update person set name=?,age=?"
        ,new String[]{"xiaosong","34"}
        );

    }

    /**
     * 删除数据
     * @param view
     */
    public void delete(View view){
        //根据名字来删除，只是掩饰下怎么用，关键学会sql语句
        db.execSQL("delete from person where name=?"
        ,new String[]{"song"}
        );

    }


}

