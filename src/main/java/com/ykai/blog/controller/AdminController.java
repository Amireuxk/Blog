package com.ykai.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ykai.blog.entity.User;
import com.ykai.blog.mapper.UserMapper;
import com.ykai.blog.service.UserService;
import com.ykai.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author YKai
 * @date 2023/2/3  15:19
 * @desciption: 后台管理员
 */

@CrossOrigin(origins = {"*", "null"})
@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 登录
	 */
	@RequestMapping("/AdminLogin")
	public R AdminLogin(@RequestBody User user) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		User AdminInfo = userService.getOne(queryWrapper.eq("username", user.getUsername()).eq("password", user.getPassword()));
		System.out.println("AdminInfo = " + AdminInfo);
		if (AdminInfo == null) {
			return R.error("账号或密码不正确");
		}
		return R.ok("成功").put("AdminInfo", AdminInfo);
	}
	
	/**
	 * 注册
	 */
	@RequestMapping("/AdminRegister")
	public R AdminRegister(@RequestBody User user) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		User one = userService.getOne(queryWrapper.eq("username", user.getUsername()));
		if (one != null) {
			return R.error("用户名已存在");
		}
		user.setId(null);
		user.setIsdelete(0);
		userService.saveOrUpdate(user);
		
		return R.ok("成功");
	}
	
	/**
	 * 修改个人密码
	 */
	@RequestMapping("/AdminChangePwd")
	public R AdminChangePwd(@RequestBody User user) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("id", user.getId());
		boolean b = userService.updateById(user);
		if (b) {
			return R.ok("修改成功");
		}
		return R.error("修改失败");
	}
	
}
