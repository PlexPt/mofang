package com.mf.mofang.controller;

import com.mf.mofang.dao.FeedbackDao;
import com.mf.mofang.model.FeedbackModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseBody;

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
