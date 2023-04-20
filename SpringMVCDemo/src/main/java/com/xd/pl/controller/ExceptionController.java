package com.xd.pl.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


// 标识为处理全局事务的组件
@ControllerAdvice
public class ExceptionController {

    // 配置处理的异常类型
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }
}
