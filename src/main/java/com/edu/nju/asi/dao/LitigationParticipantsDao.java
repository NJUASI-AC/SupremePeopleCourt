package com.edu.nju.asi.dao;

import com.edu.nju.asi.InfoCarrier.CaseID;
import com.edu.nju.asi.model.JudgementResult;
import com.edu.nju.asi.model.LitigationParticipants;

import java.util.List;

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
     * @param caseID 案号
     * @return CaseBasic
     */
    LitigationParticipants find(CaseID caseID);

    /**
     * 批量插入数据
     * @param litigationParticipants info列表
     * @return CaseBasic
     */
    void insertAll(List<LitigationParticipants> litigationParticipants);

    /**
     * 删除集合
     */
    void dropCollection();


}
