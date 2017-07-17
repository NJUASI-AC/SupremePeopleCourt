package com.edu.nju.asi.utilities.enums;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public enum PartiesType {

    NATURAL_PERSON("自然人"),
    LEGAL_PERSON("法人");

    private String repre;

    PartiesType(String repre) {
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

    public static PartiesType getEnum(String str){
        for (PartiesType nowEnum : PartiesType.values()) {
            if (nowEnum.getRepre().equals(str)){
                return nowEnum;
            }
        }
        return null;
    }

}
