package com.spring.security.service;

import java.util.List;

import com.spring.security.entity.UserInfo;

public interface UserInfoService {

	
	List<UserInfo> getAllUserInfo();
	
	String createUser(UserInfo userInfo);
	
	UserInfo getUserById(int id);
	
	
}
