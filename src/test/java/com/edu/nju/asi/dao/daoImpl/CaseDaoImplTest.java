package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.InfoCarrier.RecommendCase;
import com.edu.nju.asi.dao.CaseDao;
import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.model.Case;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Byron Dong on 2017/7/24.
 */
public class CaseDaoImplTest {

    private CaseDao caseDao;

    @Before
    public void setUp() throws Exception {
        caseDao = DaoManager.caseDao;
    }

    @Ignore
    @Test
    public void find() throws Exception {
        long start = System.currentTimeMillis();
        Case case_need = caseDao.find("C__Users_Administrator_Desktop_刑事二审案件_刑事二审案件_100000");
        System.out.println(System.currentTimeMillis()-start);
        System.out.println("ok");
    }

    @Ignore
    @Test
    public void findAll() throws Exception {
        long start = System.currentTimeMillis();
        List<RecommendCase> recommendCases =  caseDao.findAll("200");
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(recommendCases.size());
    }

    @Ignore
    @Test
    public void getRecommendCase() throws Exception {
        List<String> codes = new ArrayList<>();
        codes.add("200");
        long start = System.currentTimeMillis();
        caseDao.getRecommendCase(codes);
        System.out.println(System.currentTimeMillis()-start);
    }

    @Ignore
    @Test
    public void getCase() throws Exception {
    }

}