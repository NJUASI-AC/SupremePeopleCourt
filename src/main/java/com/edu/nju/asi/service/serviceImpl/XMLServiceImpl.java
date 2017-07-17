package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.model.*;
import com.edu.nju.asi.model.InfoCarrier.LegalArticle;
import com.edu.nju.asi.model.InfoCarrier.LitigationParticipant;
import com.edu.nju.asi.service.XMLService;
import com.edu.nju.asi.utilities.enums.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
public class XMLServiceImpl implements XMLService {

    public static void main(String[] args) {
        new XMLServiceImpl().uploadOffline("D:\\SummerCampus\\SupremePeopleCourt\\src\\main\\resources\\document\\123.xml");
    }

    Document document;

    public XMLServiceImpl() {
//        this.document = document;
    }

    @Override
    public void uploadOffline(String url) {
        SAXReader reader = new SAXReader();
        try {
            document = reader.read(url);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        String caseNum = findSingleStrValue("AH");

        //全文
        String text = findSingleStrValue("QW");
        FullText fullText = new FullText(caseNum, text);
//        DaoManager.baseDao.insert(fullText, "fullText");

        //文首
        String handlingCourt = findSingleStrValue("JBFY");
        String courtLevel = findSingleStrValue("FYJB");
        String administrativeDivision = findSingleStrValue("XZQH_P");
        DocumentName nameOfDocument = DocumentName.getEnum(findSingleStrValue("WSMC"));
        int filingYear = Integer.valueOf(findSingleStrValue("LAND"));
        CaseType natureOfCase = CaseType.getEnum(findSingleStrValue("AJXZ"));
        DocumentType documentType = DocumentType.getEnum(findSingleStrValue("WSZL"));
        TrialProcedure trialProcedure = TrialProcedure.getEnum(findSingleStrValue("SPCX"));
        Header header = new Header(caseNum, handlingCourt, courtLevel, administrativeDivision, nameOfDocument
                , filingYear, natureOfCase, documentType, trialProcedure);


        //诉讼参与人全集
        List<Node> participantsName = document.selectNodes("//SSCYRMC");
        List<Node> participantsType = document.selectNodes("//DSRLB");
        List<Node> genders = document.selectNodes("//XB");
        List<Node> nations = document.selectNodes("//MZ");
        List<Node> years = document.selectNodes("//CSRQ/Year");
        List<Node> months = document.selectNodes("//CSRQ/Month");
        List<Node> days = document.selectNodes("//CSRQ/Day");
        List<Node> degrees = document.selectNodes("//WHCD");
//        List<Node> posts = document.selectNodes("//ZW");
        List<Node> remarriage = document.selectNodes("//DSRSFZH");

        List<LitigationParticipant> litigants = new ArrayList<>();
        for (int i = 0; i < participantsName.size(); i++) {
            LitigationParticipant participant = new LitigationParticipant();
            participant.setName(participantsName.get(i).valueOf("@value"));
            participant.setLitigantType(LitigantType.getEnum(participantsType.get(i).valueOf("@value")));
            participant.setGender(Gender.getEnum(genders.get(i).valueOf("@value")));
            participant.setNation(nations.get(i).valueOf("@value"));
            participant.setBirth(LocalDate.of(Integer.valueOf(years.get(i).valueOf("@value"))
                    , Integer.valueOf(months.get(i).valueOf("@value")), Integer.valueOf(days.get(i).valueOf("@value"))));
            participant.setDegree(degrees.size() == 0 ? "未提及": degrees.get(i).valueOf("@value"));
//            participant.setPost(posts.size() == 0 ? "未提及": posts.get(i).valueOf("@value"));
            //TODO post应该从element去找
            if (remarriage.get(i).valueOf("@value").equals("是")) {
                participant.setRemarriage(true);
            } else {
                participant.setRemarriage(false);
            }

            litigants.add(participant);
        }

        LitigationParticipants litigationParticipants = new LitigationParticipants(caseNum, litigants);

//        DaoManager.litigationParticipantsDao.insert(litigationParticipants);


        //案件基本情况
        String plaintiffClaim = findSingleStrValue("YGSCD");
        String defendantArgue = findSingleStrValue("BGBCD");
        String fact = findSingleStrValue("CMSSD");
        List<Node> evidenceNodes = document.selectNodes("//ZJD");
        List<String> evidence = new ArrayList<>();
        for (Node node : evidenceNodes){
            evidence.add(node.valueOf("@value"));
        }

        CaseBasic caseBasic = new CaseBasic(caseNum, plaintiffClaim, defendantArgue, evidence, fact);

        //裁判分析过程
        String closeCaseType = findSingleStrValue("JAFSLX");
        List<LegalArticle> legalArticles = new ArrayList<>();

        Element cpfxgc = document.getRootElement().element("CPFXGC");
        for (Iterator<Element> it = cpfxgc.elementIterator("FLFTMC"); it.hasNext();){
            Element element = it.next();
            LegalArticle legalArticle = new LegalArticle();
            String lawName = element.attributeValue("value");
            System.out.println(lawName);


            legalArticles.add(legalArticle);
        }


        RefereeAnalysisProcess refereeAnalysisProcess = new RefereeAnalysisProcess(caseNum, closeCaseType, legalArticles);

        //裁判结果
        String result = findSingleStrValue("CPJG");

        JudgementResult judgementResult = new JudgementResult(caseNum, result);

    }

    private String findSingleStrValue(String node) {
        return document.selectSingleNode("//" + node).valueOf("@value");
    }
}