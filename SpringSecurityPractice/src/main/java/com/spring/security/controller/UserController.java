package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.User;
import com.spring.security.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> getAllUser() {
		return service.getListOfUser();
	}
	
	@GetMapping("/getUser")
	public User getUser(@RequestParam String email) {
		return service.getUser(email);
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
}













