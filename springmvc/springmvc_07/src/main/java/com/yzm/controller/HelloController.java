package com.yzm.controller;

import com.yzm.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("testException")
    public String testException(int a) throws MyException {
        System.out.println("testException。。。");
        try {
            int i = 10 / a;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("维护中。。。");
        }
        return "success";
    }

}
