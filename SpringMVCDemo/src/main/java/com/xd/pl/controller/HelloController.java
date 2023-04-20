package com.xd.pl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hi")
public class HelloController {


    // 默认的参数 value 设置匹配的路径
    // 该方法匹配的请求路径为 /hi/hello 或 /hi/nihao
    // method 设置匹配请求方式
    // 若请求类型匹配失败，报错 405
    // params 限制传入的参数（不常用）
    // 若请求参数不满足限制，报错 400
    // headers 限制请求头
    // 若请求头不满足限制，报错 404
    @RequestMapping(
            value = {"/hello", "/nihao"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"username", "!password", "gender=男", "age!=18"},
            headers = {"referer"}
    )
    public String hello() {
        return "hello";
    }

    // 支持 ant 风格：
    //  ?	匹配任何单字符
    //  *	匹配 0 或者任意数量的字符
    //  **	匹配 0 或者更多的目录
    @RequestMapping("/?/*23//**")
    public String ant() {
        return "hello";
    }

    // 获取路径中的占位符
    @RequestMapping("/get/{id}")
    // 通过 @PathVariable 获取
    public String placeholder(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "hello";
    }





}
