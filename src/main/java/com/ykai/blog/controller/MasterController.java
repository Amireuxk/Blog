package com.ykai.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ykai.blog.entity.Master;
import com.ykai.blog.mapper.MasterMapper;
import com.ykai.blog.service.MasterService;
import com.ykai.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author YKai
 * @date 2023/2/6  12:30
 * @desciption: 博主
 */

@CrossOrigin(origins ={"*","null"})
@RestController
@RequestMapping("/Master")
public class MasterController {
	
	@Autowired
	private MasterMapper masterMapper;
	
	@Autowired
	private MasterService masterService;
	
	
	/**
	 * 查询所有博主(分页)
	 */
	@RequestMapping("/MasterPage")
	public R SelectAllMasterByPage(@RequestBody Master master, Long currentPage, Long pageSize) {
		Page<Master> page = new Page<>(currentPage, pageSize);
		QueryWrapper<Master> queryWrapper = new QueryWrapper<>();
		queryWrapper.like("master_name",master.getMasterName())
				.like("master_oicq",master.getMasterOicq());
		Page<Master> masterPage = masterMapper.selectPage(page, queryWrapper);
		return R.ok().put("masterList",masterPage);
	}
	
	/**
	 * 查询全部博主
	 */
	@RequestMapping("/MasterList")
	public R SelectAllMaster() {
		List<Master> masterList = masterMapper.selectList(null);
		return R.ok().put("masterList",masterList);
	}
	
	
	/**
	 * 添加一个博主
	 */
	@RequestMapping("/AddOneMaster")
	public R AddOneMaster(@RequestBody Master master) {
		master.setId(null);
		master.setIsdelete(0);
		boolean b = masterService.save(master);
		if (b) {
			return R.ok("添加成功");
		}
		return R.error("添加失败");
	}
	
	/**
	 * 修改一个博主信息
	 */
	@RequestMapping("/updateOneMaster")
	public R UpdateOneMaster(@RequestBody Master master) {
		boolean b = masterService.updateById(master);
		if (b) {
			return R.ok().put("code",200);
		}
		return R.error("更新失败");
	}
	
	/**
	 * 删除单个博主信息
	 */
	@RequestMapping("/deleteOneMasterById")
	public R DeleteOneMasterById(@RequestParam(value = "id") Integer id) {
		boolean b = masterService.removeById(id);
		if(b) {
			return R.ok().put("code",200);
		}
		return R.error("删除失败");
	}
	
	/**
	 * 删除多个博主信息
	 */
	@RequestMapping("/deleteMastersByIds")
	public R deleteUUsersByuIds(@RequestBody Integer[] Ids) {
		List<Integer> IdsList = (List<Integer>) Arrays.asList(Ids);
		boolean b = masterService.removeBatchByIds(IdsList);
		if (b) {
			return R.ok().put("code",200);
		}
		return R.error("删除失败");
	}
	
	/**
	 * 通过作者id查询作者信息
	 */
	@RequestMapping("/selectMasterNameById")
	public R SelectMasterNameById(@RequestParam (value = "masterId") Integer id) {
		QueryWrapper<Master> queryWrapper = new QueryWrapper<>();
		List<Master> mastersName = masterMapper.selectList(queryWrapper.eq("id", id));
		return R.ok().put("mastersName",mastersName);
	}
}
