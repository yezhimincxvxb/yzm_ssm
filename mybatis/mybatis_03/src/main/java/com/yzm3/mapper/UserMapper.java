package com.yzm3.mapper;

import com.yzm3.entity.User;
import com.yzm3.entity.UserMore;
import com.yzm3.entity.UserOne;

import java.util.List;

public interface UserMapper {

    List<User> listUser();

    List<UserOne> listOneToOne();

    List<UserOne> listOneToOne2();

    List<UserMore> listOneToMore();

    List<UserMore> listOneToMore2();

}
