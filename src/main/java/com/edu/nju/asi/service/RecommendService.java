package com.edu.nju.asi.service;

import com.edu.nju.asi.model.Case;
import com.edu.nju.asi.infoCarrier.RecommendWeight;

import java.util.List;

/**
 * Created by 61990 on 2017/7/18.
 */
public interface RecommendService {
    /**
     * @param caseID 要寻求推荐案例的原案例ID
     * @return 推荐的案例列表
     */
    List<RecommendWeight> recommend(String caseID);

    /**
     * @param caseID 要寻求推荐案例的原案例ID
     * @return 推荐的案例列表
     */
    List<RecommendWeight> recommend(Case theCase);

    /**
     * @param weights 需要全部推荐信息的case
     */
    List<Case> getWholeMessage(List<RecommendWeight> weights);

}
