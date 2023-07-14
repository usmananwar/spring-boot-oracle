
package com.bezkoder.spring.oracle.controller;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

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
// @CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/parallel_dashboard")
public class ParallelDashboardController {

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
	 * http://localhost:8080/parallel_dashboard/getDataByZones?isZoneOne=true&isZoneTwo=true&isZoneThree=true
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
		CompletableFuture<Integer> dssGmtFuture = CompletableFuture.supplyAsync(() -> transformerDataService.getDssGmtCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Integer> dssPmtFuture = CompletableFuture.supplyAsync(() -> transformerDataService.getDssPmtCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Integer> powerTransformerFuture = CompletableFuture.supplyAsync(() -> transformerDataService.getPowerTransformerCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Integer> stationTransformerFuture = CompletableFuture.supplyAsync(() -> transformerDataService.getStationTransformerCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Map<String, Object>> transformersMapFuture = CompletableFuture.allOf(dssGmtFuture, dssPmtFuture, powerTransformerFuture, stationTransformerFuture).thenApply((Void) -> {
			int dssGmtCount = dssGmtFuture.join();
			int dssPmtCount = dssPmtFuture.join();
			int powerTransformerCount = powerTransformerFuture.join();
			int stationTransformerCount = stationTransformerFuture.join();
			return dashboardDataService.prepareTransformerObject(dssGmtCount, dssPmtCount, powerTransformerCount, stationTransformerCount);
		});

		CompletableFuture<Integer> gridCountFuture = CompletableFuture.supplyAsync(() -> stationsDataService.getGridCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Integer> primaryCountFuture = CompletableFuture.supplyAsync(() -> stationsDataService.getPrimaryCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Integer> distributionCountFuture = CompletableFuture.supplyAsync(() -> stationsDataService.getDistributionCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Map<String, Object>> stationsMapFuture = CompletableFuture.allOf(gridCountFuture, primaryCountFuture, distributionCountFuture).thenApply((Void) -> {
			int gridCount = gridCountFuture.join();
			int primaryCount = primaryCountFuture.join();
			int distributionCount = distributionCountFuture.join();
			return dashboardDataService.prepareStationMap(gridCount, primaryCount, distributionCount);
		});

		CompletableFuture<Integer> poleCountFuture = CompletableFuture.supplyAsync(() -> poleDataService.getPoleCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Map<String, Object>> poleMapFuture = poleCountFuture.thenApply((poleCount) -> dashboardDataService.preparePoleMap(poleCount));

		CompletableFuture<Integer> mainFeederPillarCountFuture = CompletableFuture.supplyAsync(() -> pillerDataService.getMainFeederPillarCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Integer> miniFeederPillarCountFuture = CompletableFuture.supplyAsync(() -> pillerDataService.getMiniFeederPillarCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Integer> cutoutBoxCountFuture = CompletableFuture.supplyAsync(() -> pillerDataService.getCutOutBoxCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Map<String, Object>> pillarMapFuture = CompletableFuture.allOf(mainFeederPillarCountFuture, miniFeederPillarCountFuture, cutoutBoxCountFuture).thenApply((Void) -> {
			int mainFeederPillarCount = mainFeederPillarCountFuture.join();
			int miniFeederPillarCount = miniFeederPillarCountFuture.join();
			int cutoutBoxCount = cutoutBoxCountFuture.join();
			return dashboardDataService.preparePillarMap(mainFeederPillarCount, miniFeederPillarCount, cutoutBoxCount);
		});

		CompletableFuture<Double> overhead33KvCountFuture = CompletableFuture.supplyAsync(() -> overheadDataService.getThrityThreeKvCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Double> overhead11KvCountFuture = CompletableFuture.supplyAsync(() -> overheadDataService.getElevenKvCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Double> overhead1VCountFuture = CompletableFuture.supplyAsync(() -> overheadDataService.getOneVCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Map<String, Object>> overheadMapFuture = CompletableFuture.allOf(overhead33KvCountFuture, overhead11KvCountFuture, overhead1VCountFuture).thenApply((Void) -> {
			double overhead33KvCount = overhead33KvCountFuture.join();
			double overhead11KvCount = overhead11KvCountFuture.join();
			double overhead1VCount = overhead1VCountFuture.join();
			return dashboardDataService.prepareOverhead(overhead33KvCount, overhead11KvCount, overhead1VCount);
		});

		CompletableFuture<Double> underground33KvCountFuture = CompletableFuture.supplyAsync(() -> undergroundDataService.getThrityThreeKvCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Double> underground11KvCountFuture = CompletableFuture.supplyAsync(() -> undergroundDataService.getElevenKvCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Double> underground1VCountFuture = CompletableFuture.supplyAsync(() -> undergroundDataService.getOneVCountByZone(isZoneOne, isZoneTwo, isZoneThree));

		CompletableFuture<Map<String, Object>> undergroundMapFuture = CompletableFuture.allOf(underground33KvCountFuture, underground11KvCountFuture, underground1VCountFuture).thenApply((Void) -> {
			double underground33KvCount = underground33KvCountFuture.join();
			double underground11KvCount = underground11KvCountFuture.join();
			double underground1VCount = underground1VCountFuture.join();
			return dashboardDataService.prepareOverhead(underground33KvCount, underground11KvCount, underground1VCount);
		});

		CompletableFuture<Map<String, Map<String, Object>>> resultFuture = CompletableFuture.allOf(transformersMapFuture, stationsMapFuture, poleMapFuture, pillarMapFuture, overheadMapFuture, undergroundMapFuture).thenApply((Void) -> {
			Map<String, Object> transformersMap = transformersMapFuture.join();
			Map<String, Object> stationsMap = stationsMapFuture.join();
			Map<String, Object> poleMap = poleMapFuture.join();
			Map<String, Object> pillarMap = pillarMapFuture.join();
			Map<String, Object> overheadMap = overheadMapFuture.join();
			Map<String, Object> undergroundMap = undergroundMapFuture.join();
			return dashboardDataService.prepareResult(transformersMap, stationsMap, poleMap, pillarMap, overheadMap, undergroundMap);
		});

		Map<String, Map<String, Object>> result = resultFuture.join();

		log.info("Result: {}", result);
		return new ResponseEntity<Map<String, Map<String, Object>>>(result, HttpStatus.OK);
	}

	/**
	 * 
	 * Sample request URL:
	 * http://localhost:8080/parallel_dashboard/getDataByGeometry?xmin=290756.7708&ymin=1981491.5853&xmax=687769.4381&ymax=2377919.7326
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

		CompletableFuture<Integer> dssGmtFuture = CompletableFuture.supplyAsync(() -> transformerDataService.getDssGmtCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Integer> dssPmtFuture = CompletableFuture.supplyAsync(() -> transformerDataService.getDssPmtCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Integer> powerTransformerFuture = CompletableFuture.supplyAsync(() -> transformerDataService.getPowerTransformerCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Integer> stationTransformerFuture = CompletableFuture.supplyAsync(() -> transformerDataService.getStationTransformerCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Map<String, Object>> transformersMapFuture = CompletableFuture.allOf(dssGmtFuture, dssPmtFuture, powerTransformerFuture, stationTransformerFuture).thenApply((Void) -> {
			int dssGmtCount = dssGmtFuture.join();
			int dssPmtCount = dssPmtFuture.join();
			int powerTransfomerCount = powerTransformerFuture.join();
			int stationTransformerCount = stationTransformerFuture.join();
			return dashboardDataService.prepareTransformerObject(dssGmtCount, dssPmtCount, powerTransfomerCount, stationTransformerCount);
		});

		CompletableFuture<Integer> gridCountFuture = CompletableFuture.supplyAsync(() -> stationsDataService.getGridCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Integer> primaryCountFuture = CompletableFuture.supplyAsync(() -> stationsDataService.getPrimaryCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Integer> distributionCountFuture = CompletableFuture.supplyAsync(() -> stationsDataService.getDistributionCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Map<String, Object>> stationsMapFuture = CompletableFuture.allOf(gridCountFuture, primaryCountFuture, distributionCountFuture).thenApply((Void) -> {
			int gridCount = gridCountFuture.join();
			int primaryCount = primaryCountFuture.join();
			int distributionCount = distributionCountFuture.join();
			return dashboardDataService.prepareStationMap(gridCount, primaryCount, distributionCount);
		});

		CompletableFuture<Integer> poleCountFuture = CompletableFuture.supplyAsync(() -> poleDataService.getPoleCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Map<String, Object>> poleMapFuture = poleCountFuture.thenApply((poleCount) -> dashboardDataService.preparePoleMap(poleCount));

		CompletableFuture<Integer> mainFeederPillarCountFuture = CompletableFuture.supplyAsync(() -> pillerDataService.getMainFeederPillarCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Integer> miniFeederPillarCountFuture = CompletableFuture.supplyAsync(() -> pillerDataService.getMiniFeederPillarCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Integer> cutoutBoxCountFuture = CompletableFuture.supplyAsync(() -> pillerDataService.getCutOutBoxCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Map<String, Object>> pillarMapFuture = CompletableFuture.allOf(mainFeederPillarCountFuture, miniFeederPillarCountFuture, cutoutBoxCountFuture).thenApply((Void) -> {
			int mainFeederPillarCount = mainFeederPillarCountFuture.join();
			int miniFeederPillarCount = miniFeederPillarCountFuture.join();
			int cutoutBoxCount = cutoutBoxCountFuture.join();
			return dashboardDataService.preparePillarMap(mainFeederPillarCount, miniFeederPillarCount, cutoutBoxCount);
		});

		CompletableFuture<Double> overhead33KvCountFuture = CompletableFuture.supplyAsync(() -> overheadDataService.getThrityThreeKvCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Double> overhead11KvCountFuture = CompletableFuture.supplyAsync(() -> overheadDataService.getElevenKvCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Double> overhead1VCountFuture = CompletableFuture.supplyAsync(() -> overheadDataService.getOneVCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Map<String, Object>> overheadMapFuture = CompletableFuture.allOf(overhead33KvCountFuture, overhead11KvCountFuture, overhead1VCountFuture).thenApply((Void) -> {
			double overhead33KvCount = overhead33KvCountFuture.join();
			double overhead11KvCount = overhead11KvCountFuture.join();
			double overhead1VCount = overhead1VCountFuture.join();
			return dashboardDataService.prepareOverhead(overhead33KvCount, overhead11KvCount, overhead1VCount);
		});

		CompletableFuture<Double> underground33KvCountFuture = CompletableFuture.supplyAsync(() -> undergroundDataService.getThrityThreeKvCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Double> underground11KvCountFuture = CompletableFuture.supplyAsync(() -> undergroundDataService.getElevenKvCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Double> underground1VCountFuture = CompletableFuture.supplyAsync(() -> undergroundDataService.getOneVCountByGeometry(xmin, ymin, xmax, ymax));

		CompletableFuture<Map<String, Object>> undergroundMapFuture = CompletableFuture.allOf(underground33KvCountFuture, underground11KvCountFuture, underground1VCountFuture).thenApply((Void) -> {
			double underground33KvCount = underground33KvCountFuture.join();
			double underground11KvCount = underground11KvCountFuture.join();
			double underground1VCount = underground1VCountFuture.join();
			return dashboardDataService.prepareOverhead(underground33KvCount, underground11KvCount, underground1VCount);
		});

		CompletableFuture<Map<String, Map<String, Object>>> resultFuture = CompletableFuture.allOf(transformersMapFuture, stationsMapFuture, poleMapFuture, pillarMapFuture, overheadMapFuture, undergroundMapFuture).thenApply((Void) -> {
			Map<String, Object> transformersMap = transformersMapFuture.join();
			Map<String, Object> stationsMap = stationsMapFuture.join();
			Map<String, Object> poleMap = poleMapFuture.join();
			Map<String, Object> pillarMap = pillarMapFuture.join();
			Map<String, Object> overheadMap = overheadMapFuture.join();
			Map<String, Object> undergroundMap = undergroundMapFuture.join();
			return dashboardDataService.prepareResult(transformersMap, stationsMap, poleMap, pillarMap, overheadMap, undergroundMap);
		});

		Map<String, Map<String, Object>> result = resultFuture.join();
		log.info("Result: {}", result);
		return new ResponseEntity<Map<String, Map<String, Object>>>(result, HttpStatus.OK);
	}

}
