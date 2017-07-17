package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Byron Dong on 2017/7/17.
 *
 * 裁判分析过程
 */
@Document
public class RefereeAnalysisProcess implements Serializable {


    /**
     * 案号
     */
    @Id
    private String caseID;

    /**
     * 结案方式类型
     */
    private String closeCaseType;

    /**
     * 涉及法律
     */
    private List<LegalArticles> legalArticles;

    public RefereeAnalysisProcess() {
    }

    public RefereeAnalysisProcess(String caseNum, String closeCaseType, List<LegalArticles> legalArticles) {
        this.caseID = caseNum;
        this.closeCaseType = closeCaseType;
        this.legalArticles = legalArticles;
    }

    public String getCaseNum() {
        return caseID;
    }

    public void setCaseNum(String caseNum) {
        this.caseID = caseNum;
    }

    public String getCloseCaseType() {
        return closeCaseType;
    }

    public void setCloseCaseType(String closeCaseType) {
        this.closeCaseType = closeCaseType;
    }

    public List<LegalArticles> getLegalArticles() {
        return legalArticles;
    }

    public void setLegalArticles(List<LegalArticles> legalArticles) {
        this.legalArticles = legalArticles;
    }
}
