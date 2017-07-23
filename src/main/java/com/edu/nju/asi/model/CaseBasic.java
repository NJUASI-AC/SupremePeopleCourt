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
     * 案件ID（文件名唯一）
     */
    @Id
    private String caseID;

    /**
     * 本审审理段
     */
    private String paragraphThisTrial;

    /**
     * 检查机关意见
     */
    private String inspectionOpinion;

    /**
     * 上诉申诉辩护意见
     */
    private String defenceOpinion;

    public CaseBasic() {
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getParagraphThisTrial() {
        return paragraphThisTrial;
    }

    public void setParagraphThisTrial(String paragraphThisTrial) {
        this.paragraphThisTrial = paragraphThisTrial;
    }

    public String getInspectionOpinion() {
        return inspectionOpinion;
    }

    public void setInspectionOpinion(String inspectionOpinion) {
        this.inspectionOpinion = inspectionOpinion;
    }

    public String getDefenceOpinion() {
        return defenceOpinion;
    }

    public void setDefenceOpinion(String defenceOpinion) {
        this.defenceOpinion = defenceOpinion;
    }
}