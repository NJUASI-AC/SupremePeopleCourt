package com.edu.nju.asi.utilities.enums;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public enum  DocumentType {

    JUDGMENT("判决书"),
    WRITTENVERFICT("裁定书"),
    MEDIATIONAGREEMEN("调解书");

    private String repre;

    DocumentType(String repre) {
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

    public static DocumentType getEnum(String str){
        for (DocumentType nowEnum : DocumentType.values()) {
            if (nowEnum.getRepre().equals(str)){
                return nowEnum;
            }
        }
        return null;
    }
}
