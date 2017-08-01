package com.edu.nju.asi.model;

import com.edu.nju.asi.infoCarrier.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by cuihua on 2017/7/17.
 *
 * 案件的整体信息
 */
@Document
public class Case implements Serializable{

    /**
     * caseID
     */
    @Id
    private String caseID;

    /**
     * 全文
     */
    private FullText fullText;

    /**
     * 文首
     */
    private Header header;

    /**
     * 诉讼参与人
     */
    private LitigationParticipants litigationParticipants;

    /**
     * 诉讼记录
     */
    private Proceedings proceedings;

    /**
     * 案件基本情况
     */
    private CaseBasic caseBasic;

    /**
     * 裁判分析过程
     */
    private RefereeAnalysisProcess refereeAnalysisProcess;

    /**
     * 裁判结果
     */
    private JudgementResult judgementResult;

    /**
     * 文尾
     */
    private Tailor tailor;

    public Case() {
    }

    public Case(FullText fullText, Header header, LitigationParticipants litigationParticipants, Proceedings proceedings, CaseBasic caseBasic, RefereeAnalysisProcess refereeAnalysisProcess, JudgementResult judgementResult) {
        this.fullText = fullText;
        this.header = header;
        this.litigationParticipants = litigationParticipants;
        this.proceedings = proceedings;
        this.caseBasic = caseBasic;
        this.refereeAnalysisProcess = refereeAnalysisProcess;
        this.judgementResult = judgementResult;
    }

    public Case(String caseID, FullText fullText, Header header, LitigationParticipants litigationParticipants, Proceedings proceedings, CaseBasic caseBasic, RefereeAnalysisProcess refereeAnalysisProcess, JudgementResult judgementResult, Tailor tailor) {
        this.caseID = caseID;
        this.fullText = fullText;
        this.header = header;
        this.litigationParticipants = litigationParticipants;
        this.proceedings = proceedings;
        this.caseBasic = caseBasic;
        this.refereeAnalysisProcess = refereeAnalysisProcess;
        this.judgementResult = judgementResult;
        this.tailor = tailor;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public FullText getFullText() {
        return fullText;
    }

    public void setFullText(FullText fullText) {
        this.fullText = fullText;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public LitigationParticipants getLitigationParticipants() {
        return litigationParticipants;
    }

    public void setLitigationParticipants(LitigationParticipants litigationParticipants) {
        this.litigationParticipants = litigationParticipants;
    }

    public Proceedings getProceedings() {
        return proceedings;
    }

    public void setProceedings(Proceedings proceedings) {
        this.proceedings = proceedings;
    }

    public CaseBasic getCaseBasic() {
        return caseBasic;
    }

    public void setCaseBasic(CaseBasic caseBasic) {
        this.caseBasic = caseBasic;
    }

    public RefereeAnalysisProcess getRefereeAnalysisProcess() {
        return refereeAnalysisProcess;
    }

    public void setRefereeAnalysisProcess(RefereeAnalysisProcess refereeAnalysisProcess) {
        this.refereeAnalysisProcess = refereeAnalysisProcess;
    }

    public JudgementResult getJudgementResult() {
        return judgementResult;
    }

    public void setJudgementResult(JudgementResult judgementResult) {
        this.judgementResult = judgementResult;
    }

    public Tailor getTailor() {
        return tailor;
    }

    public void setTailor(Tailor tailor) {
        this.tailor = tailor;
    }
}
