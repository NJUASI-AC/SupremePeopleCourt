package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.RefereeAnalysisProcess;

import java.util.List;

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

    /**
     * 批量插入数据
     * @param refereeAnalysisProcesses info列表
     * @return CaseBasic
     */
    void insertAll(List<RefereeAnalysisProcess> refereeAnalysisProcesses);

    /**
     * 删除集合
     */
    void dropCollection();

}
