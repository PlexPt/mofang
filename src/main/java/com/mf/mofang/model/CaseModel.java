package com.mf.mofang.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 案例
 */
@Data
@TableName("case")
public class CaseModel {

    @TableId
    private Integer id;

    private String title;

    private String content;

    private String imgs;


    // 以下备用
    private String remark;
    private String remark2;
    private String remark3;
    private String remark4;
}
