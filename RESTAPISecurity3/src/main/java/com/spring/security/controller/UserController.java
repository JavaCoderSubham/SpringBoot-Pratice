package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.UserInfo;
import com.spring.security.service.UserInfoService;
import com.spring.security.service.UserInfoServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserInfoService service;

	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<UserInfo> getAll() {
		return service.getAllUserInfo();
	}
	
	@GetMapping("/all/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public UserInfo getById(@PathVariable int id) {
		return service.getUserById(id);
	}
	
	@PostMapping("/create")
	public String createUser(@RequestBody UserInfo userInfo) {
		return service.createUser(userInfo);
	}
	
	
}








