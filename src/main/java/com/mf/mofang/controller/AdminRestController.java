package com.mf.mofang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mf.mofang.config.JwtUtil;
import com.mf.mofang.dao.FeedbackDao;
import com.mf.mofang.dao.UserDao;
import com.mf.mofang.model.FeedbackModel;
import com.mf.mofang.model.UserModel;
import com.mf.mofang.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台
 *
 * @author pt
 */
@RestController
@Slf4j
@RequestMapping("admin")
public class AdminRestController {

    @Autowired
    UserDao userDao;
    @Autowired
    FeedbackDao feedbackDao;


    @PostMapping("login")
    public Map<String, Object> post(@RequestParam String username,
                                    @RequestParam String pwd) {

        Map<String, Object> map = new HashMap<>(4);
        try {
            UserModel userModel = userDao.selectOne(new QueryWrapper<UserModel>()
                    .lambda()
                    .eq(UserModel::getUsername, username)
            );


            if (pwd.equals(userModel.getPassword())) {
                map.put("token", JwtUtil.encode(username));
                map.put("code", 0);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 500);

            return map;
        }
        map.put("code", 500);

        return map;
    }


    @PostMapping("user/add")
    public R add(@RequestBody UserModel user) {
        try {
            userDao.insert(user);

            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();

            return R.error(e.getMessage());
        }
    }


    @GetMapping("user/list")
    public R userlist() {

        try {
            List<UserModel> userModels = userDao.selectList(new QueryWrapper<>());

            return R.ok().put("data", userModels);
        } catch (Exception e) {
            e.printStackTrace();

            return R.error(e.getMessage());
        }
    }


    @PostMapping("user/update")
    public R userupdate(@RequestBody UserModel user) {

        try {
            userDao.updateById(user);

            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();

            return R.error(e.getMessage());
        }
    }

    @PostMapping("user/delete")
    public R userdelete(@RequestParam Integer id) {

        try {
            userDao.deleteById(id);

            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();

            return R.error(e.getMessage());
        }
    }

    /**
     * 客户留言list
     */
    @GetMapping("feedback/list")
    public R feedbacklist() {

        try {
            List<FeedbackModel> list = feedbackDao.selectList(new QueryWrapper<>());

            return R.ok().put("data", list);
        } catch (Exception e) {
            e.printStackTrace();

            return R.error(e.getMessage());
        }
    }

    /**
     * 客户留言
     */
    @PostMapping("feedback/add")
    public R feedbackadd(@RequestBody FeedbackModel feedbackModel) {
        try {
            feedbackDao.insert(feedbackModel);

            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();

            return R.error(e.getMessage());
        }
    }

}
