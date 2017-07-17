package com.edu.nju.asi.controller;

import com.edu.nju.asi.InfoCarrier.Case;
import com.edu.nju.asi.service.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cuihua on 2017/7/17.
 */
@Controller
public class UploadController {

    @Autowired
    XMLService xmlService;

    /**
     * 上传文件并可视化显示分析结果
     */
    @PostMapping(value = "upload")
    public ModelAndView upload(@RequestParam("file") MultipartFile uploadedFile, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Connect!!!");

        HttpSession session = request.getSession(false);
        if (session == null) {
            try {
                response.sendRedirect("/welcome");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ModelAndView mv = new ModelAndView();
        Case wantedCase = null;
        try {
            wantedCase = xmlService.uploadOnline(uploadedFile);
        } catch (IOException e) {
            e.printStackTrace();
            mv.addObject("errorCode", -1);
            mv.setViewName("errorPage");
        }

        if (wantedCase == null) {
            mv.addObject("errorCode", 0);
            mv.setViewName("errorPage");
        }
        else {
            mv.addObject("case", wantedCase);
            mv.setViewName("info");
        }
        return mv;
    }
}
