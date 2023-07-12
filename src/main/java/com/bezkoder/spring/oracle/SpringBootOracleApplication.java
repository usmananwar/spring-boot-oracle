package com.bezkoder.spring.oracle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootOracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOracleApplication.class, args);
	}

}
