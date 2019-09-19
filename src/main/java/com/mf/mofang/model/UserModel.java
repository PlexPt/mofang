package com.mf.mofang.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 用户
 */
@Data
@TableName("user")
public class UserModel {

    @TableId
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 用户名 登录用
     */
    private String username;

    private String password;

    // 以下备用
    private String status;
    private String remark;
    private String remark2;
    private String remark3;
    private String remark4;


}
