package com.mf.mofang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pt
 */
@Controller
@RequestMapping("")
public class IndexControoler {



    @RequestMapping("")
    public String get() {
        return "";
    }
}
