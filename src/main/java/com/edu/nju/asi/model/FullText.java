package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
@Document
public class FullText implements Serializable{

    /**
     * 案件ID（文件名唯一）
     */
    @Id
    private String caseID;

    /**
     * 全文
     */
    private String text;

    public FullText() {
    }

    public FullText(String caseID, String text) {
        this.caseID = caseID;
        this.text = text;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
