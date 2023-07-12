package com.bezkoder.spring.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.oracle.service.TransformerDataService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	TransformerDataService transformerDataService;

	@GetMapping("/getDataByZones")
	public ResponseEntity<?> getDataByZones() {
		Integer result = transformerDataService.getDssGmtCount(true, true, true);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);

	}

}
