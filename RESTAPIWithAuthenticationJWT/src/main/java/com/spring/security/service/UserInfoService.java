package com.spring.security.service;

import java.util.List;

import com.spring.security.entity.UserInfo;

public interface UserInfoService {
	
	List<UserInfo> getAll();
	
	UserInfo getById(String username);
	
	UserInfo createUserInfo(UserInfo user);
	
	UserInfo findByUsername(String username);

}
