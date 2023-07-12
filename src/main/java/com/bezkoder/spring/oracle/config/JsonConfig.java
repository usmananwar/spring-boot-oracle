package com.bezkoder.spring.oracle.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class JsonConfig {

	@Bean
	public MappingJackson2HttpMessageConverter configureMessageConverters(
			List<HttpMessageConverter<?>> messageConverters) {
		return new MappingJackson2HttpMessageConverter();
	}
}
