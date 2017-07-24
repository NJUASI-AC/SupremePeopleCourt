package com.edu.nju.asi.InfoCarrier;

import com.edu.nju.asi.model.*;

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
     *  案件ID
     * */
    private String caseID;

    /**
     * 案号
     */
    private String caseNum;

    /**
     * 诉讼记录
     */
    private String records;

    /**
     * 主案由
     */
    private ActionCause mainActionCause;


    /**
     * 其它案由
     */
    private List<ActionCause>  extraActionCause;


    /**
     * 本审审理段
     */
    private String paragraphThisTrial;


    /**
     * 裁判分析过程
     */
    private RefereeAnalysisProcess refereeAnalysisProcess;

    /**
     * 经办法院
     */
    private String handlingCourt;

    /**
     * 文书名称
     */
    private String nameOfDocument;

    public RecommendCase(String caseID, String caseNum, String records, ActionCause mainActionCause, List<ActionCause> extraActionCause, String paragraphThisTrial, RefereeAnalysisProcess refereeAnalysisProcess, String handlingCourt, String nameOfDocument) {
        this.caseID = caseID;
        this.caseNum = caseNum;
        this.records = records;
        this.mainActionCause = mainActionCause;
        this.extraActionCause = extraActionCause;
        this.paragraphThisTrial = paragraphThisTrial;
        this.refereeAnalysisProcess = refereeAnalysisProcess;
        this.handlingCourt = handlingCourt;
        this.nameOfDocument = nameOfDocument;
    }

    public RecommendCase(Case newCase) {

        this.caseID = newCase.getCaseID();

        if(newCase.getHeader()!=null){
            this.caseNum = newCase.getHeader().getCaseNum();
            this.handlingCourt = newCase.getHeader().getHandlingCourt();
            this.nameOfDocument = newCase.getHeader().getNameOfDocument();
        }

        if(newCase.getProceedings()!=null){
            this.records = newCase.getProceedings().getRecords();
            this.mainActionCause = newCase.getProceedings().getMainActionCause();
            this.extraActionCause = newCase.getProceedings().getExtraActionCause();
        }
        if(newCase.getCaseBasic()!=null){
            this.paragraphThisTrial = newCase.getCaseBasic().getParagraphThisTrial();
        }

        this.refereeAnalysisProcess = newCase.getRefereeAnalysisProcess();

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

    public ActionCause getMainActionCause() {
        return mainActionCause;
    }

    public void setMainActionCause(ActionCause mainActionCause) {
        this.mainActionCause = mainActionCause;
    }

    public List<ActionCause>  getExtraActionCause() {
        return extraActionCause;
    }

    public void setExtraActionCause(List<ActionCause> extraActionCause) {
        this.extraActionCause = extraActionCause;
    }

    public String getParagraphThisTrial() {
        return paragraphThisTrial;
    }

    public void setParagraphThisTrial(String paragraphThisTrial) {
        this.paragraphThisTrial = paragraphThisTrial;
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

    public String getNameOfDocument() {
        return nameOfDocument;
    }

    public void setNameOfDocument(String nameOfDocument) {
        this.nameOfDocument = nameOfDocument;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }
}
