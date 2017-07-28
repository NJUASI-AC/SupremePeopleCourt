package com.edu.nju.asi.utilities.exception;

/**
 * Created by Byron Dong on 2017/7/27.
 */
public class RedundancyCaseException extends Exception {

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        return "请不要重复上传相同案例";
    }
}
