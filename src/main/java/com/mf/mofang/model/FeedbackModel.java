package com.mf.mofang.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2019-09-17 15:13
 */
@Data
@TableName("feedback")
public class FeedbackModel {

    @TableId
    Long id;
    /**
     * 名字
     */
    private String name;

    private String email;

    private String mobile;

    private String qq;

    private String weixin;

    /**
     * 留言
     */
    private String msg;


    // 以下备用
    private String remark;
    private String remark2;
    private String remark3;
    private String remark4;
}
