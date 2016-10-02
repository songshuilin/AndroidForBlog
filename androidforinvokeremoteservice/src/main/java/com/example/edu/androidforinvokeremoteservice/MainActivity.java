package com.example.edu.androidforinvokeremoteservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.edu.androidforremoteservice.Person;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent();
        intent.setAction("edu.jju.remote");//该动作是远程服务当中的
    }

    ServiceConnection myConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            person = Person.Stub.asInterface(service);//这个跟调用本地服务方法有些区别
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    /**
     * 绑定远程服务
     * @param view
     */
    public void bind(View view) {
        bindService(intent, myConn, BIND_AUTO_CREATE);
    }

    /**
     * 调用远程服务中的方法
     * @param view
     * @throws RemoteException
     */
    public void invoke(View view) throws RemoteException {
        person.getName();
    }
}
