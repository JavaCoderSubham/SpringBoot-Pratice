package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.security.entity.User;

@Controller
@RequestMapping("/")
public class UserControllerClass {

	@GetMapping
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("error")
	public String errorPage() {
		return "error";
	}
	
	@GetMapping("admin")
	public String adminPage() {
		return "admin";
	}
	
	@GetMapping("user")
	public String userPage() {
		return "user";
	}
	
	@PostMapping("get/user")
	public String getPage(@RequestBody User user) {
		System.out.println(user);
		return "user";
	}
	
	
}
