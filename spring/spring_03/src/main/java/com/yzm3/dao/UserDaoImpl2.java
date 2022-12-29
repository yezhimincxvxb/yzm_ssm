package com.yzm3.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl2 implements UserDao{

    @Override
    public void add() {
        System.out.println("执行 UserDaoImpl2.add 方法");
    }
}
