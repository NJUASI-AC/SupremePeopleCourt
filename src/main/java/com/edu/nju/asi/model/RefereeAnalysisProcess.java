package com.edu.nju.asi.model;

import com.edu.nju.asi.InfoCarrier.LegalArticle;
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
     * 案件ID（文件名唯一）
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
    private List<LegalArticle> legalArticles;

    public RefereeAnalysisProcess() {
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getCloseCaseType() {
        return closeCaseType;
    }

    public void setCloseCaseType(String closeCaseType) {
        this.closeCaseType = closeCaseType;
    }

    public List<LegalArticle> getLegalArticles() {
        return legalArticles;
    }

    public void setLegalArticles(List<LegalArticle> legalArticles) {
        this.legalArticles = legalArticles;
    }
}
