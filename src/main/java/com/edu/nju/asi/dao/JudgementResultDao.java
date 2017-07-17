package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.JudgementResult;

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
     * @param caseNum 案号
     * @return CaseBasic
     */
    JudgementResult find(String caseNum);

}
