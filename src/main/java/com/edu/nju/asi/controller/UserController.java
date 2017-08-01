package com.edu.nju.asi.controller;

import com.edu.nju.asi.model.Case;
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
import java.util.List;

/**
 * Created by cuihua on 2017/7/28.
 */
@Controller("user")
public class UserController {


    @Autowired
    UserService userService;

    private static Logger logger = Logger.getLogger(UserController.class);


    /**
     * @return mv: 正常的界面
     * errorPage: 错误界面（错误码-2）
     */
    @GetMapping("/welcome")
    public ModelAndView welcome( HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        if (session == null) {
            try {
                response.sendRedirect("/welcome");
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }

        ModelAndView mv = new ModelAndView();

        User wantedUser = null;
        List<Case> cases = null;
        String workID = null;
        if(session!=null){
            workID = session.getAttribute("user").toString();
        }
        try {
            wantedUser = userService.getOne(workID);
            cases = userService.getAllCase(workID);
            mv.addObject("user", wantedUser);
            mv.addObject("cases",cases);
        } catch (UserNotExistedException e) {
            logger.error(e.getMessage());
            mv.addObject("errorCode", -2);
            mv.setViewName("errorPage");
        }

        mv.setViewName("user");
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
        boolean result;
        try {
            User thisUser = new User(workID, name, password, subordinationCourt);
            result = userService.register(thisUser);

            // 保存了已登陆用户的ID，用途再议
            HttpSession session = request.getSession(true);
            session.setAttribute("user",workID);


        } catch (UserExistedException e) {
            logger.error(e.getMessage());
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
            HttpSession session = request.getSession(true);
            session.setAttribute("user",workID);

        } catch (UserNotExistedException e) {
            logger.error(e.getMessage());
            return "2";
        } catch (PasswordWrongException e) {
            logger.error(e.getMessage());
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
    String reqLogOut(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        session.setAttribute("user", null);
        return "1";
    }


}
