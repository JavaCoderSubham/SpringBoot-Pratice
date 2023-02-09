package com.spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.security.entity.User;

@Service
public class UserService {

	List<User> list = new ArrayList<>();

	public UserService() {
		list.add(new User("subham@gmail.com", "subham"));
		list.add(new User("gupta@gmail.com", "gupta"));
	}

	public User addUser(User user) {
		list.add(user);
		return user;
	}

	public List<User> getListOfUser() {
		return list;
	}

	public User getUser(String email) {
		return list.stream().filter(users -> users.getEmail().equals(email)).findFirst().orElse(null);
	}

}












