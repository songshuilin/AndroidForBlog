package com.example.edu.androidforcontentprovidersimple;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 插入数据
     * @param view
     */
    public void insert(View view){
        //通过这个contentResolver来访问
        ContentResolver contentResolver=getContentResolver();
        ContentValues values=new ContentValues();
        values.put("name","张三");
        values.put("major","android");
        contentResolver.insert(Uri.parse("content://edu.jju.song/insert"),values);
        Toast.makeText(this,"插入成功！！！",Toast.LENGTH_SHORT).show();
    }

    /**
     * 删除数据
     * @param view
     */
    public void delete(View view){
        ContentResolver contentResolver=getContentResolver();
        //数据写死了，就是根据id=1删除，只是演示下
        contentResolver.delete(Uri.parse("content://edu.jju.song/delete"),"id=?",new String[]{"1"});
        Toast.makeText(this,"删除成功！！！",Toast.LENGTH_SHORT).show();
    }

    /**
     * 修改数据
     */
    public void update(View view){
        ContentResolver contentResolver=getContentResolver();
        ContentValues values=new ContentValues();
        values.put("name","李四");
        values.put("major","java");
        //只是演示下 ，数据写死了
        contentResolver.update(Uri.parse("content://edu.jju.song/update"),values,"id=?",new String[]{"1"});
        Toast.makeText(this,"修改成功！！！",Toast.LENGTH_SHORT).show();
    }
    /**
     * 查询数据
     */
    public void select(View view){
        ContentResolver contentResolver=getContentResolver();
        //查询所有数据
       Cursor cursor= contentResolver.query(Uri.parse("content://edu.jju.song/select"),null,null,null,null);
      while (cursor.moveToNext()){
          Log.i("TAG", "student id ："+cursor.getInt(cursor.getColumnIndex("id")));
          Log.i("TAG", "student name ："+cursor.getString(cursor.getColumnIndex("name")));
          Log.i("TAG", "student major ："+cursor.getString(cursor.getColumnIndex("major")));
      }
        Toast.makeText(this,"查询成功！！！",Toast.LENGTH_SHORT).show();
    }
}
