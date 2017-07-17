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
     *  案号
     */
    @Id
    private String caseID;

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

    public Header(String caseID, String handlingCourt, String courtLevel, String administrativeDivision, DocumentName nameOfDocument, int filingYear, CaseType natureOfCase, DocumentType documentType, TrialProcedure trialProcedure) {
        this.caseID = caseID;
        this.handlingCourt = handlingCourt;
        this.courtLevel = courtLevel;
        this.administrativeDivision = administrativeDivision;
        this.nameOfDocument = nameOfDocument;
        this.filingYear = filingYear;
        this.natureOfCase = natureOfCase;
        this.documentType = documentType;
        this.trialProcedure = trialProcedure;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getHandlingCourt() {
        return handlingCourt;
    }

    public void setHandlingCourt(String handlingCourt) {
        this.handlingCourt = handlingCourt;
    }

    public String getCourtLevel() {
        return courtLevel;
    }

    public void setCourtLevel(String courtLevel) {
        this.courtLevel = courtLevel;
    }

    public String getAdministrativeDivision() {
        return administrativeDivision;
    }

    public void setAdministrativeDivision(String administrativeDivision) {
        this.administrativeDivision = administrativeDivision;
    }

    public DocumentName getNameOfDocument() {
        return nameOfDocument;
    }

    public void setNameOfDocument(DocumentName nameOfDocument) {
        this.nameOfDocument = nameOfDocument;
    }

    public int getFilingYear() {
        return filingYear;
    }

    public void setFilingYear(int filingYear) {
        this.filingYear = filingYear;
    }

    public CaseType getNatureOfCase() {
        return natureOfCase;
    }

    public void setNatureOfCase(CaseType natureOfCase) {
        this.natureOfCase = natureOfCase;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public TrialProcedure getTrialProcedure() {
        return trialProcedure;
    }

    public void setTrialProcedure(TrialProcedure trialProcedure) {
        this.trialProcedure = trialProcedure;
    }
}
