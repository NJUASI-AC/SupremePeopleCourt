package com.edu.nju.asi.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public class CaseID implements Serializable {

    //经办法院
    private String handlingCourt;

    //案号
    private String caseNumber;

    //裁定时间
    private LocalDate refereeDate;

    public CaseID() {
    }

    public CaseID(String handlingCourt, String caseNumber, LocalDate refereeDate) {
        this.handlingCourt = handlingCourt;
        this.caseNumber = caseNumber;
        this.refereeDate = refereeDate;
    }

    public String getHandlingCourt() {
        return handlingCourt;
    }

    public void setHandlingCourt(String handlingCourt) {
        this.handlingCourt = handlingCourt;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public LocalDate getRefereeDate() {
        return refereeDate;
    }

    public void setRefereeDate(LocalDate refereeDate) {
        this.refereeDate = refereeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaseID caseID = (CaseID) o;

        if (handlingCourt != null ? !handlingCourt.equals(caseID.handlingCourt) : caseID.handlingCourt != null)
            return false;
        if (caseNumber != null ? !caseNumber.equals(caseID.caseNumber) : caseID.caseNumber != null) return false;
        return refereeDate != null ? refereeDate.equals(caseID.refereeDate) : caseID.refereeDate == null;
    }

    @Override
    public int hashCode() {
        int result = handlingCourt != null ? handlingCourt.hashCode() : 0;
        result = 31 * result + (caseNumber != null ? caseNumber.hashCode() : 0);
        result = 31 * result + (refereeDate != null ? refereeDate.hashCode() : 0);
        return result;
    }
}
