package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.TailorDao;
import com.edu.nju.asi.model.Tailor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Repository("TailorDaoImpl")
public class TailorDaoImpl implements TailorDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private String collectionName = "Tailor";

    /**
     * 添加
     *
     * @param tailor 要插入的对象
     */
    @Override
    public void insert(Tailor tailor) {
        mongoTemplate.insert(tailor, collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param caseID 案号
     * @return CaseBasic
     */
    @Override
    public Tailor find(String caseID) {
        Query query = new Query(Criteria.where("caseID").is(caseID));
        return mongoTemplate.findOne(query, Tailor.class, collectionName);
    }
}
