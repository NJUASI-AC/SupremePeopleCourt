package com.edu.nju.asi.model.InfoCarrier;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Byron Dong on 2017/7/17.
 *
 * 涉及法律
 */
public class LegalArticle implements Serializable{

    /**
     * 法律名称
     */
    private String lawName;

    /**
     * 条目
     */
    private List<Entry> legalEntry;

    public LegalArticle() {
    }

    public LegalArticle(String lawName, List<Entry> legalEntry) {
        this.lawName = lawName;
        this.legalEntry = legalEntry;
    }

    public String getLawName() {
        return lawName;
    }

    public void setLawName(String lawName) {
        this.lawName = lawName;
    }

    public List<Entry> getLegalEntry() {
        return legalEntry;
    }

    public void setLegalEntry(List<Entry> legalEntry) {
        this.legalEntry = legalEntry;
    }
}
