package com.edu.nju.asi.service;

import com.edu.nju.asi.InfoCarrier.Case;
import com.edu.nju.asi.InfoCarrier.RecommendCase;
import com.edu.nju.asi.InfoCarrier.RecommendWeight;

import java.util.List;

/**
 * Created by 61990 on 2017/7/18.
 */
public interface RecommendService {
    /**
     * @param newCase 解析上传的文件的 简易case
     * @return 推荐的案例列表
     */
    List<RecommendWeight> recommend(Case newCase);

    /**
     * @param newCase 解析上传的文件的 case
     * @return 推荐的案例列表
     */
    List<RecommendWeight> recommend(RecommendCase newCase);

    /**
     * @param caseID 需要全部推荐信息的case
     */
    List<Case> getWholeMessage(List<RecommendWeight> weights);

}
