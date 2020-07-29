package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfigurator {
	
	@Bean(value = "restCall")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
