package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.dao.DataManagerDao;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Byron Dong on 2017/7/19.
 */
public class DataManagerDaoImplTest {


    private DataManagerDao dataManagerDao;

    @Before
    public void setUp() throws Exception {
        dataManagerDao = DaoManager.dataManagerDao;
    }

    @Ignore
    @Test
    public void getRecommendCase() throws Exception {
        dataManagerDao.getRecommendCase("9018");
    }

    @Ignore
    @Test
    public void getCase() throws Exception {
        List<String> caseIDs = new ArrayList<>();
        caseIDs.add("(2001)南民初字第5905号民事判决书（一审民事案件用）");
        dataManagerDao.getCase(caseIDs);
    }

}