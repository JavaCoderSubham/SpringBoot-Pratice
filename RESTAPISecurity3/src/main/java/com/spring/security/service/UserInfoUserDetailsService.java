package com.spring.security.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.spring.security.configuration.UserInfoUserDetails;
import com.spring.security.entity.UserInfo;
import com.spring.security.repository.UserInfoRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService{

	@Autowired
	private UserInfoRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserInfo> userInfo = repository.findByName(username);
		
		return userInfo.map(UserInfoUserDetails::new)
				.orElseThrow(()-> new UsernameNotFoundException("User Not Found Exception"));
	}

}





