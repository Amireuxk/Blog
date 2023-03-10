package com.ykai.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tb_photo
 */
@TableName(value ="tb_photo")
@Data
public class Photo implements Serializable {
    /**
     * 相片id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 相片存放地址
     */
    private String photoAddr;

    /**
     * 相片上传日期
     */
    private String photoSdtime;

    /**
     * 相片介绍
     */
    private String photoInfo;

    /**
     * 博主id
     */
    private Integer photoMasterid;

    /**
     * 
     */
    @TableLogic
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}