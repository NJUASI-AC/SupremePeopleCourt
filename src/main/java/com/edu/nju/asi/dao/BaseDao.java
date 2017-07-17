package com.edu.nju.asi.dao;

/**
 * Created by Administrator on 2017/7/16 0016.
 */
 public interface BaseDao<T> {

    /**
     * 添加
     * @param object 要插入的对象
     * @param collectionName 集合名称
     */
     void insert(T object, String collectionName);

    /**
     * 根据条件查找一个
     * @param id 主键
     * @param idName 主键名称
     * @param entityClass 集合类型
     * @param collectionName 集合名称
     * @return
     */
     T find(String idName,Object id, Class<?> entityClass, String collectionName);
}
