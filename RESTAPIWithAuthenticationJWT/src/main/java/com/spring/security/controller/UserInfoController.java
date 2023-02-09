package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.AuthRequest;
import com.spring.security.entity.UserInfo;
import com.spring.security.service.UserInfoService;
import com.spring.security.service.jwt.JWTService;


@RestController
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService service;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/welcome")			// Permit ALL
	public String welcomePage() {
		return "Hi Welcome to Our Page";
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<UserInfo> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{username}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public UserInfo getById(@PathVariable String username) {
		return service.getById(username);
	}
	
	@PostMapping("/create")		// Permit ALL
	public UserInfo createUserInfo(@RequestBody UserInfo user) {
		return service.createUserInfo(user);
	}
	
//	For Testing
//	@GetMapping("/findByUsername")		//Permit ALL
//	public UserInfo findByUsername(@RequestParam String username) {
//		return service.findByUsername(username);
//	}
	
	@PostMapping("/auth")
	public String authenticationAndGetToken(@RequestBody AuthRequest authRequest) {
		return jwtService.generateToken(authRequest.getUsername());
	}
	
	
	
}








