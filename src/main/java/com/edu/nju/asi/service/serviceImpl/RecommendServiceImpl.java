package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.InfoCarrier.*;
import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.model.Case;
import com.edu.nju.asi.InfoCarrier.RefereeAnalysisProcess;
import com.edu.nju.asi.service.RecommendService;
import com.edu.nju.asi.service.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 61990 on 2017/7/18.
 */
@Service("RecommendService")
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    XMLService xmlService;


    private List<RecommendWeight> recommendWeights = new ArrayList<>();

    //推荐案例的数目
    private int recommendNum = 5;
    //各个比较值的权重
    private int weights[] = {10, 20, 30, 30};

    public RecommendServiceImpl() {
        xmlService = new XMLServiceImpl();
    }


    @Override
    public List<RecommendWeight> recommend(String caseID) {
        File parentFile = new File(System.getProperty("user.dir"));
        for (File nowFile: parentFile.listFiles()) {
            // 转储的文件名与要查看的文件名匹配
            if (nowFile.getName().split("\\.")[0].equals(caseID)) {

                RecommendCase recommendCase = new RecommendCase(xmlService.parseXML(nowFile.getAbsolutePath()));

                // 删除上传的文件
                boolean deleteResult = nowFile.delete();
                assert deleteResult: "上传的文件未被删除";

                return recommend(recommendCase);
            }
        }
        return null;
    }

    @Override
    public List<Case> getWholeMessage(List<RecommendWeight> weights){
        System.out.println("12345678");
        List<String> caseIDs = new ArrayList<>();

        for(RecommendWeight weight : weights) {
            caseIDs.add(weight.getCaseID());
        }
        System.out.println("3333333333333333333333333333");
        return DaoManager.caseDao.getCase(caseIDs);
//        return null;
    }

    private List<RecommendWeight> recommend(RecommendCase newCase) {
        List<RecommendCase> recommendCases = getAllData(newCase);
        System.out.println(recommendCases.size());
        RecommendWeight recommendWeight;
        System.out.println("11111111111111111111111111111111111");
        for (RecommendCase theCase : recommendCases) {
                recommendWeight = calculateWeight(newCase, theCase);
                System.out.println("22222222222222222222");
                addRecommend(recommendWeight);
        }
        System.out.println("12345678912345678");
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
        theWeight += nameSimilar(newCase, theCase, weights[0]);
        //诉讼记录的相似度
        theWeight += recordSimilar(newCase.getRecords(), theCase.getRecords(), weights[1]);
        //审理段的相似度
        theWeight += recordSimilar(newCase.getParagraphThisTrial(), theCase.getParagraphThisTrial(), weights[2]);
        //裁决过程的相似度
        theWeight += refereeAnalysisProcessSimilar(newCase.getRefereeAnalysisProcess(), theCase.getRefereeAnalysisProcess(), weights[3]);

        theWeight = (int) (theWeight * 10) * 1.0 / 10;

        return new RecommendWeight(theCase.getCaseID(),theCase.getCaseNum(), theWeight, theCase.getHandlingCourt(), theCase.getMainActionCause().getActionName(), theCase.getNameOfDocument());
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
                legal1 += lawToString(legals1.get(i).getLegalTEntry());
                laws1.add(legal1);
            }
            for (int j = 0; j < legals2.size(); j++) {
                String legal2 = legals2.get(j).getLawName();
                legal2 += lawToString(legals2.get(j).getLegalTEntry());
                laws2.add(legal2);
            }
            weightOfLegal += listSimilar(laws1, laws2, baseWeight);


        } catch (Exception e) {
            System.out.println("44444444444444");
        }
        return weightOfLegal;
    }

    private String lawToString(List<T_Entry> entries) {
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
    private double nameSimilar(RecommendCase newCase, RecommendCase theCase, double baseWeight) {
        double weightOfName = 0;
        try {
            if (newCase.getCaseNum().equals(theCase.getCaseNum())&&newCase.getHandlingCourt().equals(newCase.getHandlingCourt())) {
                weightOfName += baseWeight;
            }
        } catch (Exception e) {
            System.out.println("66666666666666666666");
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
            if (record1 == null || record2 == null) {
                return weightOfRecord;
            }
            weightOfRecord += cardSimilar(record1, record2) * baseWeight;
        } catch (Exception e) {
            System.out.println("555555555555555555555");
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
            System.out.println("77777777777777777777777");
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
        List<String> codes = new ArrayList<>();
        codes.add(newCase.getMainActionCause().getActionCode());
        return DaoManager.caseDao.getRecommendCase(codes);
    }

    /**
     * 用于筛选是否可以进入top 5
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
