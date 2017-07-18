package com.edu.nju.asi.dao;

import com.edu.nju.asi.InfoCarrier.CaseID;
import com.edu.nju.asi.model.Tailor;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public interface TailorDao {

    /**
     * 添加
     * @param tailor 要插入的对象
     */
    void insert(Tailor tailor);

    /**
     * 根据条件查找一个
     * @param caseID 案号
     * @return CaseBasic
     */
    Tailor find(CaseID caseID);

}
