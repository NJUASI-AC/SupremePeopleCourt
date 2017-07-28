package com.edu.nju.asi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
     * 密码
     * */
    private String password;

    /**
     * 隶属法院
     */
    private String subordinationCourt;

    /**
     * 上传caseID列表
     * */
    private List<String> caseIDs = new ArrayList<>();

    public User() {
    }

    public User(String workID, String name, String password, String subordinationCourt) {
        this.workID = workID;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<String> getCaseIDs() {
        return caseIDs;
    }

    public void setCaseIDs(List<String> caseIDs) {
        this.caseIDs = caseIDs;
    }
}
