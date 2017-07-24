package com.edu.nju.asi.InfoCarrier;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
public class FullText implements Serializable{

    /**
     * 全文
     */
    private String text;

    public FullText() {
    }

    public FullText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
