package com.yzm4.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class PersonProxy {

    /**
     * 前置通知
     */
    @Before("execution(* com.yzm4.aop.UserAop.edit(..))")
    public void before() {
        System.out.println("前置通知... Person");
    }

}
