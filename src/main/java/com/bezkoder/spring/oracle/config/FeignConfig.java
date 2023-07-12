package com.bezkoder.spring.oracle.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import feign.Logger;

public class FeignConfig {

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.BASIC;
	}

	
}