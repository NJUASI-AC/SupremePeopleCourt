package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.InfoCarrier.Case;
import com.edu.nju.asi.InfoCarrier.Entry;
import com.edu.nju.asi.InfoCarrier.LegalArticle;
import com.edu.nju.asi.InfoCarrier.LitigationParticipant;
import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.model.*;
import com.edu.nju.asi.service.XMLService;
import com.edu.nju.asi.utilities.enums.DocumentName;
import com.edu.nju.asi.utilities.enums.Gender;
import com.edu.nju.asi.utilities.enums.LitigantType;
import com.edu.nju.asi.utilities.enums.TrialProcedure;
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

    Document document;

    public XMLServiceImpl() {
//        this.document = document;
    }

    @Override
    public Case uploadOffline(String url) {
        SAXReader reader = new SAXReader();
        try {
            document = reader.read(url);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        String caseID = findSingleNode("AH").valueOf("@value");

        //全文
        FullText fullText = null;
        Node text = findSingleNode("QW");
        if (text != null){fullText = new FullText(caseID, text.valueOf("@value"));}


        //文首
        Header header = null;

        Node handlingCourt = findSingleNode("JBFY");
        Node nameOfDocument = findSingleNode("WSMC");
        Node trialProcedure = findSingleNode("SPCX");

        if(handlingCourt!=null || nameOfDocument!=null || trialProcedure!=null){
            header = new Header();
            header.setCaseID(caseID);
            if(handlingCourt != null) {header.setHandlingCourt(handlingCourt.valueOf("@value"));}
            if(nameOfDocument != null) {header.setNameOfDocument(DocumentName.getEnum(nameOfDocument.valueOf("@value")));}
            if(trialProcedure != null) {header.setTrialProcedure(TrialProcedure.getEnum(trialProcedure.valueOf("@value")));}
        }


        //诉讼参与人全集
        List<LitigationParticipant> litigants = new ArrayList<>();
        Element litigantsElement = document.getRootElement().element("SSCYRQJ");
        if (litigantsElement != null) {
            Iterator<Element> litigantElementsIterator = document.getRootElement().element("SSCYRQJ").elementIterator("SSCYR");
            while (litigantElementsIterator.hasNext()) {
                Element litigant = litigantElementsIterator.next();

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
        }

        LitigationParticipants litigationParticipants = null;
        if(litigants.size() > 0){
            litigationParticipants = new LitigationParticipants(caseID, litigants);
        }

        //诉讼记录
        Proceedings proceedings = null;
        if (document.getRootElement().element("SSJL") != null) {
            proceedings = new Proceedings();

            Node actionCause = findSingleNode("AY");
            Node actionCode = findSingleNode("AYDM");

            proceedings.setCaseID(caseID);
            if(actionCause != null) {proceedings.setActionCause(actionCause.valueOf("@value"));}
            if(actionCode != null) {proceedings.setActionCode(actionCode.valueOf("@value"));}
        }


        //案件基本情况
        CaseBasic caseBasic = null;
        Element basicElement = document.getRootElement().element("AJJBQK");
        if (basicElement != null) {
            // TODO 被告称诉段不是都有，比如 婚姻无效纠纷/(2016)津0115民初3692号民事判决书（一审民事案件用）.doc.xml
            caseBasic = new CaseBasic();

            Node plaintiffClaim = findSingleNode("YGSCD");
            Node defendantArgue = findSingleNode("BGBCD");
            Node fact = findSingleNode("CMSSD");
            List<Node> evidenceNodes = document.selectNodes("//ZJD");
            List<String> evidence = new ArrayList<>();
            for (Node node : evidenceNodes){
                evidence.add(node.valueOf("@value"));
            }

            caseBasic.setCaseID(caseID);
            if(plaintiffClaim != null) {caseBasic.setPlaintiffClaim(plaintiffClaim.valueOf("@value"));}
            if(defendantArgue != null) {caseBasic.setDefendantArgue(defendantArgue.valueOf("@value"));}
            if(fact != null) {caseBasic.setFact(fact.valueOf("@value"));}
            if(evidence.size() != 0) {caseBasic.setEvidence(evidence);}
        }

        //裁判分析过程
        RefereeAnalysisProcess refereeAnalysisProcess = null;
        Element analysisElement = document.getRootElement().element("CPFXGC");
        if (analysisElement != null) {
            Node closeCaseType = findSingleNode("JAFSLX");
            List<LegalArticle> legalArticles = new ArrayList<>();
            Element cpfxgc = document.getRootElement().element("CPFXGC");
            for (Iterator<Element> laws = cpfxgc.elementIterator("FLFTMC"); laws.hasNext();){
                Element law = laws.next();
                String lawName = law.valueOf("@value");
                System.out.println(lawName);
                List<Entry> entries = new ArrayList<>();
                for (Iterator<Element> items = law.elementIterator("TM"); items.hasNext();){
                    Element item = items.next();
                    List<String> k_entries = new ArrayList<>();
                    for(Iterator<Element> k_items = item.elementIterator("KM"); k_items.hasNext();){
                        Element k_item = k_items.next();
                        String k_itemName = k_item.valueOf("@value");
                        k_entries.add(k_itemName);
                    }

                    Entry entry = new Entry();
                    entry.setName(item.valueOf("@value"));
                    if(k_entries.size() != 0) {entry.setEntries(k_entries);}

                    entries.add(entry);
                }
                legalArticles.add(new LegalArticle(lawName, entries));
            }

            refereeAnalysisProcess = new RefereeAnalysisProcess();
            refereeAnalysisProcess.setCaseID(caseID);
            if(closeCaseType != null) {refereeAnalysisProcess.setCloseCaseType(closeCaseType.valueOf("@value"));}
            if(legalArticles.size() != 0) {refereeAnalysisProcess.setLegalArticles(legalArticles);}

        }

        //裁判结果
        Node result = findSingleNode("CPJG");
        JudgementResult judgementResult = null;
        if(result != null){judgementResult = new JudgementResult(caseID, result.valueOf("@value"));}

        //插入数据库
        if (fullText != null) {DaoManager.fullTextDao.insert(fullText);}
        if (header != null) {DaoManager.headerDao.insert(header);}
        if (litigationParticipants != null) {DaoManager.litigationParticipantsDao.insert(litigationParticipants);}
        if (caseBasic != null) {DaoManager.caseBasicDao.insert(caseBasic);}
        if (refereeAnalysisProcess != null) {DaoManager.refereeAnalysisProcessDao.insert(refereeAnalysisProcess);}
        if (judgementResult != null) {DaoManager.judgementResultDao.insert(judgementResult);}

        return new Case(fullText, header, litigationParticipants, proceedings, caseBasic, refereeAnalysisProcess, judgementResult, new Tailor());
    }

    @Override
    public Case uploadOnline(MultipartFile uploadedFile) throws IOException {
        if (uploadedFile.isEmpty()) {
            return null;
        }

        // 先转储文件再解析，最后删掉源文件
        String thisPath = uploadedFile.getName();
        File thisFile = new File(thisPath);

        uploadedFile.transferTo(thisFile);
        Case wanted = uploadOffline(thisPath);

        boolean deleteResult = thisFile.delete();
        System.out.println(deleteResult);
        return wanted;
    }

    private Node findSingleNode(String node) {
        return document.selectSingleNode("//" + node);
    }
}