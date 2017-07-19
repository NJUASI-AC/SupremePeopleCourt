package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.RefereeAnalysisProcessDao;
import com.edu.nju.asi.model.RefereeAnalysisProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

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
     * @param caseID 案号
     * @return CaseBasic
     */
    @Override
    public RefereeAnalysisProcess find(String caseID) {
        Query query = new Query(Criteria.where("caseID").is(caseID));
        return mongoTemplate.findOne(query, RefereeAnalysisProcess.class, collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param caseIDs 案件ID集合
     * @return Map<String, RefereeAnalysisProcess>
     */
    @Override
    public Map<String, RefereeAnalysisProcess> findAll(Set<String> caseIDs) {
        Map<String, RefereeAnalysisProcess> refereeAnalysisProcesses = new HashMap<>();
        for(String caseID: caseIDs){
            Query query = new Query(Criteria.where("caseID").is(caseID));
            RefereeAnalysisProcess refereeAnalysisProcess = mongoTemplate.findOne(query, RefereeAnalysisProcess.class);
            if(refereeAnalysisProcess!=null) {
                refereeAnalysisProcesses.put(caseID,refereeAnalysisProcess);
            }
        }
        return refereeAnalysisProcesses;
    }

    /**
     * 批量插入数据
     *
     * @param refereeAnalysisProcesses info列表
     * @return CaseBasic
     */
    @Override
    public void insertAll(List<RefereeAnalysisProcess> refereeAnalysisProcesses) {
        mongoTemplate.insert(refereeAnalysisProcesses, collectionName);
    }

    /**
     * 删除集合
     */
    @Override
    public void dropCollection() {
        mongoTemplate.dropCollection(collectionName);
    }
}
