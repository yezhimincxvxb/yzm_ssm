package com.yzm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ForwardController {

    @GetMapping("/test1")
    public String test() {
        return "/fr/testa";
    }

    @PostMapping("/test2")
    public String test2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("password", request.getParameter("password"));
//        return "/fr/testb"; // 直接跳转的jsp页面
//        return "forward:/testb";

        // 重定向无法共享request域数据，可以使用redirectAttributes实现数据传递
        redirectAttributes.addAttribute("name", request.getParameter("username"));
        return "redirect:/testb";
    }

    @PostMapping("/testb")
    public String test3(HttpServletRequest request) {
        System.out.println("转发");
        return "/fr/testb";
    }

    @GetMapping("/testb")
    public String test4(HttpServletRequest request) {
        System.out.println("重定向");
        request.setAttribute("username", request.getParameter("name"));
        return "/fr/testb";
    }
}
