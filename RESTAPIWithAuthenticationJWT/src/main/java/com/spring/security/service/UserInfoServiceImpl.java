package com.spring.security.service;

import java.util.List;
import java.util.Optional;

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
	private PasswordEncoder encoder;
	
	@Override
	public List<UserInfo> getAll() {
		return repository.findAll();
	}

	@Override
	public UserInfo getById(String username) {
		return repository.findById(username)
				.orElseThrow(()-> new UsernameNotFoundException("This User name is Wrong"));
	}

	@Override
	public UserInfo createUserInfo(UserInfo user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		return repository.save(user);
	}

	@Override
	public UserInfo findByUsername(String username) {
		
		Optional<UserInfo> findByUsername = repository.findByUsername(username);
		
		return findByUsername.orElseThrow(() -> new UsernameNotFoundException("User Name Not Found Exception "+username));
	}

}
