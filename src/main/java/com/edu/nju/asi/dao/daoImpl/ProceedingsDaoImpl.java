package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.ProceedingsDao;
import com.edu.nju.asi.model.Proceedings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * @param caseID 案号
     * @return CaseBasic
     */
    @Override
    public Proceedings find(String caseID) {
        Query query = new Query(Criteria.where("caseID").is(caseID));
        return mongoTemplate.findOne(query, Proceedings.class, collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param actionCode 案件名称
     * @return Map<String, Header>
     */
    @Override
    public Map<String, Proceedings> findAll(String actionCode) {
        Query query = new Query(Criteria.where("mainActionCause.actionCode").is(actionCode));
        List<Proceedings> proceedingsList = mongoTemplate.find(query, Proceedings.class, collectionName);
        Map<String, Proceedings> map = new HashMap<>();
        for(Proceedings proceedings:proceedingsList){
//            map.put(proceedings.getCaseID(), proceedings);
        }
        return map;
    }

    /**
     * 批量插入数据
     *
     * @param proceedings info列表
     * @return CaseBasic
     */
    @Override
    public void insertAll(List<Proceedings> proceedings) {
        mongoTemplate.insert(proceedings, collectionName);
    }

    /**
     * 删除集合
     */
    @Override
    public void dropCollection() {
        mongoTemplate.dropCollection(collectionName);
    }
}
