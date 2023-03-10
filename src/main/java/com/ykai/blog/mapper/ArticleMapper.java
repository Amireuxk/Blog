package com.ykai.blog.mapper;

import com.ykai.blog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Ykai
* @description 针对表【tb_article】的数据库操作Mapper
* @createDate 2023-02-07 15:15:03
* @Entity com.ykai.blog.entity.Article
*/
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
	
	void selectAllArticleInformation();
	
}




