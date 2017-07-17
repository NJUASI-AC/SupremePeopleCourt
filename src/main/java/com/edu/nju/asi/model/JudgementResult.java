package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
@Document
public class JudgementResult implements Serializable{

    @Id
    private String caseID;

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

}
