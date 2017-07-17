package com.edu.nju.asi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Document
public class Proceedings implements Serializable {

    //案由
    private String actionCause;

    //开庭审理
    private String courtHearing;

    //

}
