package com.edu.nju.asi.InfoCarrier;

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
public class Header implements Serializable {

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
    private String nameOfDocument;

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

    public String getNameOfDocument() {
        return nameOfDocument;
    }

    public void setNameOfDocument(String nameOfDocument) {
        this.nameOfDocument = nameOfDocument;
    }

    public void setCourtLevel(String courtLevel) {
        this.courtLevel = courtLevel;
    }

    public void setAdministrativeDivision(String administrativeDivision) {
        this.administrativeDivision = administrativeDivision;
    }

    public void setFilingYear(int filingYear) {
        this.filingYear = filingYear;
    }

    public void setNatureOfCase(CaseType natureOfCase) {
        this.natureOfCase = natureOfCase;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getCourtLevel() {

        return courtLevel;
    }

    public String getAdministrativeDivision() {
        return administrativeDivision;
    }

    public int getFilingYear() {
        return filingYear;
    }

    public CaseType getNatureOfCase() {
        return natureOfCase;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public TrialProcedure getTrialProcedure() {
        return trialProcedure;
    }

    public void setTrialProcedure(TrialProcedure trialProcedure) {
        this.trialProcedure = trialProcedure;
    }
}
