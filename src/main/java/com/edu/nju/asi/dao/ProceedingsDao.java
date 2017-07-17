package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.Proceedings;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public interface ProceedingsDao {

    /**
     * 添加
     * @param proceedings 要插入的对象
     */
    void insert(Proceedings proceedings);

    /**
     * 根据条件查找一个
     * @param caseNum 案号
     * @return CaseBasic
     */
    Proceedings find(String caseNum);

}
