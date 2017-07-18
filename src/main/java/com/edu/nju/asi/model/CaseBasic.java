package com.edu.nju.asi.model;

import com.edu.nju.asi.InfoCarrier.CaseID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
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
    private CaseID caseID;

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

    public CaseID getCaseID() {
        return caseID;
    }

    public void setCaseID(CaseID caseID) {
        this.caseID = caseID;
    }

    public String getPlaintiffClaim() {
        return plaintiffClaim;
    }

    public void setPlaintiffClaim(String plaintiffClaim) {
        this.plaintiffClaim = plaintiffClaim;
    }

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