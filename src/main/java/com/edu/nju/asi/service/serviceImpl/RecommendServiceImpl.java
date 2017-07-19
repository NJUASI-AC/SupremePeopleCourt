package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.InfoCarrier.*;
import com.edu.nju.asi.dao.ProceedingsDao;
import com.edu.nju.asi.dao.daoImpl.ProceedingsDaoImpl;
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
    private ProceedingsDao proceedingsDao = new ProceedingsDaoImpl();

    //推荐案例的数目
    private int recommendNum = 5;
    //各个比较值的权重
    private int weights[] = {10, 15, 30, 10, 20};

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
        return new RecommendWeight(theCase.getCaseID(), theWeight,theCase.getHandlingCourt(),theCase.getActionCause(),theCase.getNameOfDocument());
    }
    /**
     * 用于计算两个案件处理过程之间的相似度
     *
     * @return 计算出来的权重
     */
    private double refereeAnalysisProcessSimilar(RefereeAnalysisProcess refereeAnalysisProcess1, RefereeAnalysisProcess refereeAnalysisProcess2, int baseWeight) {
        double weightOfLegal = 0;
        try {

            if (refereeAnalysisProcess1 == null || refereeAnalysisProcess1 == null) {
                weightOfLegal += baseWeight * 0.1;
            } else {
                List<LegalArticle> legals1=refereeAnalysisProcess1.getLegalArticles();
                List<LegalArticle> legals2=refereeAnalysisProcess2.getLegalArticles();
                if  (legals1 == null || legals2 == null) {
                    weightOfLegal += baseWeight * 0.1;
                } else {
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
                }
            }
        } catch (Exception e) {
            weightOfLegal += baseWeight * 0.1;
        }
        return weightOfLegal;
    }

    private String lawToString(List<Entry> entries ){
        String str="";
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
            weightOfName += baseWeight * 0.7 * 0.3;  //如果解析出错则分配一点权重
        }

        try {
            String str1 = name1.split("（")[1].split("）")[0];
            String str2 = name1.split("（")[1].split("）")[0];
            cardSimilar(str1, str2);
            weightOfName += baseWeight * 0.3 * cardSimilar(str1, str2);
        } catch (Exception e) {
            weightOfName += baseWeight * 0.3 * 0.1;
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
            weightOfRecord = 0 + baseWeight * 0.1;
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
                weightOfList += baseWeight * 0.1;  //如果不存在就给一点点权重
            } else {
                double weight = 0;
                for (int i = 0; i < list1.size(); i++) {
                    for (int j = 0; j < list2.size(); j++) {
                        weight = cardSimilar(list1.get(i),list2.get(j));
                        if (weight>weightOfList){
                            weightOfList=weight;
                        }
                    }
                }
            }
        } catch (Exception e) {
            weightOfList += baseWeight * 0.1;
        }
        return weightOfList;
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
        //proceedingsDao.findAll(newCase.getActionCode());
        return getDataStub();
    }

    /**
     * 用于筛选是否可以进入topFive
     */
    private void addRecommend(RecommendWeight weight) {
        //之前未加入任何
        if (recommendWeights.size() == 0) {
            recommendWeights.add(weight);
        }
        //已经存在，进行比较，按权重排序插入
        else {
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

    /**
     * 桩 用于模拟去数据库中所有的用于比较的数据
     *
     * @return 所以的数据
     */
    private List<RecommendCase> getDataStub() {
        List<RecommendCase> recommendCases = new ArrayList<>();

        List<String> evidence;
        List<String> facts;
        String fact;
        List<LegalArticle> legalArticles;
        List<Entry> legalEntry;
        List<String> entries;
        RefereeAnalysisProcess refereeAnalysisProcess;
        String caseID;
        String actionCause;
        String record;

        caseID = "（2010）南民初字第4871号";
        evidence = new ArrayList<>();
        evidence.add("");
        facts = new ArrayList<>();
        legalArticles = new ArrayList<>();
        legalEntry = new ArrayList<>();
        entries = new ArrayList<>();
        legalEntry.add(new Entry("九十二", entries));
        legalArticles.add(new LegalArticle("中华人民共和国民事诉讼法", legalEntry));
        refereeAnalysisProcess = new RefereeAnalysisProcess(caseID, "裁决", legalArticles);
        actionCause = "9019";
        record = "原告刘二庆，男，1951年1月12日出生，汉族，住天津市南开区向阳路云阳北里1-1-212号。身份证号120106195101126512法定代理人刘翠正，女，1954年2月3日出生，汉族，住天津市红桥区芥园大堤一条胡同38号。身份证号120106195402036545被告孙振华，女，1961年1月8日出生，汉族，住天津市南开区怡园里3-2-103号。身份证号120104196101082929本院在审理原告刘二庆与被告孙振华撤销婚姻纠纷一案中，原告刘二庆于2010年6月28日向本院提出财产保全申请，要求对原告刘二庆名下坐落于天津市南开区芥园西道怡园里3-2-103号房屋实施财产保全，案外人刘庆三以其名下坐落于天津市南开区芥园西道怡园里3-5-201号房屋及担保金100000元作为担保。";
        recommendCases.add(new RecommendCase(caseID, record, actionCause, evidence, facts, refereeAnalysisProcess,"2222","11111",DocumentName.CIVIL_JUDGMENT));

        caseID = "（2010）南民初字第4871-1号";
        evidence = new ArrayList<>();
        evidence.add("");
        facts = new ArrayList<>();
        legalArticles = new ArrayList<>();
        legalEntry = new ArrayList<>();
        entries = new ArrayList<>();
        entries.add("第一款");
        legalEntry.add(new Entry("一百三十一", entries));
        legalArticles.add(new LegalArticle("中华人民共和国民事诉讼法", legalEntry));
        refereeAnalysisProcess = new RefereeAnalysisProcess(caseID, "裁决", legalArticles);
        actionCause = "9019";
        record = "原告刘二庆，男，1951年1月12日出生，汉族，住天津市南开区向阳路云阳北里1-1-212号。身份证号120106195101126512法定代理人刘翠正，女，1954年2月3日出生，汉族，住天津市红桥区芥园大堤一条胡同38号。身份证号120106195402036545被告孙振华，女，1961年1月8日出生，汉族，住天津市南开区怡园里3-2-103号。身份证号120104196101082929本院在审理原告刘二庆与被告孙振华撤销婚姻纠纷一案中，原告刘二庆于2010年7月20日向本院提出撤诉申请。";
        recommendCases.add(new RecommendCase(caseID, record, actionCause, evidence, facts, refereeAnalysisProcess,"1111123","22222",DocumentName.CIVIL_JUDGMENT));

        caseID = "(2003)东民初字第1179号";
        evidence = new ArrayList<>();
        evidence.add("");
        facts = new ArrayList<>();
        fact = "";
        facts.add(fact);
        legalArticles = new ArrayList<>();
        legalEntry = new ArrayList<>();
        entries = new ArrayList<>();
        legalEntry.add(new Entry("", entries));
        legalArticles.add(new LegalArticle("", legalEntry));
        refereeAnalysisProcess = new RefereeAnalysisProcess(caseID, "判决", legalArticles);
        actionCause = "9018";
        record = "冯艳英与郝伟东婚姻无效纠纷一案，本院受理后，依法组成合议庭（或依法由审判员独任审判），开庭进行了审理。原告冯艳英，，被告郝伟东，到庭参加诉讼。本案现以审理终结。";
        recommendCases.add(new RecommendCase(caseID, record, actionCause, evidence, facts, refereeAnalysisProcess,"132","2313",DocumentName.CIVIL_JUDGMENT));

        caseID = "(2016)津0115民初6408号";
        evidence = new ArrayList<>();
        evidence.add("");
        facts = new ArrayList<>();
        fact = "本院经审理认定事实如下：被告郑宝利于2015年2月6日与案外人张会娥登记结婚，双方均系再婚，婚后未生育子女。2016年1月14日被告郑宝利起诉要求与张会娥离婚，本院于2016年2月28日作出（2016）津0115民初973号民事判决书，准许郑宝利与张会娥离婚。张会娥不服上述判决书，向天津市第一中级人民法院提起上诉。2016年3月21日被告郑宝利与原告郝淑舫登记结婚。2016年7月6日天津市第一中级人民裁定：撤销（2016）津0115民初973号民事判决书，发还宝坻区人民法院重审。";
        facts.add(fact);
        legalArticles = new ArrayList<>();
        legalEntry = new ArrayList<>();
        entries = new ArrayList<>();
        entries.add("第一项");
        legalEntry.add(new Entry("十", entries));
        legalArticles.add(new LegalArticle("中华人民共和国婚姻法", legalEntry));
        refereeAnalysisProcess = new RefereeAnalysisProcess(caseID, "判决", legalArticles);
        actionCause = "9018";
        record = "原告郝淑舫与被告郑宝利婚姻无效纠纷一案，本院于2016年7月25日立案后，依法适用简易程序公开开庭进行了审理。原告与被告均到庭参加了诉讼。本案现已审理终结。";
        recommendCases.add(new RecommendCase(caseID, record, actionCause, evidence, facts, refereeAnalysisProcess,"123","312",DocumentName.CIVIL_JUDGMENT));

        caseID = "（2007）蓟民初字第2267号";
        evidence = new ArrayList<>();
        evidence.add("");
        facts = new ArrayList<>();
        fact = "经审理查明，原、被告双方经人介绍于2006年9月份相识。2007年2月3日，双方在未领取结婚证书情况下，依当地风俗举行了婚礼，即以夫妻名义共同生活。原、被告在未举行婚礼前，经介绍人之手，原告分二次给付被告彩礼款11200元。双方同居后，原告又交给被告购手机款1500元。后原告怀疑被告与另一男人有作风问题，即将该男人殴打。2007年3月份，被告离开原告家中出走，至今住址不详。上述事实，有原告陈述记录在案。";
        facts.add(fact);
        legalArticles = new ArrayList<>();
        legalEntry = new ArrayList<>();
        entries = new ArrayList<>();
        legalEntry.add(new Entry("一百三十", entries));
        legalArticles.add(new LegalArticle("中华人民共和国民事诉讼法", legalEntry));
        legalArticles.add(new LegalArticle("中华人民共和国婚姻法", legalEntry));
        refereeAnalysisProcess = new RefereeAnalysisProcess(caseID, "判决", legalArticles);
        actionCause = "9018";
        record = "原告孙立超与被告张丹丹婚约财产纠纷一案，本院于2007年4月24日立案受理后，依法组成合议庭，不公开开庭进行了审理，原告孙立超到庭参加诉讼。被告张丹丹经公告送达起诉状副本、应诉通知书、举证通知书和开庭传票，无正当理由拒绝到庭参加诉讼。本案现已审理终结。";
        recommendCases.add(new RecommendCase(caseID, record, actionCause, evidence, facts, refereeAnalysisProcess,"11111","222222",DocumentName.CIVIL_JUDGMENT));

        return recommendCases;
    }

}
