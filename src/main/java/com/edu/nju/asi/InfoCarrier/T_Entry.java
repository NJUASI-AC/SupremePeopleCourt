package com.edu.nju.asi.InfoCarrier;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17 0017.
 *
 * 条目
 */
public class T_Entry implements Serializable{

    /**
     * 条目名称
     */
    private String name;

    /**
     * 款目
     */
    private List<K_Entry> k_entries;

    /**
     * 实体必须要求空构造器
     */
    public T_Entry() {
    }

    public T_Entry(String name, List<K_Entry> k_entries) {
        this.name = name;
        this.k_entries = k_entries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<K_Entry> getK_entries() {
        return k_entries;
    }

    public void setK_entries(List<K_Entry> k_entries) {
        this.k_entries = k_entries;
    }
}
