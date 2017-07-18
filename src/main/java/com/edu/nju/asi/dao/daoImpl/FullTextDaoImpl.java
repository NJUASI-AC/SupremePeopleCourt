package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.FullTextDao;
import com.edu.nju.asi.model.FullText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 批量插入数据
     *
     * @param fullTexts info列表
     * @return CaseBasic
     */
    @Override
    public void insertAll(List<FullText> fullTexts) {
        mongoTemplate.insert(fullTexts, collectionName);
    }

    /**
     * 删除集合
     */
    @Override
    public void dropCollection() {
        mongoTemplate.dropCollection(collectionName);
    }
}
