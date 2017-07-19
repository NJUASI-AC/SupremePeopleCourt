package com.edu.nju.asi.InfoCarrier;

import com.edu.nju.asi.model.*;

/**
 * Created by cuihua on 2017/7/17.
 *
 * 案件的整体信息
 */
public class Case {

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

    public Case(FullText fullText, Header header, LitigationParticipants litigationParticipants, Proceedings proceedings, CaseBasic caseBasic, RefereeAnalysisProcess refereeAnalysisProcess, JudgementResult judgementResult) {
        this.fullText = fullText;
        this.header = header;
        this.litigationParticipants = litigationParticipants;
        this.proceedings = proceedings;
        this.caseBasic = caseBasic;
        this.refereeAnalysisProcess = refereeAnalysisProcess;
        this.judgementResult = judgementResult;
    }

    public Case(FullText fullText, Header header, LitigationParticipants litigationParticipants, Proceedings proceedings, CaseBasic caseBasic, RefereeAnalysisProcess refereeAnalysisProcess, JudgementResult judgementResult, Tailor tailor) {
        this.fullText = fullText;
        this.header = header;
        this.litigationParticipants = litigationParticipants;
        this.proceedings = proceedings;
        this.caseBasic = caseBasic;
        this.refereeAnalysisProcess = refereeAnalysisProcess;
        this.judgementResult = judgementResult;
        this.tailor = tailor;
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
