package com.edu.nju.asi.InfoCarrier;

import com.edu.nju.asi.utilities.enums.DocumentName;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class CaseID implements Serializable{

    /**
     * 案号
     */
    private String caseNum;

    /**
     * 文书名称
     */
    private DocumentName documentName;

    public CaseID(String caseNum, DocumentName documentName) {
        this.caseNum = caseNum;
        this.documentName = documentName;
    }

    public CaseID() {
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public DocumentName getDocumentName() {
        return documentName;
    }

    public void setDocumentName(DocumentName documentName) {
        this.documentName = documentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaseID caseID = (CaseID) o;

        if (caseNum != null ? !caseNum.equals(caseID.caseNum) : caseID.caseNum != null) return false;
        return documentName == caseID.documentName;
    }

    @Override
    public int hashCode() {
        int result = caseNum != null ? caseNum.hashCode() : 0;
        result = 31 * result + (documentName != null ? documentName.hashCode() : 0);
        return result;
    }
}
