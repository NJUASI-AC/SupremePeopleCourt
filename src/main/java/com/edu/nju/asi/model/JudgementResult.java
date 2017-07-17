package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17 0017.
 *
 * 裁判结果
 */
@Document
public class JudgementResult implements Serializable{

    @Id
    private String caseNum;

    /**
     * 结案方式
     */
    private String caseSettlement;

    /**
     * 同时起诉侵权人与保险公司的赔偿顺序
     */
    private String compensationOrder;

    /**
     * 具体裁判段
     * 注：可能包含其他字段（如权利人、义务人、判决金额），但暂时数据库中未包含【如：（2008）东民初字第3902号】
     */
    private List<String> specificRefereeSection;

    /**
     * 诉讼费承担
     */
    private List<LitigationCost> litigationCostList;

    /**
     * 是否发回重审
     */
    private boolean isReview;

    /**
     * 可上诉至
     */
    private String upTo;

    /**
     * 上诉期限
     */
    private int upPeriod;

    /**
     * 是否提出管辖权异议
     */
    private boolean hasConsultJurisdictionObjection;

    public JudgementResult() {
    }

    public JudgementResult(String caseNum, String caseSettlement, String compensationOrder, List<String> specificRefereeSection, List<LitigationCost> litigationCostList, boolean isReview, String upTo, int upPeriod, boolean hasConsultJurisdictionObjection) {
        this.caseNum = caseNum;
        this.caseSettlement = caseSettlement;
        this.compensationOrder = compensationOrder;
        this.specificRefereeSection = specificRefereeSection;
        this.litigationCostList = litigationCostList;
        this.isReview = isReview;
        this.upTo = upTo;
        this.upPeriod = upPeriod;
        this.hasConsultJurisdictionObjection = hasConsultJurisdictionObjection;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getCaseSettlement() {
        return caseSettlement;
    }

    public void setCaseSettlement(String caseSettlement) {
        this.caseSettlement = caseSettlement;
    }

    public String getCompensationOrder() {
        return compensationOrder;
    }

    public void setCompensationOrder(String compensationOrder) {
        this.compensationOrder = compensationOrder;
    }

    public List<String> getSpecificRefereeSection() {
        return specificRefereeSection;
    }

    public void setSpecificRefereeSection(List<String> specificRefereeSection) {
        this.specificRefereeSection = specificRefereeSection;
    }

    public List<LitigationCost> getLitigationCostList() {
        return litigationCostList;
    }

    public void setLitigationCostList(List<LitigationCost> litigationCostList) {
        this.litigationCostList = litigationCostList;
    }

    public boolean isReview() {
        return isReview;
    }

    public void setReview(boolean review) {
        this.isReview = review;
    }

    public String getUpTo() {
        return upTo;
    }

    public void setUpTo(String upTo) {
        this.upTo = upTo;
    }

    public int getUpPeriod() {
        return upPeriod;
    }

    public void setUpPeriod(int upPeriod) {
        this.upPeriod = upPeriod;
    }

    public boolean isHasConsultJurisdictionObjection() {
        return hasConsultJurisdictionObjection;
    }

    public void setHasConsultJurisdictionObjection(boolean hasConsultJurisdictionObjection) {
        this.hasConsultJurisdictionObjection = hasConsultJurisdictionObjection;
    }
}
