package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.InfoCarrier.Case;
import com.edu.nju.asi.service.XMLService;
import com.edu.nju.asi.service.serviceImpl.XMLServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * XMLServiceImpl Tester.
 *
 * @author cuihua
 * @version 1.0
 * @since <pre>七月 17, 2017</pre>
 */
public class XMLServiceImplTest {

    XMLService xmlService;

    @Before
    public void before() throws Exception {
        xmlService = new XMLServiceImpl();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: uploadOffline(String url)
     */
    @Ignore
    @Test
    public void testUploadOffline() throws Exception {
//        String fileName = "赡养费纠纷/(2008)红民一初字第1608号民事判决书（一审民事案件简易程序用）.doc.xml";
//        Case result = xmlService.parseXML("/Users/cuihua/Documents/大学学习/大三/卓越工程师/裁判文书/天津文书婚姻纠纷(冯奕2017-4-1)/" + fileName);
        Case result = xmlService.parseXML("D:\\byron\\SupremePeopleCourt\\src\\main\\resources\\123.xml");
        assert result != null;

    }
} 
