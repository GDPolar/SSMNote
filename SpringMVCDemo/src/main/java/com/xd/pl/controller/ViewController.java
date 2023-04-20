package com.xd.pl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @RequestMapping("test/view/tlv")
    public String thymeleafView() {
        // 默认创建的 View 类型为 ThymeleafView
        return "hello";
    }

    @RequestMapping("test/view/forward")
    public String forwardView() {
        // 转发视图 View 类型为 InternalResourceView
        return "forward:/test/view/tlv";
    }

    @GetMapping("test/view/redirect")
    // @RequestMapping(value = "test/view/redirect", method = RequestMethod.GET)
    public String redirectView() {
        // 重定向视图 View 类型为 RedirectView
        return "forward:/test/view/tlv";
    }

    @PutMapping("test/restful/put/{id}")
    // @RequestMapping(value = "test/restful/put/{id}", method = RequestMethod.PUT)
    public String testPut(@PathVariable Integer id) {
        System.out.println("------put" + id);
        return "hello";
    }



}
