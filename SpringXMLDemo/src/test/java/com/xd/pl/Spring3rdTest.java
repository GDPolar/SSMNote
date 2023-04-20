package com.xd.pl;

import com.xd.pl.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring3rdTest {
    @Test
    public void test1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext3.xml");
        UserController userController = ioc.getBean("userController", UserController.class);
        // controller 调用 service，service 使用 dao
        userController.saveUser();

    }
}
