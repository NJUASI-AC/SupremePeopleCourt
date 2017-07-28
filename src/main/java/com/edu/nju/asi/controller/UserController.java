package com.edu.nju.asi.controller;

import com.edu.nju.asi.model.User;
import com.edu.nju.asi.service.UserService;
import com.edu.nju.asi.utilities.exception.PasswordWrongException;
import com.edu.nju.asi.utilities.exception.UserExistedException;
import com.edu.nju.asi.utilities.exception.UserNotExistedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuihua on 2017/7/28.
 */
@Controller("user")
public class UserController {


    @Autowired
    UserService userService;


    /**
     * @param workID
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/welcome")
    public ModelAndView welcome(@RequestParam("workID") String workID, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            try {
                response.sendRedirect("/welcome");
            } catch (IOException e) {
                Logger.getLogger(UserController.class.getName()).error(e.getMessage());
            }
        }

        // TODO 用户界面需要的信息
        ModelAndView mv = new ModelAndView();

        User wantedUser = null;
        try {
            wantedUser = userService.getOne(workID);
            mv.addObject("user", wantedUser);

        } catch (UserNotExistedException e) {
            Logger.getLogger(UserController.class.getName()).error(e.getMessage());
            mv.addObject("errorCode", -2);
            mv.setViewName("errorPage");
        }

        mv.addObject("user", wantedUser);

        // TODO 返回的界面
        mv.setViewName("");
        return mv;

    }

    /**
     * 【请求】用户注册，注册后自动登录
     *
     * @return 1: 注册成功
     * 2: 用户已被注册
     * 4: 未知错误
     */
    @PostMapping(value = "/req_register", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String reqRegister(@RequestParam("workID") String workID, @RequestParam("name") String name,
                       @RequestParam("password") String password, @RequestParam("subordinationCourt") String subordinationCourt,
                       HttpServletRequest request, HttpServletResponse response) {
        System.out.println(workID + "  " + password);

        boolean result;
        try {
            User thisUser = new User(workID, name, password, subordinationCourt);
            result = userService.register(thisUser);

            // 保存了已登陆用户的ID，用途再议
            saveCurUser(workID, request);

        } catch (UserExistedException e) {
            Logger.getLogger(UserController.class).error(e.getMessage());
            return "2";
        }

        if (result) return "1";
        else return "4";
    }


    /**
     * 【请求】用户登录
     *
     * @return 1: 登录成功
     * 2: 用户未注册
     * 3: 密码错误
     * 4: 未知错误
     */
    @PostMapping(value = "/req_log_in", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String reqLogIn(@RequestParam("workID") String workID, @RequestParam("password") String password,
                    HttpServletRequest request, HttpServletResponse response) {
        boolean result;
        try {
            result = userService.logIn(workID, password);

            // 保存了已登陆用户的ID，用途再议
            saveCurUser(workID, request);

        } catch (UserNotExistedException e) {
            Logger.getLogger(UserController.class).error(e.getMessage());
            return "2";
        } catch (PasswordWrongException e) {
            Logger.getLogger(UserController.class).error(e.getMessage());
            return "3";
        }

        if (result) return "1";
        else return "4";
    }


    /**
     * 【请求】用户登出
     *
     * @return 1: 登出成功
     * 4: 未知错误
     */
    @PostMapping(value = "/req_log_out", produces = "text/html;charset=UTF-8;")
    public @ResponseBody
    String reqLogOut(@RequestParam("workID") String workID, HttpServletRequest request, HttpServletResponse response) {
        // 限制进入
        HttpSession session = request.getSession(false);
        if (session == null) {
            try {
                response.sendRedirect("/welcome");
            } catch (IOException e) {
                Logger.getLogger(UserController.class.getName()).error(e.getMessage());
            }
        }

        boolean result = userService.logOut(workID);
        delCurUser(workID, request);

        if (result) return "1";
        else return "4";
    }


    /**
     * 保存了已登陆用户的ID，用途再议
     */
    private void saveCurUser(String workID, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<String> userIDs;
        if (session.getAttribute("users") != null) {
            userIDs = (List<String>) session.getAttribute("users");
            userIDs.add(workID);
        } else {
            userIDs = new LinkedList<>();
            userIDs.add(workID);
        }
        session.setAttribute("users", userIDs);
    }

    /**
     * 移除已登陆用户的ID，用途再议
     */
    private void delCurUser(String workID, HttpServletRequest request) {
        // 保存了已登陆用户的ID，用途再议
        HttpSession session = request.getSession(true);
        List<String> userIDs = null;
        if (session.getAttribute("users") != null) {
            userIDs = (List<String>) session.getAttribute("users");
            userIDs.remove(workID);
        }
        session.setAttribute("users", userIDs);
    }

}
