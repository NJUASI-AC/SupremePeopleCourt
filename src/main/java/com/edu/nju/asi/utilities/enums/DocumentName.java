package com.edu.nju.asi.utilities.enums;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public enum DocumentName {

    CIVIL_JUDGMENT("民事判决书"),
    CIVIL_WRITTENVERFICT("民事裁定书"),
    CIVIL_MEDIATIONAGREEMEN("民事调解书");

    private String repre;

    DocumentName(String repre) {
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

    public static DocumentName getEnum(String str){
        for (DocumentName nowEnum : DocumentName.values()) {
            if (nowEnum.getRepre().equals(str)){
                return nowEnum;
            }
        }
        return null;
    }
}
