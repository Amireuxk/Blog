package com.ykai.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ykai.blog.entity.Article;
import com.ykai.blog.entity.Review;
import com.ykai.blog.mapper.ArticleMapper;
import com.ykai.blog.service.ArticleService;
import com.ykai.blog.service.ReviewService;
import com.ykai.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YKai
 * @date 2023/2/8  12:11
 * @desciption: 文章
 */

@CrossOrigin(origins ={"*","null"})
@RestController
@RequestMapping("/Article")
public class ArticleController {
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ReviewService reviewService;
	
	/**
	 * 查询所有文章(分页)
	 */
	@RequestMapping("/ArticlePage")
	public R SelectAllArticle(@RequestBody Article article, Long currentPage, Long pageSize) {
		Page<Article> page = new Page<>(currentPage, pageSize);
		QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
		
		Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
		return R.ok().put("articleList",articlePage);
	}
	
	/**
	 * 通过TypeId查询文章
	 */
	@RequestMapping("/SelectArticleByTypeId")
	public R SelectArticleByTypeId(@RequestParam(value = "articleTypeid") Integer articleTypeid) {
		QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
		List<Article> article = articleMapper.selectList(queryWrapper.eq("article_typeID", articleTypeid));
		System.out.println("article = " + article);
		return R.ok().put("articleList",article);
	}
	
	/**
	 * 删除文章及评论
	 */
	@RequestMapping("/DeleteOneArticleById")
	public R DeleteOneArticleById(@RequestParam(value = "id") Integer id) {
		QueryWrapper<Review> queryWrapper = new QueryWrapper<Review>();
		boolean b = articleService.removeById(id);
		if (b){
			reviewService.remove(queryWrapper.eq("review_articleID", id));
			return R.ok().put("code",200);
		}
		return R.error(500,"删除失败");
	}
	
	/**
	 * 通过id查询文章信息
	 */
	@RequestMapping("/SelectArticleInfoById")
	public R SelectArticleInfoById(@RequestParam(value = "id") Integer id) {
		Article articleInfo = articleService.getById(id);
		return R.ok().put("articleInfo",articleInfo);
	}
	
}
