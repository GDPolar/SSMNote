package com.xd.pl.proxy;

public class CalculatorStaticProxy implements Calculator {

    // 利用静态代理将核心业务代码与其他代码分开
    private CalculatorImpl target;

    public CalculatorStaticProxy(CalculatorImpl target) {
        this.target = target;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("method : add, a = " + a + ", b = " + b);
        return target.add(a, b);
    }

    @Override
    public int div(int a, int b) {
        System.out.println("method : div, a = " + a + ", b = " + b);
        return target.div(a, b);
    }

}
