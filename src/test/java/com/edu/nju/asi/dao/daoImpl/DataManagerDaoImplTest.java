package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.dao.DataManagerDao;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void getRecommendCase() throws Exception {
        dataManagerDao.getRecommendCase("9018");
    }

    @Test
    public void getCase() throws Exception {
    }

}