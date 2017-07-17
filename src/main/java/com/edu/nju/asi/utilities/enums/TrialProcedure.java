package com.edu.nju.asi.utilities.enums;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public enum TrialProcedure {

    ACTION_OF_FIRST_INSTANCE("一审案件"),
    SECOND_INSTANCE_LITIGATION("二审案件"),
    RETRIAL_LITIGATION("再审案件");

    private String repre;

    TrialProcedure(String repre) {
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

    public static TrialProcedure getEnum(String str){
        for (TrialProcedure nowEnum : TrialProcedure.values()) {
            if (nowEnum.getRepre().equals(str)){
                return nowEnum;
            }
        }
        return null;
    }

}
