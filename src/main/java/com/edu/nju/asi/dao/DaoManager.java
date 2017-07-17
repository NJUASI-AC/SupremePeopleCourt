package com.edu.nju.asi.dao;

import com.edu.nju.asi.utilities.ApplicationContextHelper;
import org.springframework.context.ApplicationContext;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public class DaoManager {

    public final static BaseDao baseDao;

    static {
        ApplicationContext applicationContext = ApplicationContextHelper.getApplicationContext();
        baseDao = applicationContext.getBean(BaseDao.class);
    }

}

