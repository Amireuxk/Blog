package com.ykai.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ykai.blog.entity.Articletype;
import com.ykai.blog.mapper.ArticletypeMapper;
import com.ykai.blog.mapper.ArticletypeMapper;
import com.ykai.blog.service.ArticletypeService;
import com.ykai.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author YKai
 * @date 2023/2/7  15:22
 * @desciption: 文章类型
 */

@CrossOrigin(origins ={"*","null"})
@RestController
@RequestMapping("/ArticleType")
public class ArticleTypeController {
	
	@Autowired
	private ArticletypeMapper articleTypeMapper;
	
	@Autowired
	private ArticletypeService articleTypeService;
	
	/**
	 * 查询所有文章类型(分页)
	 */
	@RequestMapping("/ArticleTypePage")
	public R SelectAllArticleTypeByPage(@RequestBody Articletype articleType, Long currentPage, Long pageSize) {
		Page<Articletype> page = new Page<>(currentPage, pageSize);
		QueryWrapper<Articletype> queryWrapper = new QueryWrapper<>();
		queryWrapper.like("articleType_name",articleType.getArticletypeName())
				.like("ArticleType_info",articleType.getArticletypeInfo());
		Page<Articletype> articleTypePage = articleTypeMapper.selectPage(page, queryWrapper);
		return R.ok().put("articleTypeList",articleTypePage);
	}
	
	/**
	 * 添加一个文章类型
	 */
	@RequestMapping("/AddOneArticleType")
	public R AddOneArticleType(@RequestBody Articletype articleType) {
		System.out.println("articleType = " + articleType);
		articleType.setId(null);
		articleType.setIsdelete(0);
		boolean b = articleTypeService.save(articleType);
		if (b) {
			return R.ok("添加成功");
		}
		return R.error("添加失败");
	}
	
	/**
	 * 修改一个文章类型
	 */
	@RequestMapping("/updateOneArticleType")
	public R UpdateOneArticleType(@RequestBody Articletype articleType) {
		boolean b = articleTypeService.updateById(articleType);
		if (b) {
			return R.ok().put("code",200);
		}
		return R.error("更新失败");
	}
	
	/**
	 * 删除单个文章类型
	 */
	@RequestMapping("/deleteOneArticleTypeById")
	public R DeleteOneArticleTypeById(@RequestParam(value = "id") Integer id) {
		boolean b = articleTypeService.removeById(id);
		if(b) {
			return R.ok().put("code",200);
		}
		return R.error("删除失败");
	}
	
	/**
	 * 删除多个文章类型
	 */
	@RequestMapping("/deleteArticleTypesByIds")
	public R deleteUUsersByuIds(@RequestBody Integer[] Ids) {
		List<Integer> IdsList = (List<Integer>) Arrays.asList(Ids);
		boolean b = articleTypeService.removeBatchByIds(IdsList);
		if (b) {
			return R.ok().put("code",200);
		}
		return R.error("删除失败");
	}
}