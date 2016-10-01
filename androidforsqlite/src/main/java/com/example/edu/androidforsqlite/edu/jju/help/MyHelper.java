package com.example.edu.androidforsqlite.edu.jju.help;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**这是数据库帮助类
 * Created by Administrator on 2016/9/30.
 */

public class MyHelper extends SQLiteOpenHelper {
    /**
     * 这是建person表语句
     */
    private String sql = "create table person (" +
            " id integer primary key autoincrement " +
            ", name " +
            ", age )" ;


    public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

       super(context, name, factory, version);
    }

    /**
     * 数据库只有第一次创建时调用
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

       db.execSQL(sql);
    }

    /**
     * 只有数据库版本更新时调用
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
