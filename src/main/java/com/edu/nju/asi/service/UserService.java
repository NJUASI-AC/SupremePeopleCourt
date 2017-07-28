package com.edu.nju.asi.service;

import com.edu.nju.asi.model.User;
import com.edu.nju.asi.utilities.exception.PasswordWrongException;
import com.edu.nju.asi.utilities.exception.UserExistedException;
import com.edu.nju.asi.utilities.exception.UserNotExistedException;

/**
 * Created by cuihua on 2017/7/28.
 */
public interface UserService {

    /**
     * @param user 要注册的法官
     * @return 是否注册成功
     * @throws UserExistedException 法官工号重复
     */
    boolean register(User user) throws UserExistedException;

    /**
     * @param workID 法官ID
     * @param password 登录密码
     * @return 是否登录成功
     */
    boolean logIn(String workID, String password) throws UserNotExistedException, PasswordWrongException;

    /**
     * @param workID 法官ID
     * @return 是否成功登出
     */
    boolean logOut(String workID);

    /**
     *
     * @param workID 法官ID
     * @return 该用户的全部信息
     */
    User getOne(String workID) throws UserNotExistedException;
}
