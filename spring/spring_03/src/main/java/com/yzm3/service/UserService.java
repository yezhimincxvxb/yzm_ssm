package com.yzm3.service;

import com.yzm3.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource(name = "userDaoImpl")
    private UserDao userDao;

    @Autowired
    @Qualifier(value = "userDaoImpl2")
    private UserDao userDao2;

    public void add() {
        userDao.add();
        System.out.println("执行 UserService.add 方法");
    }

    public void add2() {
        userDao2.add();
        System.out.println("执行 UserService.add 方法");
    }
}
