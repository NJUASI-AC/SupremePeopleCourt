package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/17 0017.
 *
 * 裁判结果
 */
@Document
public class JudgementResult implements Serializable{

    /**
     * 案件ID（文件名唯一）
     */
    @Id
    private String caseID;

    /**
     * 裁判结果
     */
    private String result;

    /**
     * 结案方式
     */
//    private String caseSettlement;

    /**
     * 同时起诉侵权人与保险公司的赔偿顺序
     */
//    private String compensationOrder;

    /**
     * 具体裁判段
     * 注：可能包含其他字段（如权利人、义务人、判决金额），但暂时数据库中未包含【如：（2008）东民初字第3902号】
     */
//    private List<String> specificRefereeSection;

    /**
     * 诉讼费承担
     */
//    private List<LitigationCost> litigationCostList;

    /**
     * 是否发回重审
     */
//    private boolean isReview;

    /**
     * 可上诉至
     */
//    private String upTo;

    /**
     * 上诉期限
     */
//    private int upPeriod;

    /**
     * 是否提出管辖权异议
     */
//    private boolean hasConsultJurisdictionObjection;

    public JudgementResult() {
    }

    public JudgementResult(String caseID, String result) {
        this.caseID = caseID;
        this.result = result;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

}
