package com.spring.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping
	public String homePage() {
		return "This is Home Page";
	}
	
	@GetMapping("/userpage")
	@PreAuthorize("hasAuthority('ROLE_USER')")		// Only User Can Access 
	public String userPage() {
		return "This is User Page";
	}
	
	@GetMapping("/adminpage")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")		// Only Admin Can Access
	public String adminPage() {
		return "This is Admin Page";
	}

}
