package com.xd.pl.controller;

import com.xd.pl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    public void saveUser() {
        userService.saveUser();
    }
}
