package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Byron Dong on 2017/7/17.
 */
@Repository(value = "BaseDaoImpl")
public class BaseDaoImpl implements BaseDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    /**
     * 添加
     *
     * @param object         要插入的对象
     * @param collectionName 集合名称
     */
    @Override
    public void insert(Object object, String collectionName) {
        mongoTemplate.insert(object, collectionName);
    }

    /**
     * 根据条件查找一个
     * @param id 主键
     * @param idName 主键名称
     * @param entityClass 集合类型
     * @param collectionName 集合名称
     * @return
     */
    @Override
    public Object find(String idName,Object id, Class entityClass, String collectionName) {
        Query query = new Query(Criteria.where(idName).is(id));
        return mongoTemplate.find(query,entityClass, collectionName);
    }
}
