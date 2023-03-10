package com.ykai.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ykai.blog.entity.Friend;
import com.ykai.blog.service.FriendService;
import com.ykai.blog.mapper.FriendMapper;
import org.springframework.stereotype.Service;

/**
* @author Ykai
* @description 针对表【tb_friend】的数据库操作Service实现
* @createDate 2023-02-08 12:09:43
*/
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend>
    implements FriendService{

}




