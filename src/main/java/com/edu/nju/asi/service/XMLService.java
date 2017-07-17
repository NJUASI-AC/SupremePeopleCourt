package com.edu.nju.asi.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/17 0017.
 */
public interface XMLService {

    /**
     * 离线上传文件（用于数据库训练数据）
     * @param url xml文件地址
     */
    void uploadOffline(String url);

    /**
     * @param uploadedFile 要上传的XML文件
     */
    boolean uploadOnline(MultipartFile uploadedFile) throws IOException;

}
