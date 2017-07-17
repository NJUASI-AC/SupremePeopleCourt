package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.LitigationParticipantsDao;
import com.edu.nju.asi.model.LitigationParticipants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Repository("LitigationParticipantsDaoImpl")
public class LitigationParticipantsDaoImpl implements LitigationParticipantsDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private String collectionName = "LitigationParticipants";

    /**
     * 添加
     *
     * @param litigationParticipants 要插入的对象
     */
    @Override
    public void insert(LitigationParticipants litigationParticipants) {
        mongoTemplate.insert(litigationParticipants, collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param caseNum 案号
     * @return CaseBasic
     */
    @Override
    public LitigationParticipants find(String caseNum) {
        Query query = new Query(Criteria.where("caseNum").is(caseNum));
        return mongoTemplate.findOne(query, LitigationParticipants.class, collectionName);
    }
}
