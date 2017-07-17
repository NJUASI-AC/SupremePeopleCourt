package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Document
public class RefereeAnalysisProcess implements Serializable {

    /**
     *  结案方式类型
     * */
    @Id
    private String closeCaseType;

    /**
     *  法律
     * */
    private List<LegalArticles> legalArticles;

    public RefereeAnalysisProcess() {
    }

    public RefereeAnalysisProcess(String closeCaseType, List<LegalArticles> legalArticles) {
        this.closeCaseType = closeCaseType;
        this.legalArticles = legalArticles;
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
