package com.ykai.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tb_friend
 */
@TableName(value ="tb_friend")
@Data
public class Friend implements Serializable {
    /**
     * 朋友id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 博主id
     */
    private Integer friendMasterid;

    /**
     * 博主朋友id
     */
    private Integer friendFriendid;

    /**
     * 朋友备注
     */
    private String friendRename;

    /**
     * 
     */
	@TableLogic
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}