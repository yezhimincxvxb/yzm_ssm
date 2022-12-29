package com.yzm.dao;

import com.yzm.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserDao {

    List<User> listUser();

    User getById(Integer id);

    int addUser(User user);

    int editUser(User user);

    int delUser(Integer id);

    @Select("select * from `user`")
    List<User> listUser2();

    @Select("select * from `user` where id=#{id}")
    User getById2(Integer id);

    @Insert("insert into `user`(username, password, gender) values (#{username}, #{password}, #{gender}")
    int addUser2(User user);

    @Update("update `user` set username = #{username} where id = #{id}")
    int editUser2(User user);

    @Delete("delete from `user` where id=#{id}")
    int delUser2(Integer id);

    List<User> listUserByIndex(Integer id, Integer gender, Integer state);

    // @Param
    List<User> listUserByParam(@Param("gender") Integer gender, @Param("state") Integer state);

    // Map传参
    List<User> listUserByMap(Map<String, Object> map);

}
