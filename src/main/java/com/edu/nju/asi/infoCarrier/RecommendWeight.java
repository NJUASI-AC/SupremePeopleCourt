package com.edu.nju.asi.infoCarrier;

/**
 * Created by 61990 on 2017/7/18.
 */
public class RecommendWeight {

    public RecommendWeight(String caseID, String caseNum,double weight, String handlingCourt, String actionCause, String nameOfDocument) {
        this.caseID = caseID;
        this.caseNum = caseNum;
        this.weight = weight;
        this.handlingCourt = handlingCourt;
        this.actionCause = actionCause;
        this.nameOfDocument = nameOfDocument;
    }


    /**
     *  案号
     */
    private String caseID;

    /**
     *  案号
     */
    private String caseNum;

    /**
     *  权重
     */
    private double weight;

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
    private String nameOfDocument;



    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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

    public String getNameOfDocument() {
        return nameOfDocument;
    }

    public void setNameOfDocument(String nameOfDocument) {
        this.nameOfDocument = nameOfDocument;
    }
}
