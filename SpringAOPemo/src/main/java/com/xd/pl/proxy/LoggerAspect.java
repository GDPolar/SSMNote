package com.xd.pl.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect // 通过 @Aspect 注解将当前组件标识为切面
@Component
public class LoggerAspect {

    // 定义公共切入点
    @Pointcut("execution(* com.xd.pl.proxy.CalculatorImpl.*(..))")
    public void pointCut1() {}

    // @Before 标识前置通知，在目标方法执行前执行，通过切入点表达式指定方法
    // @Before("execution(public int com.xd.pl.proxy.CalculatorImpl.add(int ,int ))")
    // 第一个 * 表示任意访问修饰符和返回类型，... 表示任意参数列表
    @Before("execution(* com.xd.pl.proxy.CalculatorImpl.*(..))")
    // joinPoint 获取切入点相关信息
    public void beforeAdviceMethod1(JoinPoint joinPoint) {
        // 获取方法相关声明信息
        Signature signature = joinPoint.getSignature();
        // 获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println(signature.getName() + " 的参数" + Arrays.toString(args));
    }

    // @After 在目标方法的 finally 执行
    // 使用公共切入点
    @After("pointCut1()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName() + " finally 完成");
    }

    // @AfterReturning 返回值返回后执行，returning = "res" 接收返回值
    @AfterReturning(value = "pointCut1()", returning = "res")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object res) {
        Signature signature = joinPoint.getSignature();
        // 获取返回的结果
        System.out.println(signature.getName() + " 已返回" + res);
    }


    // 多个同类型的切面用 @Order 设置优先级
    // @AfterThrowing 异常通知，在 catch 中执行，throwing = "ex" 接收抛出的异常
    @AfterThrowing(value = "pointCut1()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Exception ex) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName() + " 发生异常" + ex.toString());
    }

    // @Around 环绕通知，自己处理各个切入点
    @Around("pointCut1()")
    public Object aroundAdviceMethod(ProceedingJoinPoint pjp) {
        Object res = null;
        try {
            // 前置通知位置
            res = pjp.proceed();
            // 返回通知位置
        } catch (Throwable e) {
            // 异常通知位置
            e.printStackTrace();
        } finally {
            // 后置通知位置
        }
        return res;
    }
}
