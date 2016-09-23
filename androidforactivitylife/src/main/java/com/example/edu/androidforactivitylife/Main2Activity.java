package com.example.edu.androidforactivitylife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    private static  final  String TAG="TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Log.i(TAG, "Main2Activity ===onCreate: .........");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Main2Activity ===onStart: .............");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Main2Activity ===onResume: ...........");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Main2Activity ===onPause: ..............");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Main2Activity ===onStop: ...............");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Main2Activity ===onDestroy: .................");
    }

    public void onclick(View view){

        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
    }
}
