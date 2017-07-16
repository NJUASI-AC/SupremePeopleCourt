package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/16 0016.
 */
public class UserDaoImplTest {

    public UserDao userDaoImpl;


    @Before
    public void setUp(){

        userDaoImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean(UserDao.class);
    }

    @Test
    public void createCollection() throws Exception {
//        userDaoImpl.createCollection("law");
        assertEquals(userDaoImpl.getColletions(), 1.0, 1.0);
    }

}