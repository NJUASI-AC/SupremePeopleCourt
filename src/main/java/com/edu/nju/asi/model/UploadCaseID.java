package com.edu.nju.asi.model;

import java.io.Serializable;

/**
 * Created by Byron Dong on 2017/7/28.
 */
public class UploadCaseID implements Serializable{

    /**
     * 法官工号
     * */
    private String workID;

    /**
     * 上传caseID
     * */
    private String caseID;

    public UploadCaseID() {
    }

    public UploadCaseID(String workID, String caseID) {
        this.workID = workID;
        this.caseID = caseID;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UploadCaseID that = (UploadCaseID) o;

        if (workID != null ? !workID.equals(that.workID) : that.workID != null) return false;
        return caseID != null ? caseID.equals(that.caseID) : that.caseID == null;
    }

    @Override
    public int hashCode() {
        int result = workID != null ? workID.hashCode() : 0;
        result = 31 * result + (caseID != null ? caseID.hashCode() : 0);
        return result;
    }
}
