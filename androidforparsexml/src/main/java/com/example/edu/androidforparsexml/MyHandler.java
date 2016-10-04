package com.example.edu.androidforparsexml;

import android.text.LoginFilter;
import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/4.
 */

public class MyHandler extends DefaultHandler {
    private PersonBean bean;
    private List<PersonBean> list;
    private String contentFlag;//只是一个标记，把值放到contentFlag中
    /**
     * 解析到文档开始调用，一般做初始化操作
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        list=new ArrayList<>();//初始化list
        super.startDocument();
    }

    /**
     * 解析到文档末尾调用，一般做回收操作
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    /**
     * 每读到一个元素就调用该方法
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      //当读到person节点时就创建一个personbean实例
       if ("person".equals(qName)){
           bean=new PersonBean();
           String id= attributes.getValue("id");
           bean.setId(Integer.valueOf(id));
       }
        super.startElement(uri, localName, qName, attributes);
    }

    /**
     * 读到元素的结尾调用
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("person".equals(qName)){
            list.add(bean);
            bean=null;//通知jvm回收
        }
        if ("name".equals(qName)){
            bean.setName(contentFlag);
        }else if ("age".equals(qName)){
            bean.setAge(Integer.valueOf(contentFlag));
        }else if ("major".equals(qName)){
            bean.setMajor(contentFlag);
        }
        contentFlag=null;//设为null
        super.endElement(uri, localName, qName);
    }

    /**
     * 读到属性内容调用
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        contentFlag=new String(ch,start,length).trim();
        super.characters(ch, start, length);
    }

    /**
     * 把list暴露出去，
     * @return
     */
    public List<PersonBean> getList() {
        return list;
    }
}
