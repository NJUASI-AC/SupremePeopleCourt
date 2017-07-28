package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Byron Dong on 2017/7/28.
 */
@Document
public class UploadCase implements Serializable{

    /**
     * 上传caseID
     * */
    @Id
    private UploadCaseID uploadCaseID;

    /**
     * 上传case
     * */
    private Case uploadCase;

    public UploadCase() {
    }

    public UploadCase(UploadCaseID uploadCaseID, Case uploadCase) {
        this.uploadCaseID = uploadCaseID;
        this.uploadCase = uploadCase;
    }

    public UploadCaseID getUploadCaseID() {
        return uploadCaseID;
    }

    public void setUploadCaseID(UploadCaseID uploadCaseID) {
        this.uploadCaseID = uploadCaseID;
    }

    public Case getUploadCase() {
        return uploadCase;
    }

    public void setUploadCase(Case uploadCase) {
        this.uploadCase = uploadCase;
    }
}
