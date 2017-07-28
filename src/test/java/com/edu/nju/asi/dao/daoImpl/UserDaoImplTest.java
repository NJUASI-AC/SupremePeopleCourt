package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.CaseDao;
import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.dao.UserDao;
import com.edu.nju.asi.model.Case;
import com.edu.nju.asi.model.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Byron Dong on 2017/7/28.
 */
public class UserDaoImplTest {

    private UserDao userDao;

    private CaseDao caseDao;

    @Before
    public void setUp() throws Exception {
        userDao = DaoManager.userDao;
        caseDao = DaoManager.caseDao;
    }

    @Ignore
    @Test
    public void insert() throws Exception {
        userDao.insert(new User("151250032","ByronDong","qwertyuiop","南京大学"));
    }

    @Ignore
    @Test
    public void update() throws Exception {
        userDao.update((new User("151250032","ByronDong","qwertyuiop","南京大学软件学院")));
    }

    @Ignore
    @Test
    public void uploadCase() throws Exception {
        Case case_1 = caseDao.find("C__Users_Administrator_Desktop_刑事二审案件_刑事二审案件_100000");
        Case case_2 = caseDao.find("C__Users_Administrator_Desktop_刑事二审案件_刑事二审案件_100002");
        Case case_3 = caseDao.find("C__Users_Administrator_Desktop_刑事二审案件_刑事二审案件_10008");
        userDao.uploadCase(case_1, "151250032");
        userDao.uploadCase(case_2, "151250032");
        userDao.uploadCase(case_3, "151250032");
    }

    @Ignore
    @Test
    public void getAllCase() throws Exception {
        List<Case> caseList = userDao.getAllCase("151250032");
        assertEquals(3,caseList.size());
        assertEquals("C__Users_Administrator_Desktop_刑事二审案件_刑事二审案件_100000",caseList.get(0).getCaseID());
        assertEquals("C__Users_Administrator_Desktop_刑事二审案件_刑事二审案件_100002",caseList.get(1).getCaseID());
        assertEquals("C__Users_Administrator_Desktop_刑事二审案件_刑事二审案件_10008",caseList.get(2).getCaseID());
    }
}