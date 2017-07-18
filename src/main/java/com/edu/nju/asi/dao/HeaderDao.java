package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.Header;

import java.util.List;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public interface HeaderDao {

    /**
     * 添加
     * @param header 要插入的对象
     */
    void insert(Header header);

    /**
     * 根据条件查找一个
     * @param caseNum 案号
     * @return CaseBasic
     */
    Header find(String caseNum);

    /**
     * 批量插入数据
     * @param headers info列表
     * @return CaseBasic
     */
    void insertAll(List<Header> headers);

    /**
     * 删除集合
     */
    void dropCollection();

}
