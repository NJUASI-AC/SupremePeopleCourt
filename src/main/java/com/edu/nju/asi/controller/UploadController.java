package com.edu.nju.asi.controller;

import com.edu.nju.asi.InfoCarrier.Case;
import com.edu.nju.asi.InfoCarrier.RecommendCase;
import com.edu.nju.asi.InfoCarrier.RecommendWeight;
import com.edu.nju.asi.service.RecommendService;
import com.edu.nju.asi.service.XMLService;
import org.apache.log4j.Logger;
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
import java.util.List;

/**
 * Created by cuihua on 2017/7/17.
 */
@Controller
public class UploadController {

    @Autowired
    XMLService xmlService;
    @Autowired
    RecommendService recommendService;
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
                Logger.getLogger(UploadController.class.getName()).error(e.getMessage());
            }
        }

        ModelAndView mv = new ModelAndView();
        Case wantedCase = null;
        List<RecommendWeight> weight = null;
        List<Case> detailMessages=null;
        try {
            wantedCase = xmlService.uploadOnline(uploadedFile);
            weight = recommendService.recommend(wantedCase);
            detailMessages = recommendService.getWholeMessage(weight);
        } catch (IOException e) {
            Logger.getLogger(UploadController.class.getName()).error(e.getMessage());
            mv.addObject("errorCode", -1);
            mv.setViewName("errorPage");
        }




        if (wantedCase == null) {
            mv.addObject("errorCode", 0);
            mv.setViewName("errorPage");
        }
        else {
            mv.addObject("caseInfo", wantedCase);
            mv.addObject("analyseInfo", weight);

            mv.setViewName("info");
        }

        return mv;
    }
}
