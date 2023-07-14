package com.bezkoder.spring.oracle.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.oracle.service.DashboardDataService;
import com.bezkoder.spring.oracle.service.OverheadDataService;
import com.bezkoder.spring.oracle.service.PillerDataService;
import com.bezkoder.spring.oracle.service.PoleDataService;
import com.bezkoder.spring.oracle.service.StationsDataService;
import com.bezkoder.spring.oracle.service.TransformerDataService;
import com.bezkoder.spring.oracle.service.UndergroundDataService;

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

	@Autowired
	OverheadDataService overheadDataService;

	@Autowired
	UndergroundDataService undergroundDataService;

	@Autowired
	DashboardDataService dashboardDataService;

	/**
	 * 
	 * Sample request URL:
	 * http://localhost:8080/dashboard/getDataByZones?isZoneOne=true&isZoneTwo=true&isZoneThree=true
	 * 
	 * 
	 * @param isZoneOne
	 * @param isZoneTwo
	 * @param isZoneThree
	 * @return
	 */
	@GetMapping("/getDataByZones")
	public ResponseEntity<?> getDataByZones(@RequestParam(required = true) boolean isZoneOne, @RequestParam(required = true) boolean isZoneTwo, @RequestParam(required = true) boolean isZoneThree) {

		log.info("Received parameters; isZoneOne: {}, isZoneTwo: {}, isZoneThree: {}", isZoneOne, isZoneTwo, isZoneThree);

		int dssGmtCount = transformerDataService.getDssGmtCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		int dssPmtCount = transformerDataService.getDssPmtCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		int powerTransfomerCount = transformerDataService.getPowerTransformerCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		int stationTransformerCount = transformerDataService.getStationTransformerCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		Map<String, Object> transformersMap = dashboardDataService.prepareTransformerObject(dssGmtCount, dssPmtCount, powerTransfomerCount, stationTransformerCount);

		int gridCount = stationsDataService.getGridCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		int primaryCount = stationsDataService.getPrimaryCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		int distributionCount = stationsDataService.getDistributionCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		Map<String, Object> stationsMap = dashboardDataService.prepareStationMap(gridCount, primaryCount, distributionCount);

		int poleCount = poleDataService.getPoleCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		Map<String, Object> poleMap = dashboardDataService.preparePoleMap(poleCount);

		int mainFeederPillerCount = pillerDataService.getMainFeederPillarCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		int miniFeederPillerCount = pillerDataService.getMiniFeederPillarCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		int cutoutBoxCount = pillerDataService.getCutOutBoxCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		Map<String, Object> pillarMap = dashboardDataService.preparePillarMap(mainFeederPillerCount, miniFeederPillerCount, cutoutBoxCount);

		double overhead33KvCount = overheadDataService.getThrityThreeKvCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		double overhead11KvCount = overheadDataService.getElevenKvCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		double overhead1VCount = overheadDataService.getOneVCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		Map<String, Object> overheadMap = dashboardDataService.prepareOverhead(overhead33KvCount, overhead11KvCount, overhead1VCount);

		double undergroud33KvCount = undergroundDataService.getThrityThreeKvCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		double undergroud11KvCount = undergroundDataService.getElevenKvCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		double undergroud1VCount = undergroundDataService.getOneVCountByZone(isZoneOne, isZoneTwo, isZoneThree);
		Map<String, Object> undergroundMap = dashboardDataService.prepareOverhead(undergroud33KvCount, undergroud11KvCount, undergroud1VCount);

		Map<String, Map<String, Object>> result = dashboardDataService.prepareResult(transformersMap, stationsMap, poleMap, pillarMap, overheadMap, undergroundMap);

		log.info("Result: {}", result);
		return new ResponseEntity<Map<String, Map<String, Object>>>(result, HttpStatus.OK);
	}

	/**
	 * 
	 * Sample request URL:
	 * http://localhost:8080/dashboard/getDataByGeometry?xmin=290756.7708&ymin=1981491.5853&xmax=687769.4381&ymax=2377919.7326
	 * 
	 * 
	 * @param isZoneOne
	 * @param isZoneTwo
	 * @param isZoneThree
	 * @return
	 */
	@GetMapping("/getDataByGeometry")
	public ResponseEntity<?> getDataByZones(@RequestParam(required = true) Double xmin, @RequestParam(required = true) Double ymin, @RequestParam(required = true) Double xmax, @RequestParam(required = true) Double ymax) {

		log.info("Received parameters; xmin: {}, ymin: {}, xmax: {}, ymax: {}", xmin, ymin, xmax, ymax);

		int dssGmtCount = transformerDataService.getDssGmtCountByGeometry(xmin, ymin, xmax, ymax);
		int dssPmtCount = transformerDataService.getDssPmtCountByGeometry(xmin, ymin, xmax, ymax);
		int powerTransfomerCount = transformerDataService.getPowerTransformerCountByGeometry(xmin, ymin, xmax, ymax);
		int stationTransformerCount = transformerDataService.getStationTransformerCountByGeometry(xmin, ymin, xmax, ymax);
		Map<String, Object> transformersMap = dashboardDataService.prepareTransformerObject(dssGmtCount, dssPmtCount, powerTransfomerCount, stationTransformerCount);

		int gridCount = stationsDataService.getGridCountByGeometry(xmin, ymin, xmax, ymax);
		int primaryCount = stationsDataService.getPrimaryCountByGeometry(xmin, ymin, xmax, ymax);
		int distributionCount = stationsDataService.getDistributionCountByGeometry(xmin, ymin, xmax, ymax);
		Map<String, Object> stationsMap = dashboardDataService.prepareStationMap(gridCount, primaryCount, distributionCount);

		int poleCount = poleDataService.getPoleCountByGeometry(xmin, ymin, xmax, ymax);
		Map<String, Object> poleMap = dashboardDataService.preparePoleMap(poleCount);

		int mainFeederPillerCount = pillerDataService.getMainFeederPillarCountByGeometry(xmin, ymin, xmax, ymax);
		int miniFeederPillerCount = pillerDataService.getMiniFeederPillarCountByGeometry(xmin, ymin, xmax, ymax);
		int cutoutBoxCount = pillerDataService.getCutOutBoxCountByGeometry(xmin, ymin, xmax, ymax);
		Map<String, Object> pillarMap = dashboardDataService.preparePillarMap(mainFeederPillerCount, miniFeederPillerCount, cutoutBoxCount);

		double overhead33KvCount = overheadDataService.getThrityThreeKvCountByGeometry(xmin, ymin, xmax, ymax);
		double overhead11KvCount = overheadDataService.getElevenKvCountByGeometry(xmin, ymin, xmax, ymax);
		double overhead1VCount = overheadDataService.getOneVCountByGeometry(xmin, ymin, xmax, ymax);
		Map<String, Object> overheadMap = dashboardDataService.prepareOverhead(overhead33KvCount, overhead11KvCount, overhead1VCount);

		double undergroud33KvCount = undergroundDataService.getThrityThreeKvCountByGeometry(xmin, ymin, xmax, ymax);
		double undergroud11KvCount = undergroundDataService.getElevenKvCountByGeometry(xmin, ymin, xmax, ymax);
		double undergroud1VCount = undergroundDataService.getOneVCountByGeometry(xmin, ymin, xmax, ymax);
		Map<String, Object> undergroundMap = dashboardDataService.prepareOverhead(undergroud33KvCount, undergroud11KvCount, undergroud1VCount);

		Map<String, Map<String, Object>> result = dashboardDataService.prepareResult(transformersMap, stationsMap, poleMap, pillarMap, overheadMap, undergroundMap);
		log.info("Result: {}", result);
		return new ResponseEntity<Map<String, Map<String, Object>>>(result, HttpStatus.OK);
	}

}
