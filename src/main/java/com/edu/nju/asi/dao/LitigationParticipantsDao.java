package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.LitigationParticipants;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public interface LitigationParticipantsDao {

    /**
     * 添加
     * @param litigationParticipants 要插入的对象
     */
    void insert(LitigationParticipants litigationParticipants);

    /**
     * 根据条件查找一个
     * @param caseNum 案号
     * @return CaseBasic
     */
    LitigationParticipants find(String caseNum);


}
