package com.edu.nju.asi.infoCarrier;

import com.edu.nju.asi.utilities.enums.LitigationType;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/17 0017.
 *
 * 诉讼费承担
 */
public class LitigationCost implements Serializable{

    /**
     * 记录
     */
    private String record;

    /**
     * 金额
     */
    private int money;

    /**
     * 诉讼费种类
     * 注：还包含承担人列表，但暂时数据库中未包含【如：（2008）东民初字第3902号】
     */
    private LitigationType litigationType;

    public LitigationCost() {
    }

    public LitigationCost(String record, int money, LitigationType litigationType) {
        this.record = record;
        this.money = money;
        this.litigationType = litigationType;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public LitigationType getLitigationType() {
        return litigationType;
    }

    public void setLitigationType(LitigationType litigationType) {
        this.litigationType = litigationType;
    }
}
