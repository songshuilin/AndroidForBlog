package com.example.edu.androidforcontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    private static UriMatcher matcher;

    public MyContentProvider() {
    }

    /**
     * 这是个静态代码块实现类一加载时，就把这些uri加进去
     */
    static {
        matcher = new UriMatcher(-1);//-1表示的是如果没有匹配的就返回-1
        //三个参数的意思是 1，你的主机名，可以在清单文件查看， 2，路径 3，匹配成功时返回的状态码
        matcher.addURI("edu.jju.song", "insert", 1);
        matcher.addURI("edu.jju.song", "delete", 2);
        matcher.addURI("edu.jju.song", "update", 3);
        matcher.addURI("edu.jju.song", "select", 4);

    }

    /**
     * 删除数据
     *
     * @param uri
     * @param selection
     * @param selectionArgs
     * @return
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int result = matcher.match(uri);
        if (result == 2) {
            //数据库帮助类
           MyHelper helper = new MyHelper(getContext(), "song.db", null, 1);
            SQLiteDatabase db = helper.getReadableDatabase();//返回数据库
            //三个参数的含义 1， 表名 2，删除条件 3， 条件的值
            return db.delete("student", selection, selectionArgs);
        } else {
            throw new RuntimeException("你不能删除数据！！！！");
        }
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int result = matcher.match(uri);
        if (result == 1) {
            //数据库帮助类
            MyHelper helper = new MyHelper(getContext(), "song.db", null, 1);
            SQLiteDatabase db = helper.getReadableDatabase();//返回数据库
        db.insert("student", null, values);//插入数据
        } else {
            throw new RuntimeException("你不能插入数据！！！！");
        }
        return null;
    }

    /**
     * 内容提供者创建时调用
     *
     * @return
     */
    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    /**
     * 查询数据
     *
     * @param uri
     * @param projection
     * @param selection
     * @param selectionArgs
     * @param sortOrder
     * @return
     */
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        int result = matcher.match(uri);
        if (result == 4) {
            //数据库帮助类
            MyHelper helper = new MyHelper(getContext(), "song.db", null, 1);
            SQLiteDatabase db = helper.getReadableDatabase();//返回数据库
            return db.query("student", projection, selection, selectionArgs, null, null, null);//查询数据
        } else {
            throw new RuntimeException("你不能查询数据！！！！");
        }
    }

    /**
     * 修改数据
     *
     * @param uri
     * @param values
     * @param selection
     * @param selectionArgs
     * @return
     */
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int result = matcher.match(uri);
        if (result == 3) {
            //数据库帮助类
            MyHelper helper = new MyHelper(getContext(), "song.db", null, 1);
            SQLiteDatabase db = helper.getReadableDatabase();//返回数据库
            return db.update("student", values, selection, selectionArgs);//修改数据
        } else {
            throw new RuntimeException("你不能更新数据！！！！");
        }
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
