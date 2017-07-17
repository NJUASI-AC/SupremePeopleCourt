package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17 0017.
 *
 * 判决结果
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
     */
    private String specificRefereeSection;

    /**
     * 诉讼费承担
     */
    private List<LitigationCost> litigationCostList;

    public JudgementResult() {
    }

    public JudgementResult(String caseNum, String caseSettlement, String compensationOrder, String specificRefereeSection, List<LitigationCost> litigationCostList) {
        this.caseNum = caseNum;
        this.caseSettlement = caseSettlement;
        this.compensationOrder = compensationOrder;
        this.specificRefereeSection = specificRefereeSection;
        this.litigationCostList = litigationCostList;
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

    public String getSpecificRefereeSection() {
        return specificRefereeSection;
    }

    public void setSpecificRefereeSection(String specificRefereeSection) {
        this.specificRefereeSection = specificRefereeSection;
    }

    public List<LitigationCost> getLitigationCostList() {
        return litigationCostList;
    }

    public void setLitigationCostList(List<LitigationCost> litigationCostList) {
        this.litigationCostList = litigationCostList;
    }
}
