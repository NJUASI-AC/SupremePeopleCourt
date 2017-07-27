package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Byron Dong on 2017/7/27.
 */
@Document
public class User implements Serializable {

    /**
     * 法官工号
     */
    @Id
    private String workID;

    /**
     * 法官姓名
     */
    private String name;

    /**
     * 隶属法院
     */
    private String subordinationCourt;

    public User() {
    }

    public User(String workID, String name, String subordinationCourt) {
        this.workID = workID;
        this.name = name;
        this.subordinationCourt = subordinationCourt;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubordinationCourt() {
        return subordinationCourt;
    }

    public void setSubordinationCourt(String subordinationCourt) {
        this.subordinationCourt = subordinationCourt;
    }
}
