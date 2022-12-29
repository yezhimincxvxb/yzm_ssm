package com.yzm4.service;

public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        System.out.println("执行 UserServiceImpl.login 方法");
        System.out.println("用户名=" + username + ",密码=" + password);
    }
}
