package com.edu.nju.asi.dao;

import com.edu.nju.asi.InfoCarrier.RecommendCase;
import com.edu.nju.asi.model.Case;

import java.util.List;
import java.util.Map;

/**
 * Created by Byron Dong on 2017/7/24.
 */
public interface CaseDao {

    /**
     * 添加
     *
     * @param fullText 要插入的对象
     */
    void insert(Case case_need);

    /**
     * 根据条件查找一个
     *
     * @param caseID 案件名称
     * @return CaseBasic
     */
    Case find(String caseID);

    /**
     * 批量插入数据
     *
     * @param cases info列表
     * @return CaseBasic
     */
    void insertAll(List<Case> cases);

    /**
     * 删除集合
     */
    void dropCollection();

    /**
     * 根据条件查找一个
     *
     * @param actionCode 案件名称
     * @return Map<String, Header>
     */
   List<RecommendCase> findAll(String actionCode);

    /**
     * 获取推荐案例信息
     *
     * @param actionCodes 案号
     * @return List<RecommendCase>
     */
    List<RecommendCase> getRecommendCase(List<String> actionCodes);

    /**
     * 获取推荐案例信息
     *
     * @param caseIDS 案件ID集合
     * @return List<Case> 那件
     */
    List<Case> getCase(List<String> caseIDS);
}
