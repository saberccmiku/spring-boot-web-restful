package com.saber.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/23
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("userName") String userName ,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if (!StringUtils.isEmpty(userName)&&"123456".equals(password)){
            session.setAttribute("loginUser",userName);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户账号或者面错误");
            return "login";
        }

    }
}
