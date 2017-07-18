package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Byron Dong on 2017/7/17.
 *
 * 诉讼记录
 */
@Document
public class Proceedings implements Serializable {

    /**
     * 案号
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
     * 开庭审理
     */
//    private boolean isCourtHearing;

    /**
     * 开庭审理信息
     */
//    private String trialInformation;

    /**
     * 案由代码
     */
    private String actionCode;

    /**
     * 立案日期
     */
//    private LocalDate FilingDate;

    /**
     * （一审）案件适用程序
     */
//    private String caseApplicationProcedure;

    /**
     * 案件来源
     */
//    private String  caseSources;

    /**
     * 受理日期
     */
//    private LocalDate handleDate;

    /**
     * 简易转普通
     */
//    private boolean isEasyTransfer;

    public Proceedings() {
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getActionCause() {
        return actionCause;
    }

    public void setActionCause(String actionCause) {
        this.actionCause = actionCause;
    }

//    public boolean isCourtHearing() {
//        return isCourtHearing;
//    }
//
//    public void setCourtHearing(boolean courtHearing) {
//        isCourtHearing = courtHearing;
//    }
//
//    public String getTrialInformation() {
//        return trialInformation;
//    }
//
//    public void setTrialInformation(String trialInformation) {
//        this.trialInformation = trialInformation;
//    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

//    public LocalDate getFilingDate() {
//        return FilingDate;
//    }
//
//    public void setFilingDate(LocalDate filingDate) {
//        FilingDate = filingDate;
//    }
//
//    public String getCaseApplicationProcedure() {
//        return caseApplicationProcedure;
//    }
//
//    public void setCaseApplicationProcedure(String caseApplicationProcedure) {
//        this.caseApplicationProcedure = caseApplicationProcedure;
//    }
//
//    public String getCaseSources() {
//        return caseSources;
//    }
//
//    public void setCaseSources(String caseSources) {
//        this.caseSources = caseSources;
//    }
//
//    public LocalDate getHandleDate() {
//        return handleDate;
//    }
//
//    public void setHandleDate(LocalDate handleDate) {
//        this.handleDate = handleDate;
//    }
//
//    public boolean isEasyTransfer() {
//        return isEasyTransfer;
//    }
//
//    public void setEasyTransfer(boolean easyTransfer) {
//        isEasyTransfer = easyTransfer;
//    }
}
