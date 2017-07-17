package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.ProceedingsDao;
import com.edu.nju.asi.model.Proceedings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Repository("ProceedingsDaoImpl")
public class ProceedingsDaoImpl implements ProceedingsDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private String collectionName = "Proceedings";

    /**
     * 添加
     *
     * @param proceedings 要插入的对象
     */
    @Override
    public void insert(Proceedings proceedings) {
        mongoTemplate.insert(proceedings, collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param caseNum 案号
     * @return CaseBasic
     */
    @Override
    public Proceedings find(String caseNum) {
        Query query = new Query(Criteria.where("caseNum").is(caseNum));
        return mongoTemplate.findOne(query, Proceedings.class, collectionName);
    }
}
