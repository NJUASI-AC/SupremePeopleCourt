package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.RefereeAnalysisProcessDao;
import com.edu.nju.asi.model.RefereeAnalysisProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Repository("RefereeAnalysisProcessDaoImpl")
public class RefereeAnalysisProcessDaoImpl implements RefereeAnalysisProcessDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private String collectionName = "RefereeAnalysisProcess";

    /**
     * 添加
     *
     * @param refereeAnalysisProcess 要插入的对象
     */
    @Override
    public void insert(RefereeAnalysisProcess refereeAnalysisProcess) {
        mongoTemplate.insert(refereeAnalysisProcess, collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param caseNum 案号
     * @return CaseBasic
     */
    @Override
    public RefereeAnalysisProcess find(String caseNum) {
        Query query = new Query(Criteria.where("caseNum").is(caseNum));
        return mongoTemplate.findOne(query, RefereeAnalysisProcess.class, collectionName);
    }
}
