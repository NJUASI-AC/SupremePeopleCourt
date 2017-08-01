package com.edu.nju.asi.infoCarrier;

import java.util.List;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class K_Entry {

    /**
     * 款目名称
     */
    String name;

    /**
     * 项目
     */
    List<String> x_entries;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getX_entries() {
        return x_entries;
    }

    public void setX_entries(List<String> x_entries) {
        this.x_entries = x_entries;
    }
}
