package com.edu.nju.asi.InfoCarrier;

import com.edu.nju.asi.utilities.enums.DocumentName;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by 61990 on 2017/7/18.
 */
public class RecommendWeight {

    public RecommendWeight(String caseID, double weight, String handlingCourt, String actionCause, DocumentName nameOfDocument) {
        this.caseID = caseID;
        this.weight = weight;
        this.handlingCourt = handlingCourt;
        this.actionCause = actionCause;
        this.nameOfDocument = nameOfDocument;
    }


    /**
     *  案号
     */
    private String caseID;

    /**
     *  权重
     */
    private double weight;

    /**
     * 经办法院
     */
    private String handlingCourt;

    /**
     * 案由
     */
    private String actionCause;

    /**
     * 文书名称
     */
    private DocumentName nameOfDocument;



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

    public String getHandlingCourt() {
        return handlingCourt;
    }

    public void setHandlingCourt(String handlingCourt) {
        this.handlingCourt = handlingCourt;
    }

    public String getActionCause() {
        return actionCause;
    }

    public void setActionCause(String actionCause) {
        this.actionCause = actionCause;
    }

    public DocumentName getNameOfDocument() {
        return nameOfDocument;
    }

    public void setNameOfDocument(DocumentName nameOfDocument) {
        this.nameOfDocument = nameOfDocument;
    }
}
