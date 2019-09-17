package com.mf.mofang.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.mf.mofang.dao.ShowcaseDao;
import com.mf.mofang.dao.UserDao;
import com.mf.mofang.model.ShowcaseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pt
 */
@Slf4j
@Controller
public class ShowcaseController {

    @Autowired
    ShowcaseDao showcaseDao;
    @Autowired
    UserDao userDao;


    /**
     * 跳转case案例页面
     */
    @RequestMapping(value = "/showcase")
    public ModelAndView toDemo(ModelAndView mv) {
        log.info("====>>跳转案例页面");
        List<ShowcaseModel> caseList = showcaseDao.selectList(new QueryWrapper<>());

        log.info(new Gson().toJson(caseList));

        mv.addObject("title", "案例");
        mv.addObject("content", "  <h1>下面是案例列表</h1>");
        mv.addObject("caseList", caseList);

        //case.ftl
        mv.setViewName("showcase");

        return mv;
    }

}
