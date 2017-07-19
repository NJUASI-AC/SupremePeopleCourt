package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.CaseBasic;

import java.util.List;
import java.util.Set;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public interface CaseBasicDao {

    /**
     * 添加
     * @param caseBasic 要插入的对象
     */
    void insert(CaseBasic caseBasic);

    /**
     * 根据条件查找一个
     * @param caseID 案件ID
     * @return CaseBasic
     */
    CaseBasic find(String caseID);

    /**
     * 根据条件查找一个
     * @param codeIDs 案件ID集合
     * @return  List<CaseBasic>
     */
    List<CaseBasic> findAll(Set<String> codeIDs);

    /**
     * 批量插入数据
     * @param caseBasics info列表
     * @return CaseBasic
     */
    void insertAll(List<CaseBasic> caseBasics);

    /**
     * 删除集合
     */
    void dropCollection();
}
