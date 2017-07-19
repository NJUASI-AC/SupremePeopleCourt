package com.edu.nju.asi.InfoCarrier;

import com.edu.nju.asi.model.*;
import com.edu.nju.asi.utilities.enums.DocumentName;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by 61990 on 2017/7/18.
 */

/**
 * Created by 61990 on 2017/7/18.
 * <p>
 * 案件的用于推荐筛选的信息
 */
public class RecommendCase {


    /**
     * 案号
     */
    private String caseID;

    /**
     * 诉讼记录
     */
    private String records;

    /**
     * 案由代码
     */
    private String actionCode;

    /**
     * 证据段
     */
    private List<String> evidence;

    /**
     * 查明事实段
     */
    private List<String> fact;

    /**
     * 裁判分析过程
     */
    private RefereeAnalysisProcess refereeAnalysisProcess;

    /**
     * 经办法院
     */
    private String handlingCourt;

    /**
     * 案由
     */
    private String actionCause;

    /**
     * 文书名称
     */
    private DocumentName nameOfDocument;

    public RecommendCase(String caseID, String records, String actionCode, List<String> evidence, List<String> fact, RefereeAnalysisProcess refereeAnalysisProcess, String handlingCourt, String actionCause, DocumentName nameOfDocument) {
        this.caseID = caseID;
        this.records = records;
        this.actionCode = actionCode;
        this.evidence = evidence;
        this.fact = fact;
        this.refereeAnalysisProcess = refereeAnalysisProcess;
        this.handlingCourt = handlingCourt;
        this.actionCause = actionCause;
        this.nameOfDocument = nameOfDocument;
    }

    public RecommendCase(Case newCase) {
        this.caseID = newCase.getCaseBasic().getCaseID();
        this.records = newCase.getProceedings().getRecords();
        this.actionCode = newCase.getProceedings().getActionCode();
        this.evidence = newCase.getCaseBasic().getEvidence();
        this.fact = newCase.getCaseBasic().getFacts();
        this.refereeAnalysisProcess = newCase.getRefereeAnalysisProcess();
        this.handlingCourt = newCase.getHeader().getHandlingCourt();
        this.actionCause = newCase.getProceedings().getActionCause();
        this.nameOfDocument = newCase.getHeader().getNameOfDocument();
    }

    public RecommendCase(CaseBasic caseBasic, Proceedings proceedings, RefereeAnalysisProcess refereeAnalysisProcess, Header header) {

        this.caseID = proceedings.getCaseID();
        this.records = proceedings.getRecords();
        this.actionCode = proceedings.getActionCode();
        this.actionCause = proceedings.getActionCause();

        if (caseBasic != null) {
            this.evidence = caseBasic.getEvidence();
            this.fact = caseBasic.getFacts();
        }

        if (header != null) {
            this.handlingCourt = header.getHandlingCourt();
            this.nameOfDocument = header.getNameOfDocument();
        }

        this.refereeAnalysisProcess = refereeAnalysisProcess;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public List<String> getEvidence() {
        return evidence;
    }

    public void setEvidence(List<String> evidence) {
        this.evidence = evidence;
    }

    public List<String> getFact() {
        return fact;
    }

    public void setFact(List<String> fact) {
        this.fact = fact;
    }

    public RefereeAnalysisProcess getRefereeAnalysisProcess() {
        return refereeAnalysisProcess;
    }

    public void setRefereeAnalysisProcess(RefereeAnalysisProcess refereeAnalysisProcess) {
        this.refereeAnalysisProcess = refereeAnalysisProcess;
    }

    public String getHandlingCourt() {
        return handlingCourt;
    }

    public void setHandlingCourt(String handlingCourt) {
        this.handlingCourt = handlingCourt;
    }

    public String getActionCause() {
        return actionCause;
    }

    public void setActionCause(String actionCause) {
        this.actionCause = actionCause;
    }

    public DocumentName getNameOfDocument() {
        return nameOfDocument;
    }

    public void setNameOfDocument(DocumentName nameOfDocument) {
        this.nameOfDocument = nameOfDocument;
    }

}
