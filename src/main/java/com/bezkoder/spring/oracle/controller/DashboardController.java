package com.bezkoder.spring.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.oracle.service.PillerDataService;
import com.bezkoder.spring.oracle.service.PoleDataService;
import com.bezkoder.spring.oracle.service.StationsDataService;
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

	@Autowired
	StationsDataService stationsDataService;

	@Autowired
	PoleDataService poleDataService;

	@Autowired
	PillerDataService pillerDataService;

	@GetMapping("/getDataByZones")
	public ResponseEntity<?> getDataByZones() {
		int dssGmtCount = transformerDataService.getDssGmtCount(true, true, true);
		int dssPmtCount = transformerDataService.getDssPmtCount(true, true, true);
		int powerTransformer = transformerDataService.getPowerTransformerCount(true, true, true);
		int stationTransformer = transformerDataService.getStationTransformerCount(true, true, true);
		log.debug("GMT:{}, PMT: {}, POWER: {}, STATION: {}", dssGmtCount, dssPmtCount, powerTransformer, stationTransformer);

		int gridCount = stationsDataService.getGridCount(true, true, true);
		int primaryCount = stationsDataService.getPrimaryCount(true, true, true);
		int distributionCount = stationsDataService.getDistributionCount(true, true, true);
		log.debug("GRID :{}, PRIMARY : {}, DISTRIBUTION: {}", gridCount, primaryCount, distributionCount);

		int poleCount = poleDataService.getPoleCount(true, true, true);
		log.debug("POLE :{}", poleCount);

		int mainFeederPillerCount = pillerDataService.getMainFeederPillarCount(true, true, true);
		int miniFeederPillerCount = pillerDataService.getMiniFeederPillarCount(true, true, true);
		int cutoutBoxCount = pillerDataService.getCutOutBoxCount(true, true, true);
		log.debug("Main Feeder Piller :{}, Mini Feeder Piller: {}, Cutout Box: {}", mainFeederPillerCount, miniFeederPillerCount, cutoutBoxCount);

		return new ResponseEntity<String>("ABC", HttpStatus.OK);
	}

}
