package com.spring.security.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringOAuthConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.authorizeHttpRequests()
				.anyRequest()
				.authenticated()
				.and().oauth2Login()
				.and().build();
	}

	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
		ClientRegistration clientRegistration = clientRegistration();
		return new InMemoryClientRegistrationRepository(clientRegistration);
	}

	private ClientRegistration clientRegistration() {
		return CommonOAuth2Provider.GITHUB.getBuilder("github")
							.clientId("6f981045d0b06bd5b5d7")
							.clientSecret("6a294eff3728ded63a6ecb89cfd27284fb8c86f6")
							.build();
	}

}
