package com.mf.mofang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pt
 */
@Controller
@Slf4j
@RequestMapping("")
public class VueController {


    @RequestMapping("vue")
    public String vue(ModelMap map) {

        map.put("title", "我少时诵诗书所所所所所所所所所所所所所所");
        return "vuedemo";
    }
}
