package com.edu.nju.asi.model;

import com.edu.nju.asi.InfoCarrier.CaseID;
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
     * 案件ID（文件名唯一）
     */
    @Id
    private CaseID caseID;

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

    public CaseID getCaseID() {
        return caseID;
    }

    public void setCaseID(CaseID caseID) {
        this.caseID = caseID;
    }

    public String getActionCause() {
        return actionCause;
    }

    public void setActionCause(String actionCause) {
        this.actionCause = actionCause;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

}
