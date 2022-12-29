package com.yzm3.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public void add() {
        System.out.println("执行 UserDaoImpl.add 方法");
    }
}
