package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping
	public User getUser() {
		return new User("Subham", "subham@gmail.com");
	}
	
}
