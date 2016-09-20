package com.example.edu.expandablelistviewsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 private ExpandableListView  mElv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        MyAdapter adapter=new MyAdapter(MainActivity.this);
        mElv.setAdapter(adapter);
        
   mElv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
       @Override
       public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

           Toast.makeText(MainActivity.this,ContentUtil.child_names[groupPosition][childPosition],Toast.LENGTH_SHORT).show();
           return true;
       }
   });
    }

    private void initWidgets() {
        mElv= (ExpandableListView) findViewById(R.id.elv);
    }
}
