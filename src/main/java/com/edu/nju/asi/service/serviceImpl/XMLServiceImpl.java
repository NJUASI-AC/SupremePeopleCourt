package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.InfoCarrier.*;
import com.edu.nju.asi.model.*;
import com.edu.nju.asi.service.XMLService;
import com.edu.nju.asi.utilities.enums.*;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    }

    @Override
    public Case uploadOnline(MultipartFile uploadedFile) throws IOException {
        if (uploadedFile.isEmpty()) {
            return null;
        }

        // 先转储文件再解析，推荐完了之后再删除
        String thisPath = uploadedFile.getOriginalFilename();
        File thisFile = new File(thisPath);

        uploadedFile.transferTo(thisFile);
        return parseXML(thisPath);
    }

    private Node findSingleNode(String node) {
        return document.selectSingleNode("//" + node);
    }

    public Case parseXML(String url) {
        System.out.println(url+"--------"+"parse");
        SAXReader reader = new SAXReader();
        try {
            document = reader.read(new File(url));
        } catch (DocumentException e) {
            Logger.getLogger(XMLServiceImpl.class).error(e.getMessage() + "--指定url的文件不存在");
        }

        File file = new File(url);
        System.out.println(url);

        Element root = document.getRootElement().element("QW");

        //先从文首中拿到CaseID
        String caseID = file.getName().split("\\.")[0];


        //全文
        FullText fullText = null;
        Node text = findSingleNode("QW");
        if (text != null) {
            fullText = new FullText(caseID, text.valueOf("@value"));
        }


        //文首
        Header header = new Header();

        Node handlingCourt = findSingleNode("JBFY");
        Node trialProcedure = findSingleNode("SPCX");
        Node caseNum = findSingleNode("AH");
        Node nameOfDocument = findSingleNode("WSMC");


        header.setCaseID(caseID);
        header.setCaseNum(caseNum.valueOf("@value"));

        if (handlingCourt != null) {
            header.setHandlingCourt(handlingCourt.valueOf("@value"));
        }
        header.setNameOfDocument(DocumentName.getEnum(nameOfDocument.valueOf("@value")));
        if (trialProcedure != null) {
            header.setTrialProcedure(TrialProcedure.getEnum(trialProcedure.valueOf("@value")));
        }
        if (caseNum != null) header.setCaseNum(caseNum.valueOf("@value"));
        if (nameOfDocument != null) header.setNameOfDocument(nameOfDocument.valueOf("@value"));


        //当事人
        Element participants = root.element("DSR");
        List<LitigationParticipant> litigants = new ArrayList<>();
        if(participants != null){
            //起诉方
            litigants.addAll(findLitigantsOneSide(participants, "QSF"));
            //应诉方
            litigants.addAll(findLitigantsOneSide(participants, "YSF"));
        }

        LitigationParticipants litigationParticipants = null;
        if (litigants.size() > 0) {
            litigationParticipants = new LitigationParticipants(caseID, litigants);
        }

        //诉讼记录
        Proceedings proceedings = null;

        Element records = root.element("SSJL");
        if (records != null) {
            proceedings = new Proceedings();
            proceedings.setCaseID(caseID);
            //起诉主案由
            Element mainActionCause = records.element("QSZAY");
            if(mainActionCause != null){
                ActionCause actionCause = new ActionCause();
                actionCause.setActionCause(mainActionCause.valueOf("@value"));

                Element zmdm = mainActionCause.element("ZMDM");
                Element wzzm = mainActionCause.element("WZZM");

                if (zmdm != null)actionCause.setActionName(zmdm.valueOf("@value"));
                if (wzzm != null) actionCause.setActionCode(wzzm.valueOf("@value"));
                proceedings.setMainActionCause(actionCause);
            }

            //其它起诉案由
            Element extra = records.element("QTQSAY");
            if(extra != null){
                Iterator<Element> extraActionCauses = extra.elementIterator("QSAY");
                if(extraActionCauses != null){
                    List<ActionCause> extraCauses = new ArrayList<>();
                    while(extraActionCauses.hasNext()){
                        Element extraActionCause = extraActionCauses.next();
                        ActionCause actionCause = new ActionCause();
                        actionCause.setActionCause(extraActionCause.valueOf("@value"));

                        Element zmdm = extraActionCause.element("ZMDM");
                        Element wzzm = extraActionCause.element("WZZM");
                        if (zmdm != null)actionCause.setActionName(zmdm.valueOf("@value"));
                        if (wzzm != null) actionCause.setActionCode(wzzm.valueOf("@value"));
                        extraCauses.add(actionCause);
                    }
                    proceedings.setExtraActionCause(extraCauses);
                }
            }
        }


        //案件基本情况
        CaseBasic caseBasic = new CaseBasic();
        caseBasic.setCaseID(caseID);

        Element basicElement = root.element("AJJBQK");
        if (basicElement != null) {

            Node paragraphThisTrial = findSingleNode("BSSLD");
            Node inspectionOpinion = findSingleNode("JCJGYJ");
            Node defenceOpinion = findSingleNode("SSSSBHYJ");

            if(paragraphThisTrial != null) caseBasic.setParagraphThisTrial(paragraphThisTrial.valueOf("@value"));
            if(inspectionOpinion != null) caseBasic.setInspectionOpinion(inspectionOpinion.valueOf("@value"));
            if(defenceOpinion != null) caseBasic.setDefenceOpinion(defenceOpinion.valueOf("@value"));
        }

        //裁判分析过程
        RefereeAnalysisProcess refereeAnalysisProcess = null;
        Element cpfxgc = root.element("CPFXGC");
        if (cpfxgc != null){
            Element analysisElement = cpfxgc.element("FLFTYY");
            if (analysisElement != null) {

                List<LegalArticle> legalArticles = new ArrayList<>();
                for (Iterator<Element> laws = analysisElement.elementIterator("FLFTFZ"); laws.hasNext(); ) {
                    Element law = laws.next();
                    Element lawNameElement = law.element("MC");
                    if(lawNameElement == null) continue;
                    String lawName = lawNameElement.valueOf("@value");
                    List<T_Entry> t_entries = new ArrayList<>();
                    for (Iterator<Element> t_items = law.elementIterator("T"); t_items.hasNext(); ) {
                        Element t_item = t_items.next();
                        List<K_Entry> k_entries = new ArrayList<>();
                        for (Iterator<Element> k_items = t_item.elementIterator("K"); k_items.hasNext(); ) {
                            Element k_item = k_items.next();
                            List<String> x_entries = new ArrayList<>();
                            for(Iterator<Element> x_items = k_item.elementIterator("X"); x_items.hasNext(); ){
                                x_entries.add(x_items.next().valueOf("@value"));
                            }

                            K_Entry k_entry = new K_Entry();
                            k_entry.setName(k_item.valueOf("@value"));
                            if(x_entries.size() != 0) k_entry.setX_entries(x_entries);
                            k_entries.add(k_entry);
                        }

                        T_Entry t_entry = new T_Entry();
                        t_entry.setName(t_item.valueOf("@value"));
                        if (k_entries.size() != 0) {
                            t_entry.setK_entries(k_entries);
                        }

                        t_entries.add(t_entry);
                    }
                    legalArticles.add(new LegalArticle(lawName, t_entries));
                }

                refereeAnalysisProcess = new RefereeAnalysisProcess();
                refereeAnalysisProcess.setCaseID(caseID);

                if (legalArticles.size() != 0) {
                    refereeAnalysisProcess.setLegalArticles(legalArticles);
                }

            }
        }

        //判决结果
        Node result = findSingleNode("PJJG");
        JudgementResult judgementResult = null;
        if (result != null) {
            judgementResult = new JudgementResult(caseID, result.valueOf("@value"));
        }

        return new Case(fullText, header, litigationParticipants, proceedings, caseBasic, refereeAnalysisProcess, judgementResult, new Tailor());
    }

    private int findFirstLetter(String qw) {

        int i = 0;
        char c = qw.charAt(i);
        while(c == '。' || c == ' ' ){
            i++;
            c = qw.charAt(i);
        }
        return i;
    }

    /**
     *
     * @param parent 父节点
     * @param side 起诉方、应诉方
     * @return
     */
    private List<LitigationParticipant> findLitigantsOneSide(Element parent, String side){
        List<LitigationParticipant> litigants = new ArrayList<>();

        Iterator<Element> children = parent.elementIterator(side);

        while(children.hasNext()){
            Element child = children.next();
            Element name = child.element("SSCYR");
            Element partiesType = child.element("SSSF");

            LitigationParticipant participant = new LitigationParticipant();
            if (name != null) participant.setName(name.valueOf("@value"));
            if (partiesType != null)
                participant.setPartiesType(partiesType.valueOf("@value"));
            litigants.add(participant);
        }
        return litigants;
    }
}