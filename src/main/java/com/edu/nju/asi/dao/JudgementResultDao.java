package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.JudgementResult;

import java.util.List;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public interface JudgementResultDao {

    /**
     * 添加
     * @param judgementResult 要插入的对象
     */
    void insert(JudgementResult judgementResult);

    /**
     * 根据条件查找一个
     * @param caseID 案件名称
     * @return CaseBasic
     */
    JudgementResult find(String caseID);

    /**
     * 批量插入数据
     * @param judgementResults info列表
     * @return CaseBasic
     */
    void insertAll(List<JudgementResult> judgementResults);

    /**
     * 删除集合
     */
    void dropCollection();

}
