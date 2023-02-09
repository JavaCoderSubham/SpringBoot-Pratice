package com.spring.security.security;

import java.util.Arrays;
import java.util.Collection;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.security.entity.UserInfo;

public class UserInfoUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;

	private List<GrantedAuthority> authority;

	public UserInfoUserDetails(UserInfo userInfo) {
		this.username = userInfo.getUsername();
		this.password = userInfo.getPassword();
		this.authority = Arrays.stream(userInfo.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authority;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
