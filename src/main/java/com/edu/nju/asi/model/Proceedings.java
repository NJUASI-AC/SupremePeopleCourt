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
    private String caseNum;

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

    public Proceedings(String caseNum, String actionCause, boolean isCourtHearing, String trialInformation, String actionCode, LocalDate filingDate, String caseApplicationProcedure, String caseSources, LocalDate handleDate, boolean isEasyTransfer) {
        this.caseNum = caseNum;
        this.actionCause = actionCause;
//        this.isCourtHearing = isCourtHearing;
//        this.trialInformation = trialInformation;
        this.actionCode = actionCode;
//        FilingDate = filingDate;
//        this.caseApplicationProcedure = caseApplicationProcedure;
//        this.caseSources = caseSources;
//        this.handleDate = handleDate;
//        this.isEasyTransfer = isEasyTransfer;
    }

    public Proceedings(String caseNum, String records, String actionCause, String actionCode) {
        this.caseNum = caseNum;
        this.records = records;
        this.actionCause = actionCause;
        this.actionCode = actionCode;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
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
