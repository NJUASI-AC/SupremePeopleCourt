package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
@Document
public class FullText implements Serializable{

    @Id
    private String caseNum;

    private String text;

    public FullText() {
    }

    public FullText(String caseNum, String text) {
        this.caseNum = caseNum;
        this.text = text;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
