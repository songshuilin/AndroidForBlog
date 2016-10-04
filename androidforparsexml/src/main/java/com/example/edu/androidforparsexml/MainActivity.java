package com.example.edu.androidforparsexml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {
    private TextView mContent;
    private List<PersonBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();//初始化控件
    }

    /**
     * 为按钮绑定点击事件
     *
     * @param view
     */
    public void parseXML(View view) {
        // parseXMLForDom();//dom解析xml
       // parseForXMLForSax();//sax解析xml
        parseXMLForPull();//pull解析xml

    }

    /**
     * dom解析xml
     */
    private void parseXMLForDom() {
        try {
            list = ParseXMLForDom.parseXML(getResources().getAssets().open("person.xml"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).toString() + "\n");
            }
            mContent.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * sax解析xml
     */
    public void parseForXMLForSax() {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = null;
        try {
            sp = spf.newSAXParser();
            MyHandler handler = new MyHandler();
            sp.parse(getResources().getAssets().open("person.xml"), handler);
            list = handler.getList();//这是解析出来的内容放在list集合中
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).toString() + "\n");
            }
            mContent.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * pull解析xml
     */
    public void parseXMLForPull() {
        try {
          list=  ParseXMLForPull.parseXML(getResources().getAssets().open("person.xml"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).toString() + "\n");
            }
            mContent.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 初始化控件
     */
    private void initWidgets() {
        mContent = (TextView) findViewById(R.id.content);
    }
}
