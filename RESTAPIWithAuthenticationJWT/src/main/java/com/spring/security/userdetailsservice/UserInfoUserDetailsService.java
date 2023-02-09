package com.spring.security.userdetailsservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.spring.security.entity.UserInfo;
import com.spring.security.repository.UserInfoRepository;
import com.spring.security.security.UserInfoUserDetails;

@Component
public class UserInfoUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserInfoRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) 
					throws UsernameNotFoundException {
		
		Optional<UserInfo> userInfo = repository.findByUsername(username);
		
		return userInfo.map(UserInfoUserDetails::new)
					.orElseThrow(() -> new UsernameNotFoundException("User not Found" + username));
	}

}









