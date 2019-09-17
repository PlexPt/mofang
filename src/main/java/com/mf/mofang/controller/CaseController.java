package com.mf.mofang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pt
 */
@Slf4j
@Controller
public class CaseController {


    /**
     * 跳转case案例页面
     */
    @RequestMapping(value = "/case")
    public ModelAndView toDemo(ModelAndView mv) {
        log.info("====>>跳转case页面");
        mv.addObject("title", "案例");
        mv.addObject("content", "  <h1>抱歉，您访问的案例不存在或已被删除</h1>");
        mv.setViewName("case");
        return mv;
    }

}
