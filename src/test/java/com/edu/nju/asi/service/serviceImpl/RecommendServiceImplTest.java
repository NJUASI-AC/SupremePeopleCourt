package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.InfoCarrier.Case;
import com.edu.nju.asi.InfoCarrier.Entry;
import com.edu.nju.asi.InfoCarrier.LegalArticle;
import com.edu.nju.asi.InfoCarrier.RecommendCase;
import com.edu.nju.asi.dao.DaoManager;
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

    @Test
    public void testRecommend() throws Exception {
        List<String> evidence = new ArrayList<>();
        evidence.add("上述事实，有当事人当庭陈述、天津市南开区人民政府学府街道办事处照湖里居民委员会书证证明及本院（1999）南民初字第4638号民事判决书佐证在案，本院予以确认。");
        List<String> facts = new ArrayList<>();
        String fact = "经审理查明，原、被告原系夫妻，1999年12月17日业经本院（1999）南民初字第4638号民事判决书判决双方离婚，并同时确定双方之女陈祎来由被告孙莉抚养，原告陈建强每月给付子女抚养费260元。嗣后，双方均能依该判决行使权利并履行义务。最近，由于被告迁移新址，导致原告未能及时探视女儿，引起原告不满。另，被告工作期间确将女儿交由其母照看，其母确曾练过“法轮功”。";
        facts.add(fact);
        List<LegalArticle> legalArticles = new ArrayList<>();
        List<Entry> legalEntry = new ArrayList<>();
        List<String> entries = new ArrayList<>();
        legalEntry.add(new Entry("三十六", entries));
        legalArticles.add(new LegalArticle("中华人民共和国婚姻法", legalEntry));
        RefereeAnalysisProcess refereeAnalysisProcess = new RefereeAnalysisProcess("(2001)南民初字第5905号民事判决书（一审民事案件用）", "判决", legalArticles);
        myCase = new RecommendCase("(2001)南民初字第5905号民事判决书（一审民事案件用）", "原告陈建强与被告孙莉变更抚养关系纠纷一案，本院受理后，依法由审判员兰鸿月独任审判，公开开庭进行了审理。原、被告到庭参加诉讼。本案现已审理终结。", "9026", evidence, facts, refereeAnalysisProcess, "12", "13", DocumentName.CIVIL_JUDGMENT);

        recommendService.recommend(myCase);

        assert myCase != null;
    }

    @Ignore
    @Test
    public void testGetAll() {
        List<String> caseIDs = new ArrayList<>();
        caseIDs.add("(2016)津0225民初1440号民事裁定书（准许或不准许撤诉用）");
        List<Case> caseList = DaoManager.dataManagerDao.getCase(caseIDs);

        assert caseList != null;
    }

}