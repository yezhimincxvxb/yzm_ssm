package com.yzm.service;

import com.yzm.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("执行 UserService.add 方法");
        userDao.add();
    }

}
