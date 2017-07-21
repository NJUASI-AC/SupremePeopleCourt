package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.InfoCarrier.*;
import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.model.RefereeAnalysisProcess;
import com.edu.nju.asi.service.RecommendService;
import com.edu.nju.asi.utilities.enums.DocumentName;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 61990 on 2017/7/18.
 */
@Service("RecommendService")
public class RecommendServiceImpl implements RecommendService {

    private List<RecommendWeight> recommendWeights = new ArrayList<>();

    //推荐案例的数目
    private int recommendNum = 5;
    //各个比较值的权重
    private int weights[] = {10, 20, 30, 10, 30};

    public RecommendServiceImpl() {
    }

    /**
     * @param newCase 解析上传的文件的case
     * @return 推荐的案例列表
     */
    @Override
    public List<RecommendWeight> recommend(Case newCase) {
        RecommendCase myCase = new RecommendCase(newCase);
        return recommend(myCase);
    }

    @Override
    public List<Case> getWholeMessage(List<RecommendWeight> weights){
        List<String> caseIDs = new ArrayList<>();
        for(RecommendWeight weight : weights) {
            caseIDs.add(weight.getCaseID());
        }
        return DaoManager.dataManagerDao.getCase(caseIDs);
    }

    @Override
    public List<RecommendWeight> recommend(RecommendCase newCase) {
        List<RecommendCase> recommendCases = getAllData(newCase);
        RecommendWeight recommendWeight;
        for (RecommendCase theCase : recommendCases) {
                recommendWeight = calculateWeight(newCase, theCase);
                addRecommend(recommendWeight);
        }
        return recommendWeights;
    }

    /**
     * 用于计算两个案件之间的相似度
     *
     * @return 计算出来的权重
     */
    private RecommendWeight calculateWeight(RecommendCase newCase, RecommendCase theCase) {
        double theWeight = 0;
        //文件名的相似度
        theWeight += nameSimilar(newCase.getCaseID(), theCase.getCaseID(), weights[0]);
        //诉讼记录的相似度
        theWeight += recordSimilar(newCase.getRecords(), theCase.getRecords(), weights[1]);
        //证据段的相似度
        theWeight += listSimilar(newCase.getEvidence(), theCase.getEvidence(), weights[2]);
        //查明事实段的相似度
        theWeight += listSimilar(newCase.getFact(), theCase.getFact(), weights[3]);
        //裁决过程的相似度
        theWeight += refereeAnalysisProcessSimilar(newCase.getRefereeAnalysisProcess(), theCase.getRefereeAnalysisProcess(), weights[4]);

        theWeight = (int) (theWeight * 10) * 1.0 / 10;

        return new RecommendWeight(theCase.getCaseID(), theWeight, theCase.getHandlingCourt(), theCase.getActionCause(), theCase.getNameOfDocument());
    }

    /**
     * 用于计算两个案件处理过程之间的相似度
     *
     * @return 计算出来的权重
     */
    private double refereeAnalysisProcessSimilar(RefereeAnalysisProcess refereeAnalysisProcess1, RefereeAnalysisProcess refereeAnalysisProcess2, int baseWeight) {
        double weightOfLegal = 0;
        try {
            if (refereeAnalysisProcess1 == null || refereeAnalysisProcess2 == null) {
                return weightOfLegal;
            }
            List<LegalArticle> legals1 = refereeAnalysisProcess1.getLegalArticles();
            List<LegalArticle> legals2 = refereeAnalysisProcess2.getLegalArticles();
            if (legals1 == null || legals2 == null) {
                return weightOfLegal;
            }
            List<String> laws1 = new ArrayList<>();
            List<String> laws2 = new ArrayList<>();
            for (int i = 0; i < legals1.size(); i++) {
                String legal1 = legals1.get(i).getLawName();
                legal1 += lawToString(legals1.get(i).getLegalEntry());
                laws1.add(legal1);
            }
            for (int j = 0; j < legals2.size(); j++) {
                String legal2 = legals2.get(j).getLawName();
                legal2 += lawToString(legals2.get(j).getLegalEntry());
                laws2.add(legal2);
            }
            weightOfLegal += listSimilar(laws1, laws2, baseWeight);


        } catch (Exception e) {

        }
        return weightOfLegal;
    }

    private String lawToString(List<Entry> entries) {
        String str = "";
        if (entries != null) {
            for (int j = 0; j < entries.size(); j++) {
                str += entries.get(j).getName();
            }
        }
        return str;
    }


    /**
     * 用于计算文件名的相似度 系数
     *
     * @return 计算出来的权重
     */
    private double nameSimilar(String name1, String name2, double baseWeight) {
        double weightOfName = 0;
        try {
            String str1 = name1.split("号")[0];
            String str2 = name2.split("号")[0];
            if (str1.equals(str2)) {
                weightOfName += baseWeight * 0.7;
            }
        } catch (Exception e) {

        }

        try {
            String str1 = name1.split("（")[1].split("）")[0];
            String str2 = name1.split("（")[1].split("）")[0];
            cardSimilar(str1, str2);
            weightOfName += baseWeight * 0.3 * cardSimilar(str1, str2);
        } catch (Exception e) {

        }
        return weightOfName;
    }

    /**
     * 用于计算诉讼记录的相似度 系数
     *
     * @return 计算出来的权重
     */
    private double recordSimilar(String record1, String record2, double baseWeight) {
        double weightOfRecord = 0;
        try {
            weightOfRecord += cardSimilar(record1, record2) * baseWeight;
        } catch (Exception e) {

        }
        return weightOfRecord;
    }

    /**
     * 用于计算list的相似度 系数
     *
     * @return 计算出来的权重
     */
    private double listSimilar(List<String> list1, List<String> list2, double baseWeight) {
        double weightOfList = 0;
        try {
            if (list1 == null || list2 == null) {
                return weightOfList;
            }
            double weight;
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list2.size(); j++) {
                    weight = cardSimilar(list1.get(i), list2.get(j));
                    if (weight > weightOfList) {
                        weightOfList = weight;
                    }
                }

            }
        } catch (Exception e) {

        }
        return weightOfList * baseWeight;
    }

    /**
     * 用于计算两个字符串 jaccard的相似度 系数
     * 比较相同的字符占总字符的个数
     *
     * @return 计算出来的权重
     */
    private double cardSimilar(String str1, String str2) {
        int similar = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    similar++;
                    break;
                }
            }
        }
        return 1.0 * similar / (str1.length() + str2.length() - similar);
    }

    /**
     * 从数据库里面获得所有需要的数据
     *
     * @return 计算出来的权重
     */
    private List<RecommendCase> getAllData(RecommendCase newCase) {
        return DaoManager.dataManagerDao.getRecommendCase(newCase.getActionCode());
    }

    /**
     * 用于筛选是否可以进入topFive
     */
    private void addRecommend(RecommendWeight weight) {
        if (recommendWeights.size() == 0) {
            recommendWeights.add(weight);
        } else {
            for (int i = 0; i < recommendWeights.size(); i++) {
                if (recommendWeights.get(i).getWeight() < weight.getWeight()) {
                    recommendWeights.add(i, weight);
                    break;
                }
            }
            if (recommendWeights.get(recommendWeights.size() - 1).getWeight() >= weight.getWeight()) {
                recommendWeights.add(weight);
            }
            if (recommendWeights.size() > recommendNum) {
                recommendWeights = recommendWeights.subList(0, recommendNum);
            }
        }
    }

}
