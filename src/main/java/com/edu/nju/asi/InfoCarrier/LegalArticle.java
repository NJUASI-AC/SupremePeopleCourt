package com.edu.nju.asi.InfoCarrier;

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
    private List<T_Entry> legalTEntry;

    public LegalArticle() {
    }

    public LegalArticle(String lawName, List<T_Entry> legalTEntry) {
        this.lawName = lawName;
        this.legalTEntry = legalTEntry;
    }

    public String getLawName() {
        return lawName;
    }

    public void setLawName(String lawName) {
        this.lawName = lawName;
    }

    public List<T_Entry> getLegalTEntry() {
        return legalTEntry;
    }

    public void setLegalTEntry(List<T_Entry> legalTEntry) {
        this.legalTEntry = legalTEntry;
    }
}
