package com.edu.nju.asi.utilities.exception;

/**
 * Created by cuihua on 2017/7/28.
 */
public class PasswordWrongException extends Exception {

    @Override
    public String getMessage() {
        return "密码错误！";
    }
}
