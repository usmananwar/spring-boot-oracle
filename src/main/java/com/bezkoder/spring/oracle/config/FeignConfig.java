package com.bezkoder.spring.oracle.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.codec.Decoder;

@Configuration
public class FeignConfig {

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.BASIC;
	}

//	@Bean
//	public Decoder feignDecoder() {
//		HttpMessageConverters httpMessageConverters = new HttpMessageConverters(new CustomStringHttpMessageConverter());
//		ObjectFactory<HttpMessageConverters> objectFactory = () -> httpMessageConverters;
//		return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
//	}

}