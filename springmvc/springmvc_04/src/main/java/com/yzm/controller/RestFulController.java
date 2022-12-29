package com.yzm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {

    @RequestMapping(value = "/add/{a}/{b}")
    public String add(@PathVariable int a, @PathVariable String b, Model model) {
        model.addAttribute("msg", a + "=" + b);
        return "test";
    }

    @GetMapping("/user")
    public String getUser(String name, Model model) {
        model.addAttribute("msg", name + "：查询");
        return "test";
    }

    @PostMapping("/user")
    public String addUser(String name, Model model) {
        model.addAttribute("msg", name + "：添加");
        return "test";
    }

    @PutMapping("/user")
    public String editUser(String name, Model model) {
        model.addAttribute("msg", name + "：编辑");
        return "test";
    }

    @DeleteMapping("/user")
    public String delUser(String name, Model model) {
        model.addAttribute("msg", name + "：删除");
        return "test";
    }
}
