package com.edu.nju.asi.utilities.enums;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
public enum  LitigantType {

    PLAINTIFF("原告"),
    DEFENDANT("被告"),
    AGENT("委托代理人");

    private String repre;

    LitigantType(String repre) {
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

    public static LitigantType getEnum(String str){
        for (LitigantType nowEnum : LitigantType.values()) {
            if (nowEnum.getRepre().equals(str)){
                return nowEnum;
            }
        }
        return null;
    }

}
