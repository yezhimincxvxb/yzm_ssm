package com.yzm.controller;

import com.alibaba.fastjson.JSON;
import com.yzm.entity.User;
import com.yzm.utils.JSONUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;

@RestController
public class HelloController {

    @GetMapping("/getUser")
    public String getUser() {
        User build = User.builder().userid(10001).username("张三").password("zhangsan").createDate(new Date()).build();
        return JSONUtils.toJsonString(build);
    }

    @GetMapping("/listUser")
    public String listUser() {
        User build = User.builder().userid(10001).username("张三").password("zhangsan").createDate(new Date()).build();
        User build2 = User.builder().userid(10002).username("李四").password("lisi").createDate(new Date()).build();
        User build3 = User.builder().userid(10003).username("王五").password("wangwu").createDate(new Date()).build();
        return JSONUtils.toJsonString(Arrays.asList(build, build2, build3));
    }

    @GetMapping("/listUser2")
    public String listUser2() {
        User build = User.builder().userid(10001).username("张三").password("zhangsan").createDate(new Date()).build();
        User build2 = User.builder().userid(10002).username("李四").password("lisi").createDate(new Date()).build();
        User build3 = User.builder().userid(10003).username("王五").password("wangwu").createDate(new Date()).build();
        return JSON.toJSONString(Arrays.asList(build, build2, build3));
    }

}
