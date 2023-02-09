package com.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.spring.security.service.UserInfoUserDetailsService;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class UserSecurity {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("/user/create").permitAll()
					.and()
					.authorizeHttpRequests().requestMatchers("/user/**").authenticated()
					.and().formLogin()
					.and().logout()
					.and().build();
	}
	
	@Bean
	public UserDetailsService userDetailsService(/*PasswordEncoder encoder*/) {
		
//		UserDetails user = User.withUsername("user")
//								.password(encoder.encode("user"))
//								.roles("USER")
//								.build();
//		UserDetails admin = User.withUsername("admin")
//								.password(encoder.encode("admin"))
//								.roles("ADMIN")
//								.build();
		
		return new UserInfoUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
		return daoAuthenticationProvider;
	}
	
}












