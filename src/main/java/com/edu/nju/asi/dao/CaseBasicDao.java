package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.CaseBasic;

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
     * @param caseNum 案号
     * @return CaseBasic
     */
    CaseBasic find(String caseNum);
}
