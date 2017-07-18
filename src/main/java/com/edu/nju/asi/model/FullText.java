package com.edu.nju.asi.model;

import com.edu.nju.asi.InfoCarrier.CaseID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
@Document
public class FullText implements Serializable{

    /**
     * 案号
     */
    @Id
    private CaseID caseID;

    /**
     * 全文
     */
    private String text;

    public FullText() {
    }

    public FullText(CaseID caseID, String text) {
        this.caseID = caseID;
        this.text = text;
    }

    public CaseID getCaseID() {
        return caseID;
    }

    public void setCaseID(CaseID caseID) {
        this.caseID = caseID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
