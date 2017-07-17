package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.model.FullText;
import com.edu.nju.asi.model.Header;
import com.edu.nju.asi.service.XMLService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
public class XMLServiceImpl implements XMLService {

    public static void main(String[] args) {
        new XMLServiceImpl().uploadOffline("D:\\SummerCampus\\SupremePeopleCourt\\src\\main\\resources\\document\\123.xml");
    }

    @Override
    public void uploadOffline(String url) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(url);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        System.out.println(document.getPath());
//        System.out.println(document.selectSingleNode("//QW").valueOf("@value"));

        Element root = document.getRootElement();

        String caseNum = root.selectSingleNode("//AH").valueOf("@value");
        String fullText = root.selectSingleNode("//QW").valueOf("@value");


        System.out.println(caseNum);
//        for(Iterator<Element> it = root.elementIterator(); it.hasNext();){
//            Element element = it.next();
//            System.out.println(element.getName());
//        }
    }

    private Header headerParse(){
        return null;
    }
}
