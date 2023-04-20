package com.xd;

import com.xd.pl.controller.UserController;
import com.xd.pl.dao.UserDao;
import com.xd.pl.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public class SpringTest {
    @Test
    public void test1() {
        /*
            后三个注解功能上和第一个注解一样，都用于实现自动注入
                @Component 普通组件
                @Controller 控制层
                @Service 业务层
                @Repository 持久层
            通过注解扫描的 bean 的 id 默认为类名的小驼峰
        */
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = ioc.getBean(UserController.class);
        System.out.println(userController);

        // @Autowired 注解，实现自动装配，默认通过 byType 实现
        // 可用 @Qualifier("beanId") 通过 byName 指定 bean
        // 可以标识在成员变量处、setter 上、为当前成员变量构造的有参构造
        userController.saveUser();
        System.out.println(ioc.getBean(UserService.class));
        System.out.println(ioc.getBean(UserDao.class));
    }
}
