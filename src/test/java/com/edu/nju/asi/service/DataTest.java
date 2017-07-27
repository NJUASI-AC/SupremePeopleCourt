package com.edu.nju.asi.service;

import com.edu.nju.asi.dao.CaseDao;
import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.model.Case;
import com.edu.nju.asi.service.serviceImpl.XMLServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Byron Dong on 2017/7/18.
 */
public class DataTest {

    XMLService xmlService;
    CaseDao caseDao;

    @Before
    public void before() throws Exception {
        xmlService = new XMLServiceImpl();
        caseDao = DaoManager.caseDao;
    }

    @Ignore
    @Test
    public void saveData() throws Exception {
        List<String> urls = getUrl("C:\\Users\\61990\\Desktop\\测试集\\测试集\\");
        List<Case> cases = new ArrayList<>();
        int count = 1;
        for (String url : urls) {
            Logger.getLogger("url").fine("---------------start " + url + "---------------");
            Case case_temp = null;
            try {
                case_temp = xmlService.parseXML(url);
            } catch (DateTimeException e) {
                continue;
            } catch (NumberFormatException e) {
                continue;
            }

            Logger.getLogger("url").fine("---------------start " + url + "---------------");
            if(case_temp!=null){
                cases.add(case_temp);
            }
            System.out.println(url);
            System.out.println("----------------------------------");

            if (count % 30 == 0) {
                caseDao.insertAll(cases);
                Logger.getLogger("insert").fine("---------------RefereeAnalysisProcess insert---------------");
                cases.clear();
            }
            System.out.println(count);
            count++;
        }
        caseDao.insertAll(cases);
    }

    @Ignore
    @Test
    public void print() {
        File file = new File("F:\\log.txt");
        List<String> urls = getUrl("C:\\Users\\Byron Dong\\Desktop\\暑期实践\\裁判文书\\天津文书婚姻纠纷\\");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for (String log : urls) {
                bufferedWriter.write(log);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void renameTest() throws Exception {
        rename("C:\\Users\\Byron Dong\\Desktop\\暑期实践\\裁判文书\\天津文书婚姻纠纷\\");
    }

    private void rename(String root) {

        File files = new File(root);
        File[] dir = files.listFiles();
        for (File file : dir) {
            if (!file.isFile()) {

                String url = root + file.getName();
                rename(url);
            } else {

                String url = root + "\\" + file.getName();
                File oldFile = new File(url);
                String temp = file.getName();

                if (temp.contains("(")) {
                    temp = temp.replaceAll("\\(", "");
                }

                if (temp.contains(")")) {
                    temp = temp.replaceAll("\\)", "");
                }

                if (temp.contains("（")) {
                    temp = temp.replaceAll("（", "");
                }

                if (temp.contains("）")) {
                    temp = temp.replaceAll("）", "");
                }

                String[] splitStr = temp.split("\\.");
                if (splitStr.length == 3) {
                    temp = splitStr[0] + "." + splitStr[2];
                }

                File newFile = new File(root + "\\" + temp);
                oldFile.renameTo(newFile);
            }
        }

    }

    private List<String> getUrl(String root) {

        List<String> urls = new ArrayList<>();
        File files = new File(root);
        File[] dir = files.listFiles();
        for (File file : dir) {
            if (!file.isFile()) {

                String url = root + file.getName();

                urls.addAll(getUrl(url));
            } else {

                urls.add(root + "\\" + file.getName());

            }
        }

        return urls;
    }
}