package com.edu.nju.asi.model;

import java.io.Serializable;

/**
 * Created by Byron Dong on 2017/7/17.
 *
 * 涉及法律
 */
public class LegalArticles  implements Serializable{

    /**
     * 法律名称
     */
    private String lawName;

    /**
     * 条目
     */
    private String legalEntry;

    /**
     * 款目
     */
    private String entry;

    public LegalArticles() {
    }

    public LegalArticles(String lawName, String legalEntry, String entry) {
        this.lawName = lawName;
        this.legalEntry = legalEntry;
        this.entry = entry;
    }

    public String getLawName() {
        return lawName;
    }

    public void setLawName(String lawName) {
        this.lawName = lawName;
    }

    public String getLegalEntry() {
        return legalEntry;
    }

    public void setLegalEntry(String legalEntry) {
        this.legalEntry = legalEntry;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
