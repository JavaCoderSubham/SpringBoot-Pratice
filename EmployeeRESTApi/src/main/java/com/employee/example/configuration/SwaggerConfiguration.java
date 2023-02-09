package com.employee.example.configuration;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket docketConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.employee.example.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfoDetails());
	}
	
	@SuppressWarnings("deprecation")
	public ApiInfo apiInfoDetails() {
		return new ApiInfo(
				"Employee Manager", 								// Title
				"This is for Employee Manage", 						// Description
				"1.0.0.1",											// Version
				"/localhost:8080", 									// Server URL
				"7031979124", 										// Contact Number
				"Powered BY SubhamKrGupta", 						// Creater 
				"http://www.subhamgupta.com"						// Creater URL
				);						
	}
	
}
