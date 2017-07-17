package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.model.*;
import com.edu.nju.asi.InfoCarrier.Entry;
import com.edu.nju.asi.InfoCarrier.LegalArticle;
import com.edu.nju.asi.InfoCarrier.LitigationParticipant;
import com.edu.nju.asi.service.XMLService;
import com.edu.nju.asi.utilities.enums.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
@Service("XMLService")
public class XMLServiceImpl implements XMLService {

    public static void main(String[] args) {
        new XMLServiceImpl().uploadOffline("D:\\SummerCampus\\SupremePeopleCourt\\src\\main\\resources\\document\\234.xml");
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
        List<LitigationParticipant> litigants = new ArrayList<>();
        for (Iterator<Element> litigantElements = document.getRootElement().element("SSCYRQJ").elementIterator("SSCYR"); litigantElements.hasNext();){
            Element litigant = litigantElements.next();

            Element name = litigant.element("SSCYRMC");
            Element litigantType = litigant.element("SSSF");
            Element gender = litigant.element("XB");
            Element nation = litigant.element("MZ");
            Element degree = litigant.element("WHCD");
            Element post = litigant.element("DWZWFZ");
            Element remarriage = litigant.element("DSRSFZH");
            Element birth = litigant.element("CSRQ");

            LitigationParticipant participant = new LitigationParticipant();
            if (name != null) participant.setName(name.valueOf("@value"));
            if (litigantType != null) participant.setLitigantType(LitigantType.getEnum(litigantType.valueOf("@value")));
            if (gender != null) participant.setGender(Gender.getEnum(gender.valueOf("@value")));
            if (nation != null) participant.setNation(nation.valueOf("@value"));
            if (degree != null) participant.setDegree(degree.valueOf("@value"));
            if (post != null) participant.setPost(post.element("ZW").valueOf("@value"));
            if (remarriage != null){
                if(remarriage.equals("是"))
                    participant.setRemarriage(true);
            }
            if (birth != null){
                System.out.println(birth.getPath());

                String year = birth.element("Year").valueOf("@value");
                String month = birth.element("Month").valueOf("@value");
                String day = birth.element("Day").valueOf("@value");

                participant.setBirth(LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day)));
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
        for (Iterator<Element> laws = cpfxgc.elementIterator("FLFTMC"); laws.hasNext();){
            Element law = laws.next();
            String lawName = law.valueOf("@value");
            System.out.println(lawName);
            List<Entry> entries = new ArrayList<>();
            for (Iterator<Element> items = law.elementIterator("TM"); items.hasNext();){
                Element item = items.next();
                String entryName = item.valueOf("@value");
                List<String> k_entries = new ArrayList<>();
                for(Iterator<Element> k_items = item.elementIterator("KM"); k_items.hasNext();){
                    Element k_item = k_items.next();
                    String k_itemName = k_item.valueOf("@value");
                    k_entries.add(k_itemName);
                }
                Entry entry = new Entry(entryName, k_entries);
                entries.add(entry);
            }
            legalArticles.add(new LegalArticle(lawName, entries));
        }

        RefereeAnalysisProcess refereeAnalysisProcess = new RefereeAnalysisProcess(caseNum, closeCaseType, legalArticles);

        //裁判结果
        String result = findSingleStrValue("CPJG");
        JudgementResult judgementResult = new JudgementResult(caseNum, result);


        //插入数据库
        DaoManager.fullTextDao.insert(fullText);
        DaoManager.headerDao.insert(header);
        DaoManager.litigationParticipantsDao.insert(litigationParticipants);
        DaoManager.caseBasicDao.insert(caseBasic);
        DaoManager.refereeAnalysisProcessDao.insert(refereeAnalysisProcess);
        DaoManager.judgementResultDao.insert(judgementResult);
    }

    @Override
    public boolean uploadOnline(MultipartFile uploadedFile) throws IOException {
        if (uploadedFile.isEmpty()) {
            return false;
        }

        // 先转储文件再解析，最后删掉源文件
        String thisPath = uploadedFile.getName();
        File thisFile = new File(thisPath);

        uploadedFile.transferTo(thisFile);
        uploadOffline(thisPath);
        thisFile.delete();
        return true;
    }

    private String findSingleStrValue(String node) {
        return document.selectSingleNode("//" + node).valueOf("@value");
    }
}