package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.InfoCarrier.Entry;
import com.edu.nju.asi.InfoCarrier.LegalArticle;
import com.edu.nju.asi.InfoCarrier.RecommendCase;
import com.edu.nju.asi.model.RefereeAnalysisProcess;
import com.edu.nju.asi.service.RecommendService;
import com.edu.nju.asi.utilities.enums.DocumentName;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 61990 on 2017/7/18.
 */
public class RecommendServiceImplTest {
    RecommendService recommendService;
    RecommendCase myCase;

    @Before
    public void before() throws Exception {
        recommendService = new RecommendServiceImpl();
    }

    @After
    public void after() throws Exception {
    }

//    @Ignore
    @Test
    public void testRecommend() throws Exception {
        List<String> evidence = new ArrayList<>();
        evidence.add("以上事实有双方当事人当庭陈述及证据材料佐证在案，本院予以确认。");
        List<String> facts = new ArrayList<>();
        String fact = "经审理查明，原告原系山东师范大学硕士研究生，被告原系山东大学硕士研究生。2006年3月，原、被告共同选修组合优化的课程，该课程在被告所在的山东大学上课，故双方相识。此后，被告多次向原告示爱，但均遭拒绝。2006年4月底，被告偷拍原告更衣时的照片，以将照片散播至互联网上及毁容相要挟，迫使原告于2008年2月13日与被告在中华人民共和国驻新加坡共和国大使馆登记结婚，婚后双方未同居生活，无子女及共同财产、债权债务等纠纷。庭审中，原告同意撤回要求被告赔偿精神损害抚慰金10000元的诉讼请求，被告则要求原告再给其一次和好的机会。案经调解未果。";
        facts.add(fact);
        List<LegalArticle> legalArticles = new ArrayList<>();
        List<Entry> legalEntry = new ArrayList<>();
        List<String> entries = new ArrayList<>();
        legalEntry.add(new Entry("十一", entries));
        legalEntry.add(new Entry("十二", entries));
        legalArticles.add(new LegalArticle("中国共和国婚姻法",legalEntry));
        RefereeAnalysisProcess refereeAnalysisProcess = new RefereeAnalysisProcess("（2008）南民初字第5793号", "判决",legalArticles );
        myCase = new RecommendCase("（2008）南民初字第5793号","原告曲晓英与被告黄东撤销婚姻纠纷一案，本院受理后，依法由审判员董巧云独任审判，公开开庭进行了审理。原告曲晓英及其委托代理人杨玉立，被告黄东到庭参加诉讼。本案现已审理终结。", "9019", evidence, facts, refereeAnalysisProcess,"","",DocumentName.CIVIL_JUDGMENT);

//        recommendService.recommend(myCase);

        assert myCase!=null;
    }

}