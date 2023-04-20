package com.xd.pl.controller;

import com.xd.pl.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@RestController = @Controller + 类中所有的方法加上 @ResponseBody
@Controller
public class AjaxController {

    @RequestMapping("/to/test/ajax")
    public String toAjaxTestHtml() {
        return "test";
    }

    @RequestMapping("/test/ajax")
    // @RequestBody 获取 json 格式的请求参数
    public void ajaxTest(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println(requestBody);
        System.out.println(id);
        response.getWriter().write("hello,axios");
    }

    @RequestMapping("/test/ajax2")
    // @ResponseBody 将方法的返回值作为响应报文的响应体传回
    @ResponseBody
    // @RequestBody 获取 json 格式的请求参数，导入 jackson 依赖解析，设置对象接收
    public String requestBodyTest(Integer id, @RequestBody User user) {
        System.out.println(user);
        System.out.println(id);
        return "hello from @ResponseBody";
    }

    @RequestMapping("/test/ajax3")
    // @ResponseBody 将返回的对象转化为 json 格式传回
    @ResponseBody
    public User responseBodyJavaTest(Integer id, @RequestBody User user) {
        System.out.println(user);
        System.out.println(id);
        return new User("zs", "aaa");
    }
}
