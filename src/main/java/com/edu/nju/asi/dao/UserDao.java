package com.edu.nju.asi.dao;

import com.edu.nju.asi.model.User;
import com.edu.nju.asi.utilities.exception.UserExistedException;
import com.edu.nju.asi.utilities.exception.UserNotExistedException;

/**
 * Created by Byron Dong on 2017/7/27.
 */
public interface UserDao {

    /**
     * 添加
     *
     * @param user 要插入的对象
     */
    void insert(User user) throws UserExistedException;

    /**
     * 根据条件查找一个
     *
     * @param workID 案件名称
     * @return User
     */
    User find(String workID);

    /**
     * 需改
     *
     * @param user 要修改的对象
     */
    void update(User user) throws UserNotExistedException;

    /**
     * 注销用户
     *
     * @param workID 案件名称
     * @return User
     */
    void delete(String workID) throws UserNotExistedException;

    /**
     * 删除集合
     */
    void dropCollection();

}
