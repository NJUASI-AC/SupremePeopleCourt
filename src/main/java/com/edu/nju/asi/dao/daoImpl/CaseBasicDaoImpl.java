package com.edu.nju.asi.dao.daoImpl;


import com.edu.nju.asi.dao.CaseBasicDao;
import com.edu.nju.asi.model.CaseBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Repository("CaseBasicDaoImpl")
public class CaseBasicDaoImpl implements CaseBasicDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private String collectionName = "CaseBasic";


    /**
     * 添加
     *
     * @param caseBasic 要插入的对象
     */
    @Override
    public void insert(CaseBasic caseBasic) {
        mongoTemplate.insert(caseBasic, collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param caseNum 案号
     * @return CaseBasic
     */
    @Override
    public CaseBasic find(String caseNum) {
        Query query = new Query(Criteria.where("caseNum").is(caseNum));
        return mongoTemplate.findOne(query, CaseBasic.class, collectionName);
    }
}
