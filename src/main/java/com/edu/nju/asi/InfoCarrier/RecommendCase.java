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

    public RecommendCase(String caseID, String records, String actionCause, List<String> evidence, List<String> fact, RefereeAnalysisProcess refereeAnalysisProcess) {
        this.caseID = caseID;
        this.records = records;
        this.actionCause = actionCause;
        this.evidence = evidence;
        this.fact = fact;
        this.refereeAnalysisProcess = refereeAnalysisProcess;
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
     * 案由
     */
    private String actionCause;

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

    public String getActionCause() {
        return actionCause;
    }

    public void setActionCause(String actionCause) {
        this.actionCause = actionCause;
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
