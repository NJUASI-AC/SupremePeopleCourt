package com.edu.nju.asi.InfoCarrier;

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
public class RefereeAnalysisProcess implements Serializable {

    public RefereeAnalysisProcess(String closeCaseType, List<LegalArticle> legalArticles) {
        this.closeCaseType = closeCaseType;
        this.legalArticles = legalArticles;
    }

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
