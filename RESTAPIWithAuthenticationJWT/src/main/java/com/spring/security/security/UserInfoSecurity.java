package com.spring.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.spring.security.userdetailsservice.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class UserInfoSecurity {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) 
										throws Exception {
		return http.csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("/user/create","/user/welcome","/user/auth").permitAll()
					.and()
					.authorizeHttpRequests()
					.requestMatchers("/user/**").authenticated()
					.and().formLogin()
					.and().logout()
					.and().build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserInfoUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = 
				new DaoAuthenticationProvider();
		
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;
	}
	
}
