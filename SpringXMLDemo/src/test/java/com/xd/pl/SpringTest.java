package com.xd.pl;

import com.xd.pl.pojo.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void test1() {
        // 获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过 bean 的 id 调用对应类的无参构造
        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
        HelloWorld helloworld2 = (HelloWorld) ioc.getBean("helloworld");
        System.out.println(helloworld2 == helloworld); // true
        helloworld.sayHi();
    }

    @Test
    public void test2() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 当某个类只有一个对象时，通过类名获取对象
        Student stu1 = ioc.getBean(Student.class);
        // class Minor implements Person
        // class Student extends Minor
        // 接口只有一个实现类时，通过接口获取对象
        Person person = ioc.getBean(Person.class);
        Minor minor = ioc.getBean(Minor.class);
        System.out.println(person);
        System.out.println(person == stu1); // true
        System.out.println(person == minor); // true
        // 接口有多个实现类时，不能直接通过接口获取，可通过 id 和 接口获取
        // ioc.getBean(Car.class); // Error !!!
        Car smallCar = ioc.getBean("smallCar", Car.class); // OK
        System.out.println(smallCar);
    }

    @Test
    public void test3() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person stu1 = ioc.getBean("stu1", Person.class);
        System.out.println(stu1);
        Minor stu2 = ioc.getBean("stu2", Minor.class);
        System.out.println(stu2);

        Taxi taxi = ioc.getBean("taxi", Taxi.class);
        System.out.println(taxi);
    }
}
