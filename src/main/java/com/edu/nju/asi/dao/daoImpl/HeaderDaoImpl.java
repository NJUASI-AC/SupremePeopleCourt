package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.HeaderDao;
import com.edu.nju.asi.model.Header;
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
@Repository("HeaderDaoImpl")
public class HeaderDaoImpl implements HeaderDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private String collectionName = "Header";

    /**
     * 添加
     *
     * @param header 要插入的对象
     */
    @Override
    public void insert(Header header) {
        mongoTemplate.insert(header,collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param caseID 案号
     * @return CaseBasic
     */
    @Override
    public Header find(String caseID) {
        Query query = new Query(Criteria.where("caseID").is(caseID));
        return mongoTemplate.findOne(query, Header.class, collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param actionCode 案件名称
     * @return Map<String, Header>
     */
    @Override
    public Map<String, Header> findAll(String actionCode) {
        Query query = new Query(Criteria.where("actionCode").is(actionCode));
        List<Header> headerList = mongoTemplate.find(query, Header.class, collectionName);
        Map<String, Header> map = new HashMap<>();
        for(Header header:headerList){
            map.put(header.getCaseID(), header);
        }
        return map;
    }

    /**
     * 批量插入数据
     *
     * @param headers info列表
     * @return CaseBasic
     */
    @Override
    public void insertAll(List<Header> headers) {
        mongoTemplate.insert(headers, collectionName);
    }

    /**
     * 删除集合
     */
    @Override
    public void dropCollection() {
        mongoTemplate.dropCollection(collectionName);
    }
}
