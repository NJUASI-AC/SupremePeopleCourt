package com.edu.nju.asi.model;

import com.edu.nju.asi.utilities.enums.CaseType;
import com.edu.nju.asi.utilities.enums.DocumentName;
import com.edu.nju.asi.utilities.enums.DocumentType;
import com.edu.nju.asi.utilities.enums.TrialProcedure;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Byron Dong on 2017/7/17.
 *
 * 文首
 */
@Document
public class Header implements Serializable {

    /**
     * 案件ID（文件名唯一）
     */
    @Id
    private String caseID;

    /**
     * 案号
     */
    private String caseNum;

    /**
     * 经办法院
     */
    private String handlingCourt;

    /**
     * 法院级别
     */
    private String courtLevel;

    /**
     * 行政区划（省）
     */
    private String administrativeDivision;

    /**
     * 文书名称
     */
    private DocumentName nameOfDocument;

    /**
     * 立案年度
     */
    private int filingYear;

    /**
     * 案件性质
     */
    private CaseType natureOfCase;

    /**
     * 文书种类
     */
    private DocumentType documentType;

    /**
     * 审判程序
     */
    private TrialProcedure trialProcedure;

    public Header() {
    }

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

    public String getHandlingCourt() {
        return handlingCourt;
    }

    public void setHandlingCourt(String handlingCourt) {
        this.handlingCourt = handlingCourt;
    }

    public DocumentName getNameOfDocument() {
        return nameOfDocument;
    }

    public void setNameOfDocument(DocumentName nameOfDocument) {
        this.nameOfDocument = nameOfDocument;
    }

    public TrialProcedure getTrialProcedure() {
        return trialProcedure;
    }

    public void setTrialProcedure(TrialProcedure trialProcedure) {
        this.trialProcedure = trialProcedure;
    }
}
