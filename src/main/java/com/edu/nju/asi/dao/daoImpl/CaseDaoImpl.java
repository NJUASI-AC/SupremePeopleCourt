package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.InfoCarrier.RecommendCase;
import com.edu.nju.asi.dao.CaseDao;
import com.edu.nju.asi.model.Case;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Byron Dong on 2017/7/24.
 */
@Repository("CaseDaoImpl")
public class CaseDaoImpl implements CaseDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private String collectionName = "Case";

    /**
     * 添加
     *
     * @param case_need 要插入的对象
     */
    @Override
    public void insert(Case case_need) {
        mongoTemplate.insert(case_need, collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param caseID 案件名称
     * @return CaseBasic
     */
    @Override
    public Case find(String caseID) {
        Query query = new Query(Criteria.where("caseID").is(caseID));
        return mongoTemplate.findOne(query, Case.class, collectionName);
    }

    /**
     * 批量插入数据
     *
     * @param cases info列表
     * @return CaseBasic
     */
    @Override
    public void insertAll(List<Case> cases) {
        mongoTemplate.insert(cases, collectionName);
    }

    /**
     * 删除集合
     */
    @Override
    public void dropCollection() {
        mongoTemplate.dropCollection(collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param actionCode 案件名称
     * @return List<RecommendCase>
     */
    @Override
    public List<RecommendCase> findAll(String actionCode) {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("proceedings.mainActionCause.actionCode",actionCode);
        BasicDBObject basicDBObject = this.createRecommendObject();
        Query query = new BasicQuery(dbObject,basicDBObject);
        List<Case> caseList = mongoTemplate.find(query, Case.class, collectionName);
        List<RecommendCase> recommendCases = new ArrayList<>();
        for (Case case_need : caseList) {
            recommendCases.add(new RecommendCase(case_need));
        }
        return recommendCases;
    }

    /**
     * 获取推荐案例信息
     *
     * @param actionCodes 案号
     * @return List<RecommendCase>
     */
    @Override
    public List<RecommendCase> getRecommendCase(List<String> actionCodes) {
        List<RecommendCase> recommendCases = new ArrayList<>();
        for (String actionCode : actionCodes) {
            recommendCases.addAll(this.findAll(actionCode));
        }
        return recommendCases;
    }

    /**
     * 获取推荐案例信息
     *
     * @param caseIDS 案件ID集合
     * @return List<Case> 那件
     */
    @Override
    public List<Case> getCase(List<String> caseIDS) {
        List<Case> caseList = new ArrayList<>();
        for (String caseID : caseIDS) {
            Query query = new Query(Criteria.where("caseID").is(caseID));
            Case case_need = mongoTemplate.findOne(query, Case.class, collectionName);
            if (case_need != null) {
                caseList.add(case_need);
            }
        }
        return caseList;
    }

    /**
     * 获取推荐案例最小集
     *
     * @return BasicDBObject
     */
    private BasicDBObject createRecommendObject(){
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("caseID",true);
        basicDBObject.put("header.caseNum",true);
        basicDBObject.put("header.handlingCourt",true);
        basicDBObject.put("header.nameOfDocument",true);
        basicDBObject.put("proceedings.records",true);
        basicDBObject.put("proceedings.mainActionCause",true);
        basicDBObject.put("proceedings.extraActionCause",true);
        basicDBObject.put("caseBasic.paragraphThisTrial",true);
        basicDBObject.put("refereeAnalysisProcess",true);
        return basicDBObject;
    }
}
