package com.ykai.blog.controller;

/**
 * @author YKai
 * @date 2023/2/15  11:45
 * @desciption: 评论
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ykai.blog.entity.Review;
import com.ykai.blog.mapper.ReviewMapper;
import com.ykai.blog.service.ReviewService;
import com.ykai.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins ={"*","null"})
@RestController
@RequestMapping("/Review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	/**
	 * 通过文章id查询评论
	 */
	@RequestMapping("/SelectReviewInfoByArticleId")
	public R SelectReviewInfoByArticleId(@RequestParam(value = "reviewArticleid") Integer reviewArticleid) {
		QueryWrapper<Review> queryWrapper = new QueryWrapper<>();
		List<Review> reviewList = reviewMapper.selectList(queryWrapper.eq("review_articleID", reviewArticleid));
		return R.ok().put("reviewList",reviewList);
		
	}
	
	
	/**
	 * 删除评论
	 */
	@RequestMapping("/DeleteOneReviewById")
	public R DeleteOneArticleById(@RequestParam(value = "id") Integer id) {
		boolean b = reviewService.removeById(id);
		if (b){
			return R.ok().put("code",200);
		}
		return R.error(500,"删除失败");
	}
	
}
