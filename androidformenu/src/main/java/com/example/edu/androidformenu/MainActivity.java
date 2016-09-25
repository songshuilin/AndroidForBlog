package com.example.edu.androidformenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.tv);
        registerForContextMenu(mTv);//为mTv注册事件
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //四个参数的含义。1，group的id,2,item的id,3,是否排序，4，将要显示的内容
//        menu.add(0, 1, 0, "菜单一");
//        menu.add(0, 2, 0, "菜单二");
//        menu.add(0, 3, 0, "菜单三");
//        menu.add(0, 4, 0, "菜单四");
//        SubMenu sub = menu.addSubMenu("子菜单");
//        sub.add(0, 5, 0, "子菜单一");
//        sub.add(0, 6, 0, "子菜单二");
//        sub.add(0, 7, 0, "子菜单三");

        getMenuInflater().inflate(R.menu.item_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.group_one:
                Toast.makeText(MainActivity.this, "菜单一", Toast.LENGTH_SHORT).show();
                break;
            case R.id.group_two:
                Toast.makeText(MainActivity.this, "菜单二", Toast.LENGTH_SHORT).show();
                break;
            case R.id.group_three:
                Toast.makeText(MainActivity.this, "菜单三", Toast.LENGTH_SHORT).show();
                break;
            case R.id.group_four:
                Toast.makeText(MainActivity.this, "菜单四", Toast.LENGTH_SHORT).show();
                break;
            case R.id.child_one:
                Toast.makeText(MainActivity.this, "子菜单一", Toast.LENGTH_SHORT).show();
                break;
            case R.id.child_two:
                Toast.makeText(MainActivity.this, "子菜单二", Toast.LENGTH_SHORT).show();
                break;
            case R.id.child_three:
                Toast.makeText(MainActivity.this, "子菜单三", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v == mTv) {
            menu.add(0, 1, 0, "上下文菜单一");
            menu.add(0, 2, 0, "上下文菜单二");
            menu.add(0, 3, 0, "上下文菜单三");

        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(MainActivity.this, "上下文菜单一", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this, "上下文菜单二", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this, "上下文菜单三", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
}
