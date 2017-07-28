package com.edu.nju.asi.service.serviceImpl;

import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.dao.UserDao;
import com.edu.nju.asi.model.User;
import com.edu.nju.asi.service.UserService;
import com.edu.nju.asi.utilities.MD5Util;
import com.edu.nju.asi.utilities.exception.PasswordWrongException;
import com.edu.nju.asi.utilities.exception.UserExistedException;
import com.edu.nju.asi.utilities.exception.UserNotExistedException;
import org.springframework.stereotype.Service;

/**
 * Created by cuihua on 2017/7/28.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = DaoManager.userDao;
    }

    @Override
    public boolean register(User user) throws UserExistedException {
        if (userDao.find(user.getWorkID()) == null) {
            throw new UserExistedException();
        }

        user.setPassword(MD5Util.encodeMD5(user.getPassword()));
        userDao.insert(user);
        return true;
    }

    @Override
    public boolean logIn(String workID, String password) throws UserNotExistedException, PasswordWrongException {
        User wanted = userDao.find(workID);

        if (wanted == null) {
            throw new UserNotExistedException();
        } else {
            String wantedPassword = wanted.getPassword();

            if (MD5Util.encodeMD5(password).equals(wantedPassword)) {
                return true;
            } else {
                throw new PasswordWrongException();
            }
        }
    }

    /*
    是否做不可重复登录等功能，再议
     */
    @Override
    public boolean logOut(String workID) {
        return true;
    }

    @Override
    public User getOne(String workID) throws UserNotExistedException {
        User wanted = userDao.find(workID);
        if (wanted == null) {
            throw new UserNotExistedException();
        } else {
            return wanted;
        }
    }
}
