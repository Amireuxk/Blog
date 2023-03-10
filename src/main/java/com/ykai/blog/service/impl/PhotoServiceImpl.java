package com.ykai.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ykai.blog.entity.Photo;
import com.ykai.blog.service.PhotoService;
import com.ykai.blog.mapper.PhotoMapper;
import org.springframework.stereotype.Service;

/**
* @author Ykai
* @description 针对表【tb_photo】的数据库操作Service实现
* @createDate 2023-02-07 15:12:18
*/
@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo>
    implements PhotoService{

}




