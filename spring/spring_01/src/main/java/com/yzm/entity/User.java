package com.yzm.entity;

import lombok.Data;

@Data
public class User {

    public User() {
        System.out.println("调用 User 构造器创建实例");
    }

    public void hello() {
        System.out.println("调用 User 的 hello 方法");
    }

}
