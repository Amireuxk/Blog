package com.ykai.blog.mapper;

import com.ykai.blog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Ykai
* @description 针对表【tb_user】的数据库操作Mapper
* @createDate 2023-02-02 18:05:55
* @Entity com.ykai.blog.entity.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

}




