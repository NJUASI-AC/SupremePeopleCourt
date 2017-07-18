package com.edu.nju.asi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/17 0017.
 * <p>
 * 文尾实体类
 */
@Document
public class Tailor implements Serializable {

    //    /**
//     * 案号
//     */
//    @Id
//    private String caseID;
//
//    /**
//     * 审判员
//     */
//    private Map<String, String> judges = new HashMap<>();
//
//    /**
//     * 裁决时间
//     */
//    private String judgeTime;
//
    public Tailor() {
    }

//    public Tailor(String caseID, Map<String, String> judges, String judgeTime) {
//        this.caseID = caseID;
//        this.judges = judges;
//        this.judgeTime = judgeTime;
//    }
//
//    public String getCaseID() {
//        return caseID;
//    }
//
//    public void setCaseID(String caseNum) {
//        this.caseID = caseNum;
//    }
//
//    public Map<String, String> getJudges() {
//        return judges;
//    }
//
//    public void setJudges(Map<String, String> judges) {
//        this.judges = judges;
//    }
//
//    public String getJudgeTime() {
//        return judgeTime;
//    }
//
//    public void setJudgeTime(String judgeTime) {
//        this.judgeTime = judgeTime;
//    }
}
