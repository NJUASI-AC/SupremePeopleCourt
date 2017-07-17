package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.model.FullText;
import com.edu.nju.asi.model.Header;
import com.edu.nju.asi.model.LitigationParticipant;
import com.edu.nju.asi.model.LitigationParticipants;
import com.edu.nju.asi.service.XMLService;
import com.edu.nju.asi.utilities.enums.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
public class XMLServiceImpl implements XMLService {

    public static void main(String[] args) {
        new XMLServiceImpl().uploadOffline("D:\\byron\\SupremePeopleCourt\\src\\main\\resources\\document\\123.xml");
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
        List<Node> partiesType = document.selectNodes("//DSRLX");
        List<Node> genders = document.selectNodes("//XB");
        List<Node> nations = document.selectNodes("//MZ");
        List<Node> years = document.selectNodes("//CSRQ/Year");
        List<Node> months = document.selectNodes("//CSRQ/Month");
        List<Node> days = document.selectNodes("//CSRQ/Day");
//        List<Node> posts = document.selectNodes("//ZW");
        List<Node> nationalities = document.selectNodes("//GJ");
        List<Node> remarriage = document.selectNodes("//DSRSFZH");

        List<LitigationParticipant> litigants = new ArrayList<>();
        for (int i = 0; i < participantsName.size(); i++) {
            LitigationParticipant participant = new LitigationParticipant();
            participant.setName(participantsName.get(i).valueOf("@value"));
            participant.setLitigantType(LitigantType.getEnum(participantsType.get(i).valueOf("@value")));
            participant.setPartiesType(PartiesType.getEnum(partiesType.get(i).valueOf("@value")));
            participant.setGender(Gender.getEnum(genders.get(i).valueOf("@value")));
            participant.setNation(nations.get(i).valueOf("@value"));
            participant.setBirth(LocalDate.of(Integer.valueOf(years.get(i).valueOf("@value")), Integer.valueOf(months.get(i).valueOf("@value"))
                    , Integer.valueOf(days.get(i).valueOf("@value"))));
//            participant.setPost(posts.get(i).valueOf("@value"));
            participant.setNationality(nationalities.get(i).valueOf("@value"));
            if (remarriage.get(i).valueOf("@value").equals("是")) {
                participant.setRemarriage(true);
            } else {
                participant.setRemarriage(false);
            }

            litigants.add(participant);
        }

        LitigationParticipants litigationParticipants = new LitigationParticipants(caseNum, litigants);

        DaoManager.litigationParticipantsDao.insert(litigationParticipants);

        System.out.println(fullText.getText());
    }

    private String findSingleStrValue(String node) {
        return document.selectSingleNode("//" + node).valueOf("@value");
    }
}