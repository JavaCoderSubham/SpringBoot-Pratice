package com.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.entity.UserInfo;
import com.spring.security.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public List<UserInfo> getAllUserInfo() {
		return repository.findAll();
	}

	@Override
	public String createUser(UserInfo userInfo) {
		
		userInfo.setPassword(this.passwordEncoder.encode(userInfo.getPassword()));
		this.repository.save(userInfo);
		return "User Created...";
	}

	@Override
	public UserInfo getUserById(int id) {
		
		return this.repository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Id Not Found Exception"));
	}

}
