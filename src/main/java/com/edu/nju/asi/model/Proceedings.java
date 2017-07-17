package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Document
public class Proceedings implements Serializable {

    /**
     *  案号
     * */
    @Id
    private String caseNumber;

    /**
     *  案由
     * */
    private String actionCause;

    /**
     *  开庭审理
     * */
    private boolean isCourtHearing;

    /**
     *  开庭审理信息
     * */
    private String trialInformation;

    /**
     *  案由代码
     * */
    private String actionCode;

    /**
     *  案件适用程序
     * */
    private String caseApplicationProcedure;

    /**
     *  案件来源
     * */
    private String  caseSources;

    /**
     *  简易转普通
     * */
    private boolean isEasyTransfer;

    public Proceedings() {
    }

    public Proceedings(String caseNumber, String actionCause, boolean isCourtHearing, String trialInformation, String actionCode, String caseApplicationProcedure, String caseSources, boolean isEasyTransfer) {
        this.caseNumber = caseNumber;
        this.actionCause = actionCause;
        this.isCourtHearing = isCourtHearing;
        this.trialInformation = trialInformation;
        this.actionCode = actionCode;
        this.caseApplicationProcedure = caseApplicationProcedure;
        this.caseSources = caseSources;
        this.isEasyTransfer = isEasyTransfer;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getActionCause() {
        return actionCause;
    }

    public void setActionCause(String actionCause) {
        this.actionCause = actionCause;
    }

    public boolean isCourtHearing() {
        return isCourtHearing;
    }

    public void setCourtHearing(boolean courtHearing) {
        isCourtHearing = courtHearing;
    }

    public String getTrialInformation() {
        return trialInformation;
    }

    public void setTrialInformation(String trialInformation) {
        this.trialInformation = trialInformation;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getCaseApplicationProcedure() {
        return caseApplicationProcedure;
    }

    public void setCaseApplicationProcedure(String caseApplicationProcedure) {
        this.caseApplicationProcedure = caseApplicationProcedure;
    }

    public String getCaseSources() {
        return caseSources;
    }

    public void setCaseSources(String caseSources) {
        this.caseSources = caseSources;
    }

    public boolean isEasyTransfer() {
        return isEasyTransfer;
    }

    public void setEasyTransfer(boolean easyTransfer) {
        isEasyTransfer = easyTransfer;
    }
}
