package com.example.edu.androidforcontentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 这是数据库帮助类
 * Created by Administrator on 2016/10/6.
 */

public class MyHelper extends SQLiteOpenHelper {

    /**
     * 这是建student表语句
     */
    private String sql="create table student (" +
            "id integer primary key autoincrement " +
            ", name" +
            ", major" +
            ")";

    public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 数据库创建时调用
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    /**
     *数据库版本更新时调用
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
