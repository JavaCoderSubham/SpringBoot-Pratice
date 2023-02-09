package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring")
public class SpringController {

	
	@GetMapping
	public String welcomePage() {
		return "Hi This is Welcome Page";
	}
	
}
