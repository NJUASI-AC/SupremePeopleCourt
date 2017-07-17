package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.FullText;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public interface FullTextDao {

    /**
     * 添加
     * @param fullText 要插入的对象
     */
    void insert(FullText fullText);

    /**
     * 根据条件查找一个
     * @param caseNum 案号
     * @return CaseBasic
     */
    FullText find(String caseNum);

}