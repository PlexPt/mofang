package com.mf.mofang.controller;


import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.mf.mofang.dao.ShowcaseDao;
import com.mf.mofang.dao.UserDao;
import com.mf.mofang.model.ShowcaseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = {"/caselist"})
    @ResponseBody
    public String caselist(Page<ShowcaseModel> page) {
        // 查询案例信息, 初始化页面查询第一页

        if (page.getCurrent() == 0) {
            page.setCurrent(1L);
        }

        page.setSize(8);
        Map<String, Object> result = new HashMap<>(3);
        try {
            IPage<ShowcaseModel> showcaseModelIPage = showcaseDao.selectPage(page, new QueryWrapper<ShowcaseModel>());

            List<ShowcaseModel> records = showcaseModelIPage.getRecords();

            result.put("code", "200");
            result.put("msg", "查询成功");
            result.put("data", records);
        } catch (Exception e) {
            result.put("code", "3");
            result.put("msg", "网络异常！");
            result.put("data", e.getMessage());
        }
        return new JSONObject(result).toString();

    }

    @RequestMapping(value = {"/detail/{id}"})
    public ModelAndView detail(@PathVariable("id") String id) {

        ModelAndView mv = new ModelAndView();

        ShowcaseModel showcaseModel = showcaseDao.selectOne(new QueryWrapper<ShowcaseModel>().lambda().eq(ShowcaseModel::getId, id));

        mv.addObject("showcaseModel", showcaseModel);

        mv.setViewName("detail");
        return mv;
    }

}
