package com.edu.nju.asi.InfoCarrier;

import com.edu.nju.asi.utilities.enums.Gender;
import com.edu.nju.asi.utilities.enums.LitigantType;
import com.edu.nju.asi.utilities.enums.PartiesType;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public class LitigationParticipant implements Serializable {

    /**
     * 诉讼参与人名称
     */
    private String name;

    /**
     * 当事人类别 （原告、被告）
     */
    private LitigantType litigantType;

    /**
     * 当事人类型 (应诉方、起诉方)
     */
    private String partiesType;

    /**
     * 性别
     */
    private Gender gender;

    /**
     * 民族
     */
    private String nation;

    /**
     * 出生日期
     */
    private LocalDate birth;

    /**
     * 文化程度
     */
    private String degree;

    /**
     * 职务
     */
    private String post;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 到庭情况
     */
    private boolean hasAppearInCourt;

    /**
     * 是否再婚
     */
    private boolean isRemarriage;

    public LitigationParticipant() {
    }

    public LitigantType getLitigantType() {
        return litigantType;
    }

    public void setLitigantType(LitigantType litigantType) {
        this.litigantType = litigantType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        public String getPartiesType() {
        return partiesType;
    }

    public void setPartiesType(String partiesType) {
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

    public boolean isHasAppearInCourt() {
        return hasAppearInCourt;
    }

    public void setHasAppearInCourt(boolean hasAppearInCourt) {
        this.hasAppearInCourt = hasAppearInCourt;
    }

    public boolean isRemarriage() {
        return isRemarriage;
    }

    public void setRemarriage(boolean remarriage) {
        isRemarriage = remarriage;
    }
}
