package com.edu.nju.asi.service;

import com.edu.nju.asi.InfoCarrier.Case;
import com.edu.nju.asi.dao.*;
import com.edu.nju.asi.model.*;
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
    CaseBasicDao caseBasicDao;
    FullTextDao fullTextDao;
    HeaderDao headerDao;
    JudgementResultDao judgementResultDao;
    LitigationParticipantsDao litigationParticipantsDao;
    ProceedingsDao proceedingsDao;
    RefereeAnalysisProcessDao refereeAnalysisProcessDao;

    @Before
    public void before() throws Exception {
        xmlService = new XMLServiceImpl();
        caseBasicDao = DaoManager.caseBasicDao;
        fullTextDao = DaoManager.fullTextDao;
        headerDao = DaoManager.headerDao;
        judgementResultDao = DaoManager.judgementResultDao;
        litigationParticipantsDao = DaoManager.litigationParticipantsDao;
        proceedingsDao = DaoManager.proceedingsDao;
        refereeAnalysisProcessDao = DaoManager.refereeAnalysisProcessDao;
    }

    @Ignore
    @Test
    public void saveData() throws Exception {
        List<String> urls = getUrl("C:\\Users\\Byron Dong\\Desktop\\暑期实践\\1组\\测试集\\");
        List<CaseBasic> caseBasics = new ArrayList<>();
        List<FullText> fullTexts = new ArrayList<>();
        List<Header> headers = new ArrayList<>();
        List<JudgementResult> judgementResults = new ArrayList<>();
        List<LitigationParticipants> litigationParticipants = new ArrayList<>();
        List<Proceedings> proceedings = new ArrayList<>();
        List<RefereeAnalysisProcess> refereeAnalysisProcesses = new ArrayList<>();
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
            if (case_temp.getFullText() != null) {
                fullTexts.add(case_temp.getFullText());
            }
            if (case_temp.getHeader() != null) {
                headers.add(case_temp.getHeader());
            }
            if (case_temp.getLitigationParticipants() != null) {
                litigationParticipants.add(case_temp.getLitigationParticipants());
            }
            if (case_temp.getCaseBasic() != null) {
                caseBasics.add(case_temp.getCaseBasic());
            }
            if (case_temp.getRefereeAnalysisProcess() != null) {
                refereeAnalysisProcesses.add(case_temp.getRefereeAnalysisProcess());
            }
            if (case_temp.getJudgementResult() != null) {
                judgementResults.add(case_temp.getJudgementResult());
            }
            if (case_temp.getProceedings() != null) {
                proceedings.add(case_temp.getProceedings());
            }
            Logger.getLogger("url").fine("---------------start " + url + "---------------");

            System.out.println(url);
            System.out.println("----------------------------------");

            if (count % 30 == 0) {
                fullTextDao.insertAll(fullTexts);
                Logger.getLogger("insert").fine("---------------FullText insert---------------");
                headerDao.insertAll(headers);
                Logger.getLogger("insert").fine("---------------Header insert---------------");
                caseBasicDao.insertAll(caseBasics);
                Logger.getLogger("insert").fine("---------------CaseBisic insert---------------");
                litigationParticipantsDao.insertAll(litigationParticipants);
                Logger.getLogger("insert").fine("---------------Participants insert---------------");
                proceedingsDao.insertAll(proceedings);
                Logger.getLogger("insert").fine("---------------Proceeding insert---------------");
                judgementResultDao.insertAll(judgementResults);
                Logger.getLogger("insert").fine("---------------JudgementResult insert---------------");
                refereeAnalysisProcessDao.insertAll(refereeAnalysisProcesses);
                Logger.getLogger("insert").fine("---------------RefereeAnalysisProcess insert---------------");
                caseBasics.clear();
                fullTexts.clear();
                headers.clear();
                judgementResults.clear();
                litigationParticipants.clear();
                proceedings.clear();
                refereeAnalysisProcesses.clear();
            }
            System.out.println(count);
            count++;
        }

        caseBasicDao.insertAll(caseBasics);
        fullTextDao.insertAll(fullTexts);
        headerDao.insertAll(headers);
        judgementResultDao.insertAll(judgementResults);
        litigationParticipantsDao.insertAll(litigationParticipants);
        proceedingsDao.insertAll(proceedings);
        refereeAnalysisProcessDao.insertAll(refereeAnalysisProcesses);
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