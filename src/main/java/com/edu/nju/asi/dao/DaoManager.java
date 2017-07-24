package com.edu.nju.asi.dao;

import com.edu.nju.asi.utilities.ApplicationContextHelper;
import org.springframework.context.ApplicationContext;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public class DaoManager {

    /**
     *  案件Dao
     */
    public final static CaseDao caseDao;

    private DaoManager() {
    }

    static {
        ApplicationContext applicationContext = ApplicationContextHelper.getApplicationContext();
        caseDao = applicationContext.getBean(CaseDao.class);
    }

}

