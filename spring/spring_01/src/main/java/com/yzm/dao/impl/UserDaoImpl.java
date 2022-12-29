package com.yzm.dao.impl;

import com.yzm.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("执行 UserDao.add 方法");
    }
}
