package com.ykai.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ykai.blog.entity.User;
import com.ykai.blog.service.UserService;
import com.ykai.blog.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Ykai
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2023-02-02 18:05:55
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




