package com.edu.nju.asi.utilities.enums;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
public enum LitigationType {

    ACCEPT_FEE("受理费");

    private String repre;

    LitigationType(String repre) {
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

}
