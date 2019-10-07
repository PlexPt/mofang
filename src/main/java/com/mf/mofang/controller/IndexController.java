package com.mf.mofang.controller;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mf.mofang.dao.FeedbackDao;
import com.mf.mofang.dao.ShowcaseDao;
import com.mf.mofang.model.FeedbackModel;
import com.mf.mofang.model.ShowcaseModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pt
 */
@Controller
@Slf4j
@RequestMapping("")
public class IndexController {

    @Autowired
    FeedbackDao feedbackDao;
    @Autowired
    ShowcaseDao showcaseDao;


    @RequestMapping(value = {"/", "/index"})
    public String index() {

        return "index";
    }

    @RequestMapping(value = {"/box"})
    public ModelAndView box() {
        ModelAndView mv = new ModelAndView();
        // 查询案例信息, 初始化页面查询第一页
        Page<ShowcaseModel> page = new Page<>(1,8);
        IPage<ShowcaseModel> showcaseModelIPage = showcaseDao.selectPage(page, new QueryWrapper<ShowcaseModel>());

        mv.setViewName("box");
        mv.addObject("casePage", showcaseModelIPage);
        List<ShowcaseModel> records = showcaseModelIPage.getRecords();

        mv.addObject("caseList", records);

        return mv;
    }

    @RequestMapping(value = {"/space"})
    public ModelAndView space() {


        ModelAndView mv = new ModelAndView();
        // 查询案例信息, 初始化页面查询第一页
        Page<ShowcaseModel> page = new Page<>(1,8);
        IPage<ShowcaseModel> showcaseModelIPage = showcaseDao.selectPage(page, new QueryWrapper<ShowcaseModel>());

        mv.setViewName("space");
        mv.addObject("casePage", showcaseModelIPage);
        List<ShowcaseModel> records = showcaseModelIPage.getRecords();

        mv.addObject("caseList", records);

        return mv;
    }




    @PostMapping("/contact")
    @ResponseBody
    public String contact(FeedbackModel model) {
        Map<String, Object> result = new HashMap<>(3);

        //留下联系方式
        if (StringUtils.isBlank(model.getEmail()) ||
                StringUtils.isBlank(model.getMobile())) {
            result.put("code", "3");
            result.put("msg", "联系方式必填！");
        } else {
            try {
                feedbackDao.insert(model);
                result.put("code", "200");
                result.put("msg", "提交成功");
            } catch (Exception e) {
                result.put("code", "3");
                result.put("msg", "网络异常！");
                result.put("data", e.getMessage());
            }
        }
        return new JSONObject(result).toString();
    }


}
