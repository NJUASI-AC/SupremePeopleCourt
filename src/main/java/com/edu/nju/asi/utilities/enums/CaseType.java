package com.edu.nju.asi.utilities.enums;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public enum CaseType {

    CIVIL_CASE("民事案件");

    private String repre;

    CaseType(String repre) {
        this.repre = repre;
    }

    /**
     *
     * @return 该枚举相对应的文件中形式
     *
     * enum TO String
     * 便于写入数据库
     */
    public String getRepre() {
        return repre;
    }

    public static CaseType getEnum(String str){
        for (CaseType nowEnum : CaseType.values()) {
            if (nowEnum.getRepre().equals(str)){
                return nowEnum;
            }
        }
        return null;
    }
}
