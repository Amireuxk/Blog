package com.ykai.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tb_review
 */
@TableName(value ="tb_review")
@Data
public class Review implements Serializable {
    /**
     * 评论id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 评论的文章ID
     */
    private Integer reviewArticleid;

    /**
     * 评论对象id
     */
    private Integer reviewMasterid;

    /**
     * 评论内容
     */
    private String reviewContent;

    /**
     * 评论时间
     */
    private String reviewSdtime;

    /**
     * 评论作者ID
     */
    private Integer reviewAuthorid;

    /**
     * 
     */
    @TableLogic
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}