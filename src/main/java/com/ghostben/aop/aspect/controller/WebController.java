package com.ghostben.aop.aspect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : ben.zhang.b.q
 * @date : 2018/10/9 15:03
 * package   : com.ghostben.aop.aspect.controller
 * description : 获取前端输入名字，后台返回Hello
 **/
@Controller
public class WebController {

    @GetMapping(value = "say")
    @ResponseBody
    public String sayHello(String name){

        return "Hello;  " + name;
    }
}
