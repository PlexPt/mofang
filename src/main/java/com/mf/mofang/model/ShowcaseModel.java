package com.mf.mofang.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 案例
 */
@Data
@TableName("case")
public class ShowcaseModel {

    @TableId
    private Integer id;

    private String title;

    /**
     * 简介
     */
    private String des;

    private String content;

    private String imgs;


    // 以下备用
    private String remark;
    private String remark2;
    private String remark3;
    private String remark4;
}
