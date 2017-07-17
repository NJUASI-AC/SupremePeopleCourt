package com.edu.nju.asi.model;

import java.io.Serializable;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public class LegalArticles  implements Serializable{

    /**
     *  法律名称
     * */
    private String lawName;

    /**
     *  法条名称
     * */
    private String legalName;

    /**
     *  法条条目
     * */
    private String entry;

    public LegalArticles() {
    }

    public LegalArticles(String lawName, String legalName, String entry) {
        this.lawName = lawName;
        this.legalName = legalName;
        this.entry = entry;
    }

    public String getLawName() {
        return lawName;
    }

    public void setLawName(String lawName) {
        this.lawName = lawName;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
