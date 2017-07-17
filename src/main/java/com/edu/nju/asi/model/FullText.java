package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
@Document
public class FullText {

    @Id
    private String caseNum;

    private String fullText;

    public FullText() {
    }

    public FullText(String caseNum, String fullText) {
        this.caseNum = caseNum;
        this.fullText = fullText;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }
}
