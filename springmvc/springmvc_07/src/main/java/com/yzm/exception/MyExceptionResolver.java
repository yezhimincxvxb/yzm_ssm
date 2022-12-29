package com.yzm.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常捕获并处理
 */
@Component
public class MyExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        MyException myException;
        if (e instanceof MyException) {
            myException = (MyException) e;
        } else {
            myException = new MyException("维护中。。。");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", myException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
