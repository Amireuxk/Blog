package com.ykai.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tb_article
 */
@TableName(value ="tb_article")
@Data
public class Article implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 文章类型
     */
    private Integer articleTypeid;

    /**
     * 文章题目
     */
    private String articleTitle;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 发表时间
     */
    private String articleSdtime;

    /**
     * 文章来源(原创0，转载1)
     */
    private Integer articleFrom;

    /**
     * 文章描述
     */
    private String articleInfo;

    /**
     * 文章阅读次数
     */
    private Integer articleCount;

    /**
     * 作者ID
     */
    private Integer articleMasterid;

    /**
     * 
     */
    @TableLogic
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}