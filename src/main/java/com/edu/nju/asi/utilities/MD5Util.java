package com.edu.nju.asi.utilities;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by cuihua on 2017/7/28.
 */
public class MD5Util {

    private MD5Util() {
    }

    /**
     * 使用MD5加密，MD5加密后不能解密
     *
     * @param info 需要加密的信息
     * @return String 加密后的字符
     */
    public static String encodeMD5(String info) {

        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(info.getBytes("UTF-8"));
            StringBuilder hexValue = new StringBuilder();

            for (byte md5Byte : md5Bytes) {
                int temp = ((int) md5Byte) & 0xff;

                if (temp < 16) {
                    hexValue.append(0);
                }

                hexValue.append(Integer.toHexString(temp));
            }

            return hexValue.toString();

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            Logger.getLogger(MD5Util.class).error(e.getMessage());
        }
        return null;
    }
}
