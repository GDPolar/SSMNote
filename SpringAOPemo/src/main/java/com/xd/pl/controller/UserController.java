package com.xd.pl.controller;

import com.xd.pl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    // @Autowired 默认是根据类型进行注入的，需要限定一个候选者，否则将抛出异常
    // @Qualifier 限定描述符根据名字注入
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    public void saveUser() {
        userService.saveUser();
    }
}
