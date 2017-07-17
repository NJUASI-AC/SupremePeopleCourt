package com.edu.nju.asi.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by gkj on 2017/7/17.
 */
public class test {
    @RequestMapping(value = "/upload")
    public void upload(HttpServletRequest request, HttpServletResponse response){
        System.out.println("here");
    }
}
