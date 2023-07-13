//package com.bezkoder.spring.oracle.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import feign.Response;
//import feign.codec.ErrorDecoder;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class ApiErrorDecoder implements ErrorDecoder {
//
//	private final ErrorDecoder defaultErrorDecoder = new Default();
//	// private ObjectMapper objectMapper;
//
//	public ApiErrorDecoder(ObjectMapper objectMapper) {
//		// this.objectMapper = objectMapper;
//	}
//
//	@Override
//	public Exception decode(String s, Response response) {
//
//		log.error("Error Response!!! {}", response.request().url());
//		if (200 != response.status()) {
//			throw new RuntimeException("API Error: " + s);
//		}
//		return defaultErrorDecoder.decode(s, response);
//	}
//
//}