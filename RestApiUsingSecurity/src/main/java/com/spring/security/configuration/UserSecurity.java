package com.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class UserSecurity {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/user").permitAll()
				.and()
				.authorizeRequests().antMatchers("/user/**").authenticated()
				.and().formLogin()
				.and().build();
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails admin = User.withUsername("subham")
							.password(passwordEncoder.encode("subham"))
							.roles("ADMIN")
							.build();

		UserDetails user = User.withUsername("gupta")
							.password(passwordEncoder.encode("gupta"))
							.roles("USER")
							.build();

		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
