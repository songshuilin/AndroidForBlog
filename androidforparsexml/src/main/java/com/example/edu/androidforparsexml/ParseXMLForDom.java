package com.example.edu.androidforparsexml;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Administrator on 2016/10/4.
 */

public class ParseXMLForDom {
    /**
     * dom方式解析xml
     */
    public static List<PersonBean> parseXML(InputStream is) throws Exception {
        //获取集合实例
        List<PersonBean> list = new ArrayList<>();
        //获取DocumentBuilderFactory实例
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //获取documentBuilder实例
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //获取document实例
        Document document = documentBuilder.parse(is);
        //获取person节点集合
        NodeList personNodeList = document.getElementsByTagName("person");

        for (int i = 0; i < personNodeList.getLength(); i++) {
            PersonBean bean = new PersonBean();//获取personbean实例
            Node person = personNodeList.item(i);//获取person节点
            NamedNodeMap nnm = person.getAttributes();
            /*
             * 获取person节点的属性值
             */
            for (int j = 0; j < nnm.getLength(); j++) {
                Node n = nnm.item(j);
                bean.setId(Integer.valueOf(n.getNodeValue()));
            }
            /*
            获取person里的子节点,并赋值给bean
             */
            NodeList personChildNodeList = person.getChildNodes();
            for (int j = 0; j < personChildNodeList.getLength(); j++) {
                //获取person节点的子节点
                Node personChileNode = personChildNodeList.item(j);
                if (Node.ELEMENT_NODE == personChileNode.getNodeType()) {
                    if ("name".equals(personChileNode.getNodeName())) {
                        bean.setName(personChileNode.getTextContent().trim());
                    } else if ("age".equals(personChileNode.getNodeName())) {
                        bean.setAge(Integer.valueOf(personChileNode.getTextContent().trim()));
                    } else if ("major".equals(personChileNode.getNodeName())) {
                        bean.setMajor(personChileNode.getTextContent().trim());
                    }
                }

            }
            list.add(bean);
        }
        return list;
    }

}
