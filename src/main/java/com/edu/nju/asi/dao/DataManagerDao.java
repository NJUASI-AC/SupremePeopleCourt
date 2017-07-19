package com.edu.nju.asi.dao;

import com.edu.nju.asi.InfoCarrier.Case;
import com.edu.nju.asi.InfoCarrier.RecommendCase;

import java.util.List;

/**
 * Created by Byron Dong on 2017/7/19.
 */
public interface DataManagerDao {

    /**
     *
     * 获取推荐案例信息
     *
     * @param actionCode 案号
     * @return List<RecommendCase>
     */
    List<RecommendCase> getRecommendCase(String actionCode);

    /**
     *
     * 获取推荐案例信息
     *
     * @param caseIDS 案件ID集合
     * @return List<Case> 那件
     * */
    List<Case> getCase(List<String> caseIDS);

}
