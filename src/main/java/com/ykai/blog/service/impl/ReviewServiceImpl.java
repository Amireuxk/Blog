package com.ykai.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ykai.blog.entity.Review;
import com.ykai.blog.service.ReviewService;
import com.ykai.blog.mapper.ReviewMapper;
import org.springframework.stereotype.Service;

/**
* @author Ykai
* @description 针对表【tb_review】的数据库操作Service实现
* @createDate 2023-02-07 15:12:23
*/
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review>
    implements ReviewService{
	
}




