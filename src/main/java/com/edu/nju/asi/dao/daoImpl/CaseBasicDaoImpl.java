package com.edu.nju.asi.dao.daoImpl;


import com.edu.nju.asi.dao.CaseBasicDao;
import com.edu.nju.asi.model.CaseBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
     * @param caseID 案号
     * @return CaseBasic
     */
    @Override
    public CaseBasic find(String caseID) {
        Query query = new Query(Criteria.where("caseID").is(caseID));
        return mongoTemplate.findOne(query, CaseBasic.class, collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param caseIDS 案件ID集合
     * @return List<CaseBasic>
     */
    @Override
    public List<CaseBasic> findAll(Set<String> caseIDS) {
        List<CaseBasic> caseBasics = new ArrayList<>();
        for(String caseID: caseIDS){
            Query query = new Query(Criteria.where("caseID").is(caseID));
            caseBasics.add(mongoTemplate.findOne(query, CaseBasic.class));
        }
        return caseBasics;
    }

    /**
     * 批量插入数据
     *
     * @param caseBasics info列表
     * @return CaseBasic
     */
    @Override
    public void insertAll(List<CaseBasic> caseBasics) {
        mongoTemplate.insert(caseBasics, collectionName);
    }

    /**
     * 删除集合
     */
    @Override
    public void dropCollection() {
        mongoTemplate.dropCollection(collectionName);
    }
}
