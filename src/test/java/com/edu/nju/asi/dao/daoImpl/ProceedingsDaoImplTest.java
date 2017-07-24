package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.dao.ProceedingsDao;
import com.edu.nju.asi.model.Proceedings;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Byron Dong on 2017/7/19.
 */
public class ProceedingsDaoImplTest {

    private ProceedingsDao proceedingsDao;

    @Before
    public void setUp() throws Exception {
        proceedingsDao = DaoManager.proceedingsDao;
    }

    @Ignore
    @Test
    public void find() throws Exception {
        System.out.println(proceedingsDao.find("(2009)南民初字第0229号民事裁定书（准许或不准许撤诉用）").getMainActionCause());

    }

    @Ignore
    @Test
    public void findAll() throws Exception {
//        long start = System.currentTimeMillis();
//        Set<String> codes = new HashSet<>();
//        codes.add("9042");
//        Map<String, Proceedings> map = proceedingsDao.findAll(codes);
//        System.out.println(System.currentTimeMillis()-start);
//        System.out.println(map.size());
//        for(String code: map.keySet()){
//            System.out.println(code);
//        }
    }

}