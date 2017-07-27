package com.edu.nju.asi.utilities.exception;

/**
 * Created by Byron Dong on 2017/7/27.
 */
public class UserExistedException extends Exception{

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        return "该用户已存在";
    }
}
