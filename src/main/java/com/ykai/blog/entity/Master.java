package com.ykai.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tb_master
 */
@TableName(value ="tb_master")
@Data
public class Master implements Serializable {
    /**
     * 博主id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 博主名
     */
    private String masterName;

    /**
     * 博主密码
     */
    private String masterPassword;

    /**
     * 博主oicq
     */
    private String masterOicq;

    /**
     * 博主性别(男0女1)
     */
    private Integer masterSex;

    /**
     * 
     */
	@TableLogic
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}