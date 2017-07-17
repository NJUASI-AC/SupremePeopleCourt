package com.edu.nju.asi.model;

import com.edu.nju.asi.utilities.enums.Gender;
import com.edu.nju.asi.utilities.enums.LitigationStatus;
import com.edu.nju.asi.utilities.enums.PartiesType;
import com.edu.nju.asi.utilities.enums.PartyCategory;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Document
public class LitigationParticipant implements Serializable {

    //诉讼参与人名称
    private String name;

    //诉讼身份
    private LitigationStatus litigationStatus;

    //当事人类别
    private PartyCategory partyCategory;

    //当事人类型
    private PartiesType partiesType;

    //性别
    private Gender gender;

    //民族
    private String nation;

    //出生日期
    private LocalDate birth;

    //文化程度
    private String degree;

    //职务
    private String post;

    //国籍
    private String nationality;

    //是否再婚
    private boolean isRemarriage;

    public LitigationParticipant() {
    }

    public LitigationParticipant(String name, LitigationStatus litigationStatus, PartyCategory partyCategory, PartiesType partiesType, Gender gender, String nation, LocalDate birth, String degree, String post, String nationality, boolean isRemarriage) {
        this.name = name;
        this.litigationStatus = litigationStatus;
        this.partyCategory = partyCategory;
        this.partiesType = partiesType;
        this.gender = gender;
        this.nation = nation;
        this.birth = birth;
        this.degree = degree;
        this.post = post;
        this.nationality = nationality;
        this.isRemarriage = isRemarriage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LitigationStatus getLitigationStatus() {
        return litigationStatus;
    }

    public void setLitigationStatus(LitigationStatus litigationStatus) {
        this.litigationStatus = litigationStatus;
    }

    public PartyCategory getPartyCategory() {
        return partyCategory;
    }

    public void setPartyCategory(PartyCategory partyCategory) {
        this.partyCategory = partyCategory;
    }

    public PartiesType getPartiesType() {
        return partiesType;
    }

    public void setPartiesType(PartiesType partiesType) {
        this.partiesType = partiesType;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isRemarriage() {
        return isRemarriage;
    }

    public void setRemarriage(boolean remarriage) {
        isRemarriage = remarriage;
    }
}
