package com.yzm4.aop;

import org.springframework.stereotype.Component;

@Component
public class UserAop {

    public void add(String name) {
        int i = 1 / 0;
        System.out.println("执行 User.add 方法，参数=" + name);
    }

    public String edit(String name) {
        System.out.println("执行 User.edit 方法，参数=" + name);
        return "Hello" + name;
    }
}
