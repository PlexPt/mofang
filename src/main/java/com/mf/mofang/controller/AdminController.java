package com.mf.mofang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mf.mofang.dao.UserDao;
import com.mf.mofang.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 后台
 *
 * @author pt
 */
@Controller
@Slf4j
@RequestMapping("admin")
public class AdminController {

    @Autowired
    UserDao userDao;

    @GetMapping("login")
    public String login() {

        return "admin/login";
    }


    /**
     * 留言管理 首页
     *
     * @return
     */
    //    @Login
    @GetMapping({"index"})
    public String index() {

        return "admin/index";
    }

    /**
     * 用户管理
     *
     * @return
     */
    //    @Login
    @GetMapping("userlist")
    public String user() {

        return "admin/userlist";
    }

    /**
     * 案例
     *
     * @return
     */
    //    @Login
    @GetMapping("show")
    public String show() {

        return "admin/show";
    }

    /**
     * 轮播
     *
     * @return
     */
    //    @Login
    @GetMapping("banner")
    public String banner() {

        return "admin/banner";
    }

    /**
     * about
     *
     * @return
     */
    //    @Login
    @GetMapping("about")
    public String about() {

        return "admin/about";
    }


}
