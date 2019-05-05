package com.saber.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/21
 */
@Controller
public class HelloController {

//    @RequestMapping({"/","index.html"})
//    public String index(){
//        return "index";
//    }

//    @RequestMapping({"/","index.html"})
//    public Map<String,Object> index(Map<String,Object> map){
//        return map;
//    }

    @RequestMapping("/hello")
    public String hello(){
        return "你好";
    }

    @RequestMapping("/success")
    public Map<String,Object> success(Map<String,Object> map){
        map.put("hello","你好");
        map.put("hello2","你好啊");
        return map;
    }
}
