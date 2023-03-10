package com.ykai.blog.mapper;

import com.ykai.blog.entity.Review;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Ykai
* @description 针对表【tb_review】的数据库操作Mapper
* @createDate 2023-02-07 15:12:23
* @Entity com.ykai.blog.entity.Review
*/
@Repository
public interface ReviewMapper extends BaseMapper<Review> {
	
}




