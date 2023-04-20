package com.xd;

import com.xd.pl.proxy.Calculator;
import com.xd.pl.proxy.CalculatorImpl;
import com.xd.pl.proxy.CalculatorStaticProxy;
import com.xd.pl.proxy.ProxyFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void test1() {
        // 静态代理，一个代理对象代理一个类
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        System.out.println(proxy.add(1, 2));

        // jdk 动态代理，要求被代理对象必须有接口，生成的代理类和目标类实现相同的接口
        // 位于 com.sun.proxy 下，类名为 $proxy4567 等
        // 还有一种代理为 cglib 代理，不一定要求被代理对象要有接口，生成的代理类继承目标类与目标类位于同一位置
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        // 由于代理类会实现与代理对象相同的接口，因此返回的结果向上转型为接口类型
        Calculator proxy1 = (Calculator) proxyFactory.getProxy();
        proxy1.add(1 , 2);
        proxy1.div(1, 0);
    }

    @Test
    public void test2() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过接口的 class 对象获取，而无法通过 impl 的 class 对象获取
        Calculator bean = ioc.getBean(Calculator.class);
        System.out.println(bean.add(1, 2));
        System.out.println(bean.div(1, 0));
    }
}
