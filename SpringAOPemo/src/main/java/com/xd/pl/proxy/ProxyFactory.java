package com.xd.pl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private final Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        // 获取目标对象实现的所有接口
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h = (proxy, method, args) -> {
            Object result = null;
            try {
                System.out.println("method: " + method.getName() + ", args: " + Arrays.toString(args));
                // method.invoke() 传入对象参数和参数，执行对象参数的方法
                result = method.invoke(target, args);
                System.out.println("method: " + method.getName() + ", result: " + result);
            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("method: " + method.getName() + ", exception: " + e);
            }
            finally {
                System.out.println("method: " + method.getName() + " have been finished");
            }
            return result;
        };
        return Proxy.newProxyInstance(classLoader, interfaces, h);
    }
}
