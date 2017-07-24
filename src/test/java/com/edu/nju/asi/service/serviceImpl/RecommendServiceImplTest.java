package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.InfoCarrier.*;
import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.model.RefereeAnalysisProcess;
import com.edu.nju.asi.service.RecommendService;
import com.edu.nju.asi.utilities.enums.DocumentName;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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

        ActionCause mainAction = new ActionCause("抢劫罪","抢劫罪","200");

        List<ActionCause> exeAction = new ArrayList<>();
        ActionCause action = new ActionCause("盗窃罪","盗窃罪","201");
        exeAction.add(action);

        List<LegalArticle> legalArticles = new ArrayList<>();
        List<T_Entry> legalTEntry = new ArrayList<>();
        List<K_Entry> entries = new ArrayList<>();
        legalTEntry.add(new T_Entry("第二百六十三条", entries));
        legalTEntry.add(new T_Entry("第二百六十四条", entries));
        legalTEntry.add(new T_Entry("第二十三条", entries));
        legalTEntry.add(new T_Entry("第二十六条", entries));
        legalTEntry.add(new T_Entry("第四十八条", entries));
        legalTEntry.add(new T_Entry("第五十七条", entries));
        legalTEntry.add(new T_Entry("第五十六条", entries));
        legalTEntry.add(new T_Entry("第五十五条", entries));
        legalTEntry.add(new T_Entry("第六十七条", entries));
        legalTEntry.add(new T_Entry("第六十九条", entries));
        legalArticles.add(new LegalArticle("《中华人民共和国刑法》", legalTEntry));


        legalTEntry = new ArrayList<>();
        entries = new ArrayList<>();
        legalTEntry.add(new T_Entry("第二百二十五条", entries));
        legalArticles.add(new LegalArticle("《中华人民共和国刑事诉讼法》", legalTEntry));


        RefereeAnalysisProcess refereeAnalysisProcess = new RefereeAnalysisProcess("(2001)南民初字第5905号民事判决书（一审民事案件用）", "判决", legalArticles);

        String res= "123";
        myCase = new RecommendCase("(2001)南民初字第5905号民事判决书（一审民事案件用）","（2014）粤高法刑四终字第24号"," 广东省东莞市中级人民法院审理广东省东莞市人民检察院指控原审被告人蒙国现、韦呈祥、黄加弟、陆世德、赵永芳、韦勤腾犯抢劫罪、盗窃罪，原审附带民事诉讼原告人肖某某、谢某某、宁某某、肖某、肖某甲、卢某某、周某某、卢某甲、周某甲、杨某某、刘某某、黄某某、肖某乙、刘某甲提起附带民事诉讼一案，于2013年6月15日作出（2012）东中法刑一初字第459号刑事附带民事判决。宣判后，双方当事人均未对附带民事判决提出上诉，该附带民事判决已发生法律效力。原审被告人蒙国现、韦勤腾、黄加弟不服刑事判决，提出上诉。本院依法组成合议庭，经阅卷和讯问上诉人蒙国现、韦勤腾、黄加弟，听取辩护人意见，认为本案事实清楚，决定以不开庭方式进行审理。现已审理终结。", mainAction,exeAction, res, refereeAnalysisProcess, "13", "刑事裁定书");

        try {
            Method method = RecommendServiceImpl.class.getDeclaredMethod("recommend", RecommendCase.class);
            method.setAccessible(true);
            List<RecommendWeight> result = (List<RecommendWeight>) method.invoke(RecommendServiceImpl.class.newInstance(), myCase);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            Logger.getLogger(RecommendServiceImpl.class).error(e.getMessage());
        }
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