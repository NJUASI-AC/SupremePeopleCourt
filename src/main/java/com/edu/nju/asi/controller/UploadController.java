package com.edu.nju.asi.controller;

import com.alibaba.fastjson.JSON;
import com.edu.nju.asi.model.Case;
import com.edu.nju.asi.InfoCarrier.RecommendWeight;
import com.edu.nju.asi.service.RecommendService;
import com.edu.nju.asi.service.UserService;
import com.edu.nju.asi.service.XMLService;
import com.edu.nju.asi.service.serviceImpl.RecommendServiceImpl;
import com.edu.nju.asi.utilities.exception.RedundancyCaseException;
import com.edu.nju.asi.utilities.exception.UserNotExistedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    UserService userService;


    private static Logger logger = Logger.getLogger(UploadController.class);

    /**
     * 上传文件并可视化显示分析结果
     */
    @PostMapping(value = "upload")
    public ModelAndView upload(@RequestParam("file") MultipartFile uploadedFile, HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        if (session == null) {
            try {
                response.sendRedirect("/welcome");
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }

        ModelAndView mv = new ModelAndView();

        Case wantedCase = null;
        try {
            wantedCase = xmlService.uploadOnline(uploadedFile);
            if(session.getAttribute("user")!=null) {
                xmlService.saveCase(wantedCase, session.getAttribute("user").toString());
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            mv.addObject("errorCode", -1);
            mv.setViewName("errorPage");
        }catch (UserNotExistedException e){
            logger.error(e.getMessage());
        }catch (RedundancyCaseException e){
            logger.error(e.getMessage());
        }


        if (wantedCase == null) {
            mv.addObject("errorCode", 0);
            mv.setViewName("errorPage");
        } else {
            mv.addObject("caseInfo", wantedCase);
            mv.setViewName("info");
        }

        return mv;
    }


    /**
     * 查看历史上传文件 显示分析结果
     */
    @GetMapping("/view/{caseID}")
    public ModelAndView viewCase(@PathVariable("caseID")  String caseID , HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        if (session == null) {
            try {
                response.sendRedirect("/welcome");
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }

        ModelAndView mv = new ModelAndView();

        Case wantedCase = null;
        try {
            String workID = null;
            if(session!=null){
                workID = session.getAttribute("user").toString();
            }
            List<Case> cases=userService.getAllCase(workID);
            for (Case theCase : cases){
                if (theCase.getCaseID().equals(caseID)){
                    wantedCase = theCase;
                }
            }
        }catch (UserNotExistedException e1){
            logger.error(e1.getMessage());
            mv.addObject("errorCode", -1);
            mv.setViewName("errorPage");
        }


        if (wantedCase != null) {
            mv.addObject("caseInfo", wantedCase);
            mv.setViewName("info");
        } else {
            mv.addObject("errorCode", 0);
            mv.setViewName("errorPage");
        }

        return mv;
    }


    /**
     * 异步展示案例的推荐
     * @param caseID 上传的案例ID，要查看对其的推荐
     * @return 推荐案例的JSON字符串
     */
    @GetMapping(value = "reqRecommendation", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String reqRecommendation(@RequestParam("caseID") String caseID,HttpServletRequest request, HttpServletResponse response) {
        recommendService = new RecommendServiceImpl();
        List<RecommendWeight> weight = null;
        HttpSession session = request.getSession(false);
        Case wantedCase= null;
        if(session!=null) {
            if (session.getAttribute("user") != null) {
                wantedCase = getMyCase(session.getAttribute("user").toString(), caseID);
            }
        }
        if(wantedCase == null ) {
            weight = recommendService.recommend(caseID);
        }else{
            weight = recommendService.recommend(wantedCase);
        }
        List<Case> detailMessages = recommendService.getWholeMessage(weight);

        StringBuilder result = new StringBuilder();
        if (detailMessages != null) {
            result.append(detailMessages.size()).append(";");
            result.append(JSON.toJSONString(weight)).append(";");
            result.append(JSON.toJSONString(detailMessages)).append(";");
        }
        return result.toString();
    }

    private Case getMyCase(String workID, String caseID){
        Case wantedCase=null;
        try{
        List<Case> cases=userService.getAllCase(workID);
            for (Case theCase : cases){
                if (theCase.getCaseID().equals(caseID)){
                    wantedCase = theCase;
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return wantedCase;
    }
}
