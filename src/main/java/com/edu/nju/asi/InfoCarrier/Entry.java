package com.edu.nju.asi.InfoCarrier;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17 0017.
 *
 * 条目
 */
public class Entry implements Serializable{

    public Entry(String name, List<String> entries) {
        this.name = name;
        this.entries = entries;
    }

    /**
     * 条目名称
     */
    private String name;

    /**
     * 款目
     */
    private List<String> entries;

    public Entry() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEntries() {
        return entries;
    }

    public void setEntries(List<String> entries) {
        this.entries = entries;
    }
}
