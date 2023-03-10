package com.ykai.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ykai.blog.entity.Article;
import com.ykai.blog.service.ArticleService;
import com.ykai.blog.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Ykai
* @description 针对表【tb_article】的数据库操作Service实现
* @createDate 2023-02-07 15:15:03
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{
}




