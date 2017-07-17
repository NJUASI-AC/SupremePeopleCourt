package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.JudgementResultDao;
import com.edu.nju.asi.model.JudgementResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Repository("JudgementResultDaoImpl")
public class JudgementResultDaoImpl implements JudgementResultDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private String collectionName = "JudgementResult";

    /**
     * 添加
     *
     * @param judgementResult 要插入的对象
     */
    @Override
    public void insert(JudgementResult judgementResult) {
        mongoTemplate.insert(judgementResult, collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param caseNum 案号
     * @return CaseBasic
     */
    @Override
    public JudgementResult find(String caseNum) {
        Query query = new Query(Criteria.where("caseNum").is(caseNum));
        return mongoTemplate.findOne(query, JudgementResult.class, collectionName);
    }
}
