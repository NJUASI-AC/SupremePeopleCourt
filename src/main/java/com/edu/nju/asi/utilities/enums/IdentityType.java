package com.edu.nju.asi.utilities.enums;

/**
 * Created by cuihua on 2017/7/17.
 *
 * 诉讼身份
 */
public enum IdentityType {

    PLAINTIFF("原告"),
    ACCUSED("被告"),
    ATTORNEY("委托代理人");

    private String repre;

    IdentityType(String repre) {
        this.repre = repre;
    }

    public String getRepre() {
        return repre;
    }

    public IdentityType getEnum(String repre) {
        for (IdentityType nowEnum : IdentityType.values()) {
            if (nowEnum.getRepre().equals(repre)) {
                return nowEnum;
            }
        }
        return null;
    }
}
