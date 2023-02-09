package com.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserConfigurationClass {

	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.authorizeHttpRequests()
				.anyRequest().authenticated()
				.and().formLogin().loginPage("/").successForwardUrl("/user").permitAll()
				.and().exceptionHandling().accessDeniedPage("/error")
				.and().build();
	}
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails admin = User.withUsername("subham")
								.password(encoder.encode("subham"))
								.roles("ADMIN")
								.build();
		return new InMemoryUserDetailsManager(admin);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
