package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17 0017.
 *
 * 案件基本情况
 */
@Document
public class CaseBasic implements Serializable {

    /**
     * 案号
     */
    @Id
    private String caseID;

    /**
     * 原告诉称段
     * 注：还包含诉讼金额等，但暂时数据库中未包含【如：（2008）东民初字第3902号】
     */
    private String plaintiffClaim;

    /*
     * 事故详情
     */
    /**
     * 事故时间
     */
//    private LocalDateTime accidentTime;

    /**
     * 事故地点
     */
//    private String accidentAddress;

    /**
     * 机动车所有人
     * 注：不知道是个啥，似乎是被告
     */
//    private String defendant;

    /**
     * 受害人居住地
     */
//    private String aggrievedAddress;

    /**
     * 受害人职业
     */
//    private String aggrievedJob;

    /**
     * 被告辩称段
     */
    private String defendantArgue;

    /**
     * 证据段
     */
    private List<String> evidence;

    /**
     * 查明事实段
     */
    private List<String> facts;

    public CaseBasic() {
    }

    public CaseBasic(String caseID, String plaintiffClaim, LocalDateTime accidentTime, String accidentAddress, String defendant, String aggrievedAddress, String aggrievedJob, String defendantArgue, List<String> evidence, List<String> facts) {
        this.caseID = caseID;
        this.plaintiffClaim = plaintiffClaim;
//        this.accidentTime = accidentTime;
//        this.accidentAddress = accidentAddress;
//        this.defendant = defendant;
//        this.aggrievedAddress = aggrievedAddress;
//        this.aggrievedJob = aggrievedJob;
        this.defendantArgue = defendantArgue;
        this.evidence = evidence;
        this.facts = facts;
    }

    public CaseBasic(String caseID, String plaintiffClaim, String defendantArgue, List<String> evidence, List<String> facts) {
        this.caseID = caseID;
        this.plaintiffClaim = plaintiffClaim;
        this.defendantArgue = defendantArgue;
        this.evidence = evidence;
        this.facts = facts;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getPlaintiffClaim() {
        return plaintiffClaim;
    }

    public void setPlaintiffClaim(String plaintiffClaim) {
        this.plaintiffClaim = plaintiffClaim;
    }

//    public LocalDateTime getAccidentTime() {
//        return accidentTime;
//    }
//
//    public void setAccidentTime(LocalDateTime accidentTime) {
//        this.accidentTime = accidentTime;
//    }
//
//    public String getAccidentAddress() {
//        return accidentAddress;
//    }
//
//    public void setAccidentAddress(String accidentAddress) {
//        this.accidentAddress = accidentAddress;
//    }
//
//    public String getDefendant() {
//        return defendant;
//    }
//
//    public void setDefendant(String defendant) {
//        this.defendant = defendant;
//    }
//
//    public String getAggrievedAddress() {
//        return aggrievedAddress;
//    }
//
//    public void setAggrievedAddress(String aggrievedAddress) {
//        this.aggrievedAddress = aggrievedAddress;
//    }
//
//    public String getAggrievedJob() {
//        return aggrievedJob;
//    }
//
//    public void setAggrievedJob(String aggrievedJob) {
//        this.aggrievedJob = aggrievedJob;
//    }

    public String getDefendantArgue() {
        return defendantArgue;
    }

    public void setDefendantArgue(String defendantArgue) {
        this.defendantArgue = defendantArgue;
    }

    public List<String> getEvidence() {
        return evidence;
    }

    public void setEvidence(List<String> evidence) {
        this.evidence = evidence;
    }

    public List<String> getFacts() {
        return facts;
    }

    public void setFacts(List<String> facts) {
        this.facts = facts;
    }
}