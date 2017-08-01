package com.edu.nju.asi.infoCarrier;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/17 0017.
 * <p>
 * 文尾实体类
 */
public class Tailor implements Serializable {

    /**
     * 审判员
     */
    private Map<String, String> judges = new HashMap<>();

    /**
     * 裁决时间
     */
    private String judgeTime;

    public Tailor() {
    }

    public Tailor(Map<String, String> judges, String judgeTime) {
        this.judges = judges;
        this.judgeTime = judgeTime;
    }

    public Map<String, String> getJudges() {
        return judges;
    }

    public void setJudges(Map<String, String> judges) {
        this.judges = judges;
    }

    public String getJudgeTime() {
        return judgeTime;
    }

    public void setJudgeTime(String judgeTime) {
        this.judgeTime = judgeTime;
    }
}
