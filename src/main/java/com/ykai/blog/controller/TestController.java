package com.ykai.blog.controller;

import com.ykai.blog.entity.User;
import com.ykai.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YKai
 * @date 2023/2/2  14:58
 * @desciption:
 */

@RestController
public class TestController {
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/test")
	public String test(@RequestParam("test") String test) {
		return "当前接收的参数值为：" + test ;
	}
	
	@GetMapping("/list")
	public List<User> list() {
		return userMapper.selectList(null);
	}
}
