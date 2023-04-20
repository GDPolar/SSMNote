package com.xd.pl.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// 对当前 ioc 的所有 bean 起作用
public class MyBeanPostProcessor implements BeanPostProcessor {
    // 在 bean 的生命周期的 initMethod 前执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("step2.5：MyBeanPostProcessor 的 postProcessBeforeInitialization 方法");
        // 将操作完成后的 bean 返回
        return bean;
    }

    // 在 bean 的生命周期的 initMethod 后执行
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("step3.5：MyBeanPostProcessor 的 postProcessAfterInitialization 方法");
        // 将操作完成后的 bean 返回
        return bean;
    }
}
