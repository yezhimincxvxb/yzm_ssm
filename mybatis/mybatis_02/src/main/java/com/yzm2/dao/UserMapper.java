package com.yzm2.dao;

import com.yzm2.entity.User;
import com.yzm2.plugin.Page;
import com.yzm2.plugin.UserPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> listUser();

    // 物理分页
    List<User> listUserByLimit(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

    // 分页插件
    List<User> page(UserPage userPage);

    List<User> page2(Page<User> page);

}
