package com.yzm.controller;

import com.yzm.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Map;

@Controller
public class ParamController {

    @GetMapping("/param")
    public String param() {
        return "form1";
    }

    @PostMapping("/receiver")
    @ResponseBody
    public void receiver(@RequestParam(value = "username") String username,
                              @RequestParam(value = "hobby") List<String> hobbyList,
                              @RequestParam Map<String, Object> paramMap,
                              @RequestHeader Map<String, Object> headerMap) {
        System.out.println("username = " + username);
        System.out.println("hobbyList = " + hobbyList);
        System.out.println("paramMap = " + paramMap);
        System.out.println("headerMap = " + headerMap);
    }

    @PostMapping("/receiver2")
    public void receiver2(@RequestBody User user) {
        System.out.println("user = " + user);
    }

    @PostMapping("/receiver3")
    public void receiver3(@CookieValue Cookie cookie) {
        System.out.println("cookie = " + cookie);
    }

}
