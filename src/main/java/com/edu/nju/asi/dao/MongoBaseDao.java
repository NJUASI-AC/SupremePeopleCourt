package com.edu.nju.asi.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/16 0016.
 */
public interface MongoBaseDao<T> {
    /**
     * 添加
     * @param object 要插入的对象
     * @param collectionName 集合名称
     */
    public void insert(T object, String collectionName);

    /**
     * 根据条件查找一个
     * @param params 条件
     * @param collectionName 集合名称
     * @return
     */
    public T findOne(Map<String, Object> params, String collectionName);

    /**
     * 根据条件查找所有
     * @param params 条件
     * @param collectionName 集合名称
     * @return
     */
    public List<T> findAll(Map<String, Object> params, String collectionName);

    /**
     * 修改
     * @param params 条件
     * @param collectionName 集合名称
     */
    public void update(Map<String, Object> params, String collectionName);

    /**
     * 创建集合
     * @param collectionName　集合名称
     */
    public void createCollection(String collectionName);

    /**
     * 根据条件删除
     * @param params 条件
     * @param collectionName　集合名称
     */
    public void remove(Map<String, Object> params, String collectionName);


}
