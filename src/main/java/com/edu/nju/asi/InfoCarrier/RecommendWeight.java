package com.edu.nju.asi.InfoCarrier;

import org.springframework.data.annotation.Id;

/**
 * Created by 61990 on 2017/7/18.
 */
public class RecommendWeight {
    /**
     *  案号
     */
    @Id
    private String caseID;

    /**
     *  权重
     */
    private double weight;

    /**
     *  构造器
     */
    public RecommendWeight(String caseID) {
        this.caseID = caseID;
        this.weight = 0;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
