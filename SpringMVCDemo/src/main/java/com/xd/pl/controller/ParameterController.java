package com.xd.pl.controller;

import com.xd.pl.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParameterController {

    // 通过原生 servlet API 获取参数
    @RequestMapping("/paramDemo/s")
    public String getParameterByServletAPI(HttpServletRequest request) {
        // 第一次调用 request.getSession() 时创建 session
        // 并在响应头中设置 Set-Cookie
        request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        return "hello";
    }

    @RequestMapping("/paramDemo/p")
    // 形参位置将形参名与请求参数一致，则可直接获取
    public String getParameterByAnno(
            // 亦可用 @RequestParam 注解设置形参对应的请求参数
            @RequestParam(value = "name", required = false, defaultValue = "def") String username,
            String password,
            // @RequestHeader 获取请求头中的参数
            @RequestHeader("referer") String referer,
            // @CookieValue 获取 cookie
            @CookieValue("JSESSIONID") String cookie) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(referer);
        System.out.println(cookie);
        return "hello";
    }

    @RequestMapping("/paramDemo/pojo")
    // 保证 POJO 的属性名和传入的请求参数一致，即可用实体类获取
    public String getParameterByPOJO(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "hello";
    }
}
