package com.ykai.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tb_word
 */
@TableName(value ="tb_word")
@Data
public class Word implements Serializable {
    /**
     * 留言ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 留言标题
     */
    private String wordTitle;

    /**
     * 留言内容
     */
    private String wordContent;

    /**
     * 留言时间
     */
    private String wordSdtime;

    /**
     * 留言作者ID
     */
    private Integer wordAutorid;

    /**
     * 留言对象ID
     */
    private Integer wordMasterid;

    /**
     * 
     */
    @TableLogic
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}