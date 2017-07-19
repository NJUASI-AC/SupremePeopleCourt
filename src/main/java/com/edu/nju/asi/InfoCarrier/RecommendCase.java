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

    public RecommendCase(String caseID, String records, String actionCode, List<String> evidence, List<String> fact, RefereeAnalysisProcess refereeAnalysisProcess) {
        this.caseID = caseID;
        this.records = records;
        this.actionCode = actionCode;
        this.evidence = evidence;
        this.fact = fact;
        this.refereeAnalysisProcess = refereeAnalysisProcess;
    }

    public RecommendCase(Case newCase) {
        this.caseID = newCase.getCaseBasic().getCaseID();
        this.records = newCase.getProceedings().getRecords();
        this.actionCode = newCase.getProceedings().getActionCode();
        this.evidence = newCase.getCaseBasic().getEvidence();
        this.fact = newCase.getCaseBasic().getFacts();
        this.refereeAnalysisProcess = newCase.getRefereeAnalysisProcess();
    }


    /**
     *  案号
     */
    @Id
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

    public RecommendCase(CaseBasic caseBasic, Proceedings proceedings, RefereeAnalysisProcess refereeAnalysisProcess) {

        this.caseID = proceedings.getCaseID();
        this.records = proceedings.getRecords();
        this.actionCode = proceedings.getActionCode();

        if (caseBasic != null) {
            this.evidence = caseBasic.getEvidence();
            this.fact = caseBasic.getFacts();
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


}
