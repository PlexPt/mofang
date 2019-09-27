package com.mf.mofang.controller;

import com.mf.mofang.dao.FeedbackDao;
import com.mf.mofang.model.FeedbackModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pt
 */
@Controller
@Slf4j
@RequestMapping("")
public class IndexController {

    @Autowired
    FeedbackDao feedbackDao;

    @RequestMapping(value = {"/", "/index"})
    public String index() {

        return "index";
    }

    @RequestMapping(value = {"/box"})
    public String box() {
        return "box";
    }

    @RequestMapping(value = {"/space"})
    public String space() {

        return "space";
    }

    @RequestMapping(value = {"/detail/{id}"})
    public ModelAndView detail(@PathVariable("id") String id) {

        ModelAndView mv = new ModelAndView();

        String content = "<h1 style=\"font-family: 微软雅黑; background: 0px 0px rgb(247, 247, 247); border: 0px; margin: 0px; padding: 0px; vertical-align: middle; outline: 0px; font-size: 22px; line-height: 24px; color: rgb(34, 34, 34); display: inline-block; float: left; white-space: normal;\">\n" +
                "    <span style=\"-webkit-tap-highlight-color: transparent; background: 0px 0px; border: 0px; margin: 0px; padding: 0px; vertical-align: baseline; outline: 0px; display: inline-block;\">北大附属实验学校幼儿园&nbsp;</span>\n" +
                "</h1>\n" +
                "<p>\n" +
                "    <br/>\n" +
                "</p>\n" +
                "<p style=\"text-align: right;\">\n" +
                "    <a href=\"http://www.sczhmf.com:8000/index\" target=\"_self\">幼儿园设计-幼儿园装修-高端幼儿园装潢公司「稚慧魔方」<span class=\"qodef-delimiter\" style=\"-webkit-tap-highlight-color: transparent; background: 0px 0px; border: 0px; margin: 0px; padding: 0px; vertical-align: middle; outline: 0px; color: rgb(127, 127, 127); font-size: 15px; font-weight: 600; line-height: 24px; display: inline-block;\">&nbsp;&gt;&nbsp;</span><span class=\"qodef-current\" style=\"-webkit-tap-highlight-color: transparent; background: 0px 0px; border: 0px; margin: 0px; padding: 0px; vertical-align: middle; outline: 0px; color: rgb(127, 127, 127); font-size: 15px; font-weight: 600; line-height: 24px; display: inline-block;\">北大附属实验学校幼儿园</span></a>\n" +
                "</p>\n" +
                "<p style=\"text-align:center\">\n" +
                "    <span class=\"qodef-current\" style=\"-webkit-tap-highlight-color: transparent; background: 0px 0px; border: 0px; margin: 0px; padding: 0px; vertical-align: middle; outline: 0px; color: rgb(127, 127, 127); font-size: 15px; font-weight: 600; line-height: 24px; display: inline-block;\"><img src=\"http://static.hkdesign.com.cn/wp-content/uploads/2018/12/chifeng001.jpg\" alt=\"å\u008C\u0097å¤§é\u0099\u0084å±\u009Eå®\u009Eéª\u008Cå\u00AD¦æ&nbsp;¡å¹¼å\u0084¿å\u009B\u00AD\"/></span>\n" +
                "</p>\n" +
                "<p style=\"text-align:center\">\n" +
                "    <img src=\"http://static.hkdesign.com.cn/wp-content/uploads/2018/12/chifeng002.jpg\" alt=\"chifeng002\"/>\n" +
                "</p>\n" +
                "<p style=\"text-align:center\">\n" +
                "    <img src=\"http://static.hkdesign.com.cn/wp-content/uploads/2018/12/chifeng002.jpg\" alt=\"chifeng002\"/>\n" +
                "</p>\n" +
                "<p style=\"text-align:center\">\n" +
                "    <img src=\"http://static.hkdesign.com.cn/wp-content/uploads/2018/12/chifeng003.jpg\" alt=\"chifeng003\"/>\n" +
                "</p>\n" +
                "<p></p><br/>\n" +
                "<p></p>\n" +
                "<h2 style=\"background-image: initial; background-position: 0px 0px; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial; border: 0px; margin: 0px; padding: 0px; vertical-align: baseline; outline: 0px; font-size: 34px; line-height: 1.284em; color: rgb(32, 32, 32); text-align: center;\">\n" +
                "    北大附属实验学校幼儿园\n" +
                "</h2>\n" +
                "<p style=\"background-image: initial; background-position: 0px 0px; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial; border: 0px; margin-top: 10px; margin-bottom: 10px; padding: 0px; vertical-align: baseline; outline: 0px; text-align: center;\">\n" +
                "    项目名称：赤峰北大附属实验学校幼儿园&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style=\"color: rgb(221, 51, 51); font-family: Raleway, sans-serif; font-size: 15px; font-weight: 700;\">Date</span>\n" +
                "</p>\n" +
                "<p style=\"background-image: initial; background-position: 0px 0px; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial; border: 0px; margin-top: 10px; margin-bottom: 10px; padding: 0px; vertical-align: baseline; outline: 0px; text-align: center;\">\n" +
                "    面积：3200㎡&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2018年12月3日\n" +
                "</p>\n" +
                "<p style=\"background-image: initial; background-position: 0px 0px; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial; border: 0px; margin-top: 10px; margin-bottom: 10px; padding: 0px; vertical-align: baseline; outline: 0px; text-align: center;\">\n" +
                "    风格：简约现代&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<span style=\"color: rgb(221, 51, 51); font-family: Raleway, sans-serif; font-size: 15px; font-weight: 700;\">Category</span>\n" +
                "</p>\n" +
                "<p style=\"background-image: initial; background-position: 0px 0px; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial; border: 0px; margin-top: 10px; margin-bottom: 10px; padding: 0px; vertical-align: baseline; outline: 0px; text-align: center;\">\n" +
                "    时间：2018年6月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;All, Business\n" +
                "</p>";


        mv.addObject("content", content);

        mv.setViewName("detail");
        return mv;
    }


    @PostMapping("contact")
    @ResponseBody
    public String contact(FeedbackModel model) {

        //留下联系方式
        if (StringUtils.isBlank(model.getName()) ||
                StringUtils.isBlank(model.getMobile())) {
            return "error";
        }

        feedbackDao.insert(model);
        return "ok";
    }


}
