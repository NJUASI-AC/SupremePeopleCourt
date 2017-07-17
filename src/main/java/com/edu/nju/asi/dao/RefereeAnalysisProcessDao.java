package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.RefereeAnalysisProcess;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public interface RefereeAnalysisProcessDao {

    /**
     * 添加
     * @param refereeAnalysisProcess 要插入的对象
     */
    void insert(RefereeAnalysisProcess refereeAnalysisProcess);

    /**
     * 根据条件查找一个
     * @param caseNum 案号
     * @return CaseBasic
     */
    RefereeAnalysisProcess find(String caseNum);

}
