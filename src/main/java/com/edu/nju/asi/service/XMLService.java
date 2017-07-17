package com.edu.nju.asi.service;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
public interface XMLService {

    /**
     * 离线上传文件（用于数据库训练数据）
     * @param url xml文件地址
     */
    public void uploadOffline(String url);

}
