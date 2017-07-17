package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.FullTextDao;
import com.edu.nju.asi.model.FullText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Repository("FullTextDaoImpl")
public class FullTextDaoImpl implements FullTextDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private String collectionName = "FullText";

    /**
     * 添加
     *
     * @param fullText 要插入的对象
     */
    @Override
    public void insert(FullText fullText) {
        mongoTemplate.insert(fullText,collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param caseNum 案号
     * @return CaseBasic
     */
    @Override
    public FullText find(String caseNum) {
        Query query = new Query(Criteria.where("caseNum").is(caseNum));
        return mongoTemplate.findOne(query, FullText.class, collectionName);
    }
}
