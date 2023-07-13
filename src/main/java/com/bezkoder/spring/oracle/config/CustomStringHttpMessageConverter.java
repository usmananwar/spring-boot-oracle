package com.bezkoder.spring.oracle.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.StringHttpMessageConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomStringHttpMessageConverter extends StringHttpMessageConverter {

	private final ObjectMapper objectMapper;

	public CustomStringHttpMessageConverter() {
		this.objectMapper = new ObjectMapper();
		this.setSupportedMediaTypes(getSupportedMediaTypes());
		this.setDefaultCharset(StandardCharsets.UTF_8);
	}

	@Override
	protected String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException {
		try {
			return objectMapper.writeValueAsString(objectMapper.readValue(inputMessage.getBody(), Object.class));
		} catch (JsonProcessingException e) {
			throw new IllegalStateException("Failed to convert text/plain response to JSON.", e);
		}
	}

}
