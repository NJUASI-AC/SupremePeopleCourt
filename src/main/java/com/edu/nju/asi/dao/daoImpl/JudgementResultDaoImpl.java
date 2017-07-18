package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.JudgementResultDao;
import com.edu.nju.asi.model.JudgementResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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
     * @param caseID 案号
     * @return CaseBasic
     */
    @Override
    public JudgementResult find(String caseID) {
        Query query = new Query(Criteria.where("caseID").is(caseID));
        return mongoTemplate.findOne(query, JudgementResult.class, collectionName);
    }

    /**
     * 批量插入数据
     *
     * @param judgementResults info列表
     * @return CaseBasic
     */
    @Override
    public void insertAll(List<JudgementResult> judgementResults) {
        mongoTemplate.insert(judgementResults, collectionName);
    }

    /**
     * 删除集合
     */
    @Override
    public void dropCollection() {
        mongoTemplate.dropCollection(collectionName);
    }
}
