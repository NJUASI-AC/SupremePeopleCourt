package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/7/17 0017.
 *
 * 案件基本情况
 */
@Document
public class CaseBasic implements Serializable{

    @Id
    private String caseID;

    /**
     * 原告诉称段
     */
    private String plaintiffClaim;

    /**
     * 事故详情
     */
    private String accidentDetail;

    /**
     * 事故时间
     */
    private LocalDateTime accidentTime;

    /**
     * 事故地点
     */
    private String accidentAddress;

    /**
     * 被告辩称段
     */
    private String defendantArgue;

    /**
     * 证据段
     */
    private String evidence;

    /**
     * 查明事实段
     */
    private String fact;

    public CaseBasic() {
    }

    public CaseBasic(String caseID, String plaintiffClaim, String accidentDetail, LocalDateTime accidentTime, String accidentAddress, String defendantArgue, String evidence, String fact) {
        this.caseID = caseID;
        this.plaintiffClaim = plaintiffClaim;
        this.accidentDetail = accidentDetail;
        this.accidentTime = accidentTime;
        this.accidentAddress = accidentAddress;
        this.defendantArgue = defendantArgue;
        this.evidence = evidence;
        this.fact = fact;
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

    public String getAccidentDetail() {
        return accidentDetail;
    }

    public void setAccidentDetail(String accidentDetail) {
        this.accidentDetail = accidentDetail;
    }

    public LocalDateTime getAccidentTime() {
        return accidentTime;
    }

    public void setAccidentTime(LocalDateTime accidentTime) {
        this.accidentTime = accidentTime;
    }

    public String getAccidentAddress() {
        return accidentAddress;
    }

    public void setAccidentAddress(String accidentAddress) {
        this.accidentAddress = accidentAddress;
    }

    public String getDefendantArgue() {
        return defendantArgue;
    }

    public void setDefendantArgue(String defendantArgue) {
        this.defendantArgue = defendantArgue;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
