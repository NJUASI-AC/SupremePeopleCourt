package com.edu.nju.asi.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;


/**
 * Created by Administrator on 2017/7/17 0017.
 */
public class XMLparser {

    public static void main(String[] args) {
        XMLparser.keyExtract("WS", "D:\\SummerCampus\\SupremePeopleCourt\\src\\main\\resources\\document\\123.xml");
    }

    public static void keyExtract(String key, String url){
        Document document = null;
        try {
            document = new SAXReader().read(url);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
//        System.out.println(document.asXML());

        Element root = document.getRootElement();

        // iterate through child elements of root
        for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
            Element element = it.next();
            System.out.println(element.getName());
            // do something
        }

        // iterate through child elements of root with element name "foo"
//        for (Iterator<Element> it = root.elementIterator("foo"); it.hasNext();) {
//            Element foo = it.next();
//            // do something
//        }
    }
}
