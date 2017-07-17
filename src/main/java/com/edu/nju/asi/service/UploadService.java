package com.edu.nju.asi.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by cuihua on 2017/7/17.
 */
public interface UploadService {

    /**
     * @param uploadedFile 要上传的XML文件
     */
    void upload(MultipartFile uploadedFile);
}
