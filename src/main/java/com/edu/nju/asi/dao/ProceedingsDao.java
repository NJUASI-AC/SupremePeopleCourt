package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.Proceedings;

import java.util.List;
import java.util.Map;

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
     * @param caseID 案件名称
     * @return CaseBasic
     */
    Proceedings find(String caseID);

    /**
     * 根据条件查找一个
     * @param actionCode 案件名称
     * @return  Map<String, Proceedings>
     */
    Map<String, Proceedings> findAll(String actionCode);

    /**
     * 批量插入数据
     * @param proceedings info列表
     * @return CaseBasic
     */
    void insertAll(List<Proceedings> proceedings);

    /**
     * 删除集合
     */
    void dropCollection();

}
