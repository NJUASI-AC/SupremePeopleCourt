package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.InfoCarrier.*;
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
    private int recommendNum = 5;

    public RecommendServiceImpl() {
    }

    /**
     * @param newCase 解析上传的文件的case
     * @return 推荐的案例列表
     */
    @Override
    public List<RecommendWeight> recommend(RecommendCase newCase) {
        List<RecommendCase> recommendCases = getDates();
        RecommendWeight weight;
        for (RecommendCase myCase : recommendCases) {
            weight = calculateWeight(newCase, myCase);
            addRecommend(weight);
        }
        return recommendWeights;
    }

    /**
     * 用于计算两个案件之间的相似度
     *
     * @return 计算出来的权重
     */
    private RecommendWeight calculateWeight(RecommendCase newCase, RecommendCase myCase) {
        return null;
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
                }
            }
            if (recommendWeights.size() > 5) {
                recommendWeights = recommendWeights.subList(0, 5);
            }
        }
    }

    /**
     * 桩 用于模拟去数据库中所有的用于比较的数据
     *
     * @return 所以的数据
     */
    private List<RecommendCase> getDates() {
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
        actionCause = "撤销婚姻纠纷";
        record = "原告刘二庆，男，1951年1月12日出生，汉族，住天津市南开区向阳路云阳北里1-1-212号。身份证号120106195101126512法定代理人刘翠正，女，1954年2月3日出生，汉族，住天津市红桥区芥园大堤一条胡同38号。身份证号120106195402036545被告孙振华，女，1961年1月8日出生，汉族，住天津市南开区怡园里3-2-103号。身份证号120104196101082929本院在审理原告刘二庆与被告孙振华撤销婚姻纠纷一案中，原告刘二庆于2010年6月28日向本院提出财产保全申请，要求对原告刘二庆名下坐落于天津市南开区芥园西道怡园里3-2-103号房屋实施财产保全，案外人刘庆三以其名下坐落于天津市南开区芥园西道怡园里3-5-201号房屋及担保金100000元作为担保。";
        recommendCases.add(new RecommendCase(caseID, record, actionCause, evidence, facts, refereeAnalysisProcess));

        caseID ="（2010）南民初字第4871-1号";
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
        actionCause = "撤销婚姻纠纷";
        record = "原告刘二庆，男，1951年1月12日出生，汉族，住天津市南开区向阳路云阳北里1-1-212号。身份证号120106195101126512法定代理人刘翠正，女，1954年2月3日出生，汉族，住天津市红桥区芥园大堤一条胡同38号。身份证号120106195402036545被告孙振华，女，1961年1月8日出生，汉族，住天津市南开区怡园里3-2-103号。身份证号120104196101082929本院在审理原告刘二庆与被告孙振华撤销婚姻纠纷一案中，原告刘二庆于2010年7月20日向本院提出撤诉申请。";
        recommendCases.add(new RecommendCase(caseID, record, actionCause, evidence, facts, refereeAnalysisProcess));

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
        actionCause = "婚姻无效纠纷";
        record = "冯艳英与郝伟东婚姻无效纠纷一案，本院受理后，依法组成合议庭（或依法由审判员独任审判），开庭进行了审理。原告冯艳英，，被告郝伟东，到庭参加诉讼。本案现以审理终结。";
        recommendCases.add(new RecommendCase(caseID, record, actionCause, evidence, facts, refereeAnalysisProcess));

        caseID ="(2016)津0115民初6408号";
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
        actionCause = "婚姻无效纠纷";
        record = "原告郝淑舫与被告郑宝利婚姻无效纠纷一案，本院于2016年7月25日立案后，依法适用简易程序公开开庭进行了审理。原告与被告均到庭参加了诉讼。本案现已审理终结。";
        recommendCases.add(new RecommendCase(caseID, record, actionCause, evidence, facts, refereeAnalysisProcess));

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
        actionCause = "婚姻无效纠纷";
        record = "原告孙立超与被告张丹丹婚约财产纠纷一案，本院于2007年4月24日立案受理后，依法组成合议庭，不公开开庭进行了审理，原告孙立超到庭参加诉讼。被告张丹丹经公告送达起诉状副本、应诉通知书、举证通知书和开庭传票，无正当理由拒绝到庭参加诉讼。本案现已审理终结。";
        recommendCases.add(new RecommendCase(caseID,  record, actionCause, evidence, facts, refereeAnalysisProcess));

        return recommendCases;
    }

}
