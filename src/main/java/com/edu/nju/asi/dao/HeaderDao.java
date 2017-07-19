package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.Header;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * @param caseID 案件名称
     * @return CaseBasic
     */
    Header find(String caseID);

    /**
     * 根据条件查找一个
     * @param codeIDs 案件ID集合
     * @return   Map<String,Header>
     */
    Map<String,Header> findAll(Set<String> codeIDs);

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
