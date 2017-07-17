package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/17 0017.
 *
 * 文尾实体类
 */
@Document
public class Tailor implements Serializable{

    @Id
    private String caseID;

    /**
     * 审判员
     */
    private Map<String, String> judges = new HashMap<>();

    /**
     * 裁决时间
     */
    private String judgeTime;
}
