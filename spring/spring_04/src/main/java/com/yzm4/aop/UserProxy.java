package com.yzm4.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(100)
public class UserProxy {

    @Pointcut("execution(* com.yzm4.aop.UserAop.add(..))")
    public void addPoint() {

    }

    @Pointcut("execution(* com.yzm4.aop.UserAop.edit(..))")
    public void editPoint() {

    }

    /**
     * 前置通知
     */
//    @Before("execution(* com.yzm4.aop.UserAop.add(..))")
    @Before(value = "editPoint()")
    public void before() {
        System.out.println("前置通知... User");
    }

    /**
     * 后置通知
     */
    @After(value = "addPoint()")
    public void after() {
        System.out.println("后置通知...");
    }

    /**
     * 最终通知/返回值通知
     */
//    @AfterReturning(value = "addPoint()", returning = "returnVal")
    @AfterReturning(value = "editPoint()", returning = "returnVal")
    public void afterReturning(Object returnVal) {
        System.out.println("最终通知..." + returnVal);
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "addPoint()", throwing = "e")
    public void afterThrowing(Throwable e) {
        System.out.println("异常通知..." + e);
    }

    /**
     * 环绕通知
     */
//    @Around(value = "addPoint()")
    @Around(value = "editPoint()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前....");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知后...." + proceed);
        return proceed;
    }
}
