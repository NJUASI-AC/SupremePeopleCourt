package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.InfoCarrier.Case;
import com.edu.nju.asi.InfoCarrier.CaseID;
import com.edu.nju.asi.dao.ProceedingsDao;
import com.edu.nju.asi.model.Proceedings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public Proceedings find(CaseID caseID) {
        Query query = new Query(Criteria.where("caseID").is(caseID));
        return mongoTemplate.findOne(query, Proceedings.class, collectionName);
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
