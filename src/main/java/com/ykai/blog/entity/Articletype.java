package com.ykai.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tb_articletype
 */
@TableName(value ="tb_articletype")
@Data
public class Articletype implements Serializable {
    /**
     * 文章类型ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 文章类型名称
     */
    private String articletypeName;

    /**
     * 文章类型描述
     */
    private String articletypeInfo;

    /**
     * 
     */
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}