package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Document
public class LitigationParticipants implements Serializable {

    /**
     *  案号
     * */
    @Id
    private String caseNumber;

    /**
     *  原告
     * */
    private List<LitigationParticipant> plaintiffs;

    /**
     *  被告
     * */
    private List<LitigationParticipant> defendants;

    public LitigationParticipants() {
    }

    public LitigationParticipants(String caseNumber, List<LitigationParticipant> plaintiffs, List<LitigationParticipant> defendants) {
        this.caseNumber = caseNumber;
        this.plaintiffs = plaintiffs;
        this.defendants = defendants;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public List<LitigationParticipant> getPlaintiffs() {
        return plaintiffs;
    }

    public void setPlaintiffs(List<LitigationParticipant> plaintiffs) {
        this.plaintiffs = plaintiffs;
    }

    public List<LitigationParticipant> getDefendants() {
        return defendants;
    }

    public void setDefendants(List<LitigationParticipant> defendants) {
        this.defendants = defendants;
    }
}
