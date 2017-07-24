package com.edu.nju.asi.InfoCarrier;

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
public class CaseBasic implements Serializable {

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