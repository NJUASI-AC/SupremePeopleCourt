package com.edu.nju.asi.InfoCarrier;

import com.edu.nju.asi.InfoCarrier.ActionCause;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Byron Dong on 2017/7/17.
 *
 * 诉讼记录
 */
public class Proceedings implements Serializable {

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
     * 开庭审理
     */
    private boolean isCourtHearing;

    /**
     * 开庭审理信息
     */
    private String trialInformation;

    /**
     * 立案日期
     */
    private LocalDate FilingDate;

    /**
     * （一审）案件适用程序
     */
    private String caseApplicationProcedure;

    /**
     * 案件来源
     */
    private String  caseSources;

    /**
     * 受理日期
     */
    private LocalDate handleDate;

    /**
     * 简易转普通
     */
    private boolean isEasyTransfer;

    public Proceedings() {
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

    public List<ActionCause> getExtraActionCause() {
        return extraActionCause;
    }

    public void setExtraActionCause(List<ActionCause> extraActionCause) {
        this.extraActionCause = extraActionCause;
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

    public LocalDate getFilingDate() {
        return FilingDate;
    }

    public void setFilingDate(LocalDate filingDate) {
        FilingDate = filingDate;
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

    public LocalDate getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(LocalDate handleDate) {
        this.handleDate = handleDate;
    }

    public boolean isEasyTransfer() {
        return isEasyTransfer;
    }

    public void setEasyTransfer(boolean easyTransfer) {
        isEasyTransfer = easyTransfer;
    }
}
