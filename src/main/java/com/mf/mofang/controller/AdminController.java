package com.mf.mofang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mf.mofang.config.Login;
import com.mf.mofang.dao.UserDao;
import com.mf.mofang.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    @PostMapping("login")
    @ResponseBody
    @Cacheable
    public Map<String, Object> post(@RequestParam String username,
                                    @RequestParam String pwd) {

        Map<String, Object> map = new HashMap<>(4);
        try {
            UserModel userModel = userDao.selectOne(new QueryWrapper<UserModel>()
                    .lambda()
                    .eq(UserModel::getUsername, username)
            );

            if (pwd.equals(userModel.getPassword())) {
                map.put("token", "");
                map.put("code", 1);
                return map;
            }
        } catch (Exception e) {
//            e.printStackTrace();
            map.put("code", 0);

            return map;
        }
        map.put("code", 0);

        return map;
    }


//    @Login
    @GetMapping({"index", ""})
    public String index() {

        return "admin/index";
    }

//    @Login
    @GetMapping("userlist")
    public String user() {

        return "admin/userlist";
    }


}
