package com.example.edu.androidforparsexml;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/4.
 */

public class ParseXMLForPull {


    public  static List<PersonBean>  parseXML(InputStream is) {
        List<PersonBean> list=null;
        PersonBean bean=null;
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setInput(is, "utf-8");
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        list = new ArrayList<>();
                        break;
                    case XmlPullParser.START_TAG:
                        if ("person".equals(parser.getName())) {
                            bean = new PersonBean();
                            String id=  parser.getAttributeValue(null,"id");
                            bean.setId(Integer.valueOf(id));
                        }
                        if (bean != null) {
                            if ("name".equals(parser.getName())) {
                                bean.setName(parser.nextText().trim());
                            } else if ("age".equals(parser.getName())) {
                                bean.setAge(Integer.valueOf(parser.nextText().trim()));
                            } else if ("major".equals(parser.getName())) {
                                bean.setMajor(parser.nextText().trim());
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("person".equals(parser.getName())){
                            list.add(bean);
                            bean=null;
                        }
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
