package com.mf.mofang.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.mf.mofang.dao.ShowcaseDao;
import com.mf.mofang.dao.UserDao;
import com.mf.mofang.model.UserModel;

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
    @RequestMapping(value = "/case")
    public ModelAndView toDemo(ModelAndView mv) {
        log.info("====>>跳转case页面");
//        List<CaseModel> caseList = caseDao.selectList(new QueryWrapper<>());
        List<UserModel> userModelList = userDao.selectList(new QueryWrapper<>());

        log.info(new Gson().toJson(userModelList));

        mv.addObject("title", "案例");
        mv.addObject("content", "  <h1>抱歉，您访问的案例不存在或已被删除</h1>");
//        mv.addObject("caseList", caseList);

        //case.ftl
        mv.setViewName("case");

        return mv;
    }

}
