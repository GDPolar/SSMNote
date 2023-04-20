package com.xd.pl;

import com.xd.pl.pojo.Life;
import com.xd.pl.pojo.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring2ndTest {
    @Test
    public void test1() {
        // 获取 ioc 容器时就会执行作用域为单例的 bean 的实例化、注入、初始化
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext2.xml");
        // 获取具体 bean 时会执行作用域为多例的该 bean 的实例化、注入、初始化
        // ioc 关闭，调用销毁方法
        ioc.close();
    }

    @Test
    public void test2() {
        // 获取 ioc 容器时就会执行作用域为单例的 bean 的实例化、注入、初始化
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext2.xml");
        // @see getObjectFromFactoryBean 通过 factory 调用 getObject() 获取 bean
        System.out.println(ioc.getBean(Teacher.class));
    }
}
