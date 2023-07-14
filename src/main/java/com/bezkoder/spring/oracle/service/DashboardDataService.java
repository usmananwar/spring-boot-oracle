package com.bezkoder.spring.oracle.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DashboardDataService {

	public Map<String, Integer> prepareTransformerObject(int dssGmtCount, int dssPmtCount, int powerTransfomerCount, int stationTransformerCount) {
		Map<String, Integer> transformerMap = new LinkedHashMap<>();
		transformerMap.put("dss_gmt", dssGmtCount);
		transformerMap.put("dss_pmt", dssPmtCount);
		transformerMap.put("power_transformer", powerTransfomerCount);
		transformerMap.put("station_transformer", stationTransformerCount);
		return transformerMap;
	}

	public Map<String, Integer> prepareStationMap(int gridCount, int primaryCount, int distributionCount) {
		Map<String, Integer> stationMap = new LinkedHashMap<>();
		stationMap.put("grid", gridCount);
		stationMap.put("primary", primaryCount);
		stationMap.put("distribution", distributionCount);
		return stationMap;
	}

	public Map<String, Integer> preparePoleMap(int poleCount) {
		Map<String, Integer> poleMap = new LinkedHashMap<>();
		poleMap.put("pole", poleCount);
		return poleMap;
	}

	public Map<String, Integer> preparePillarMap(int mainFeederPillarCount, int miniFeederPillarCount, int cutoutBoxCount) {
		Map<String, Integer> stationMap = new LinkedHashMap<>();
		stationMap.put("main_feeder_pillar", mainFeederPillarCount);
		stationMap.put("mini_feeder_pillar", miniFeederPillarCount);
		stationMap.put("cutout_box", cutoutBoxCount);
		return stationMap;
	}

	public Map<String, Integer> overhead(int thirtyThreeKvCount, int elevenKvCount, int oneKvCount) {
		Map<String, Integer> pillarMap = new LinkedHashMap<>();
		pillarMap.put("33kv", thirtyThreeKvCount);
		pillarMap.put("11kv", elevenKvCount);
		pillarMap.put("1kv", oneKvCount);
		return pillarMap;
	}

	public Map<String, Integer> prepareUndergroundMap(int thirtyThreeKvCount, int elevenKvCount, int lowVoltageCount) {
		Map<String, Integer> undergroundMap = new LinkedHashMap<>();
		undergroundMap.put("33kv", thirtyThreeKvCount);
		undergroundMap.put("11kv", elevenKvCount);
		undergroundMap.put("lv", lowVoltageCount);
		return undergroundMap;
	}

	public Map<String, Map<String, Integer>> prepareResult(Map<String, Integer> transformerMap, Map<String, Integer> stationMap, Map<String, Integer> poleMap, Map<String, Integer> pillarMap, Map<String, Integer> overheadMap, Map<String, Integer> undergroundMap) {
		Map<String, Map<String, Integer>> result = new LinkedHashMap<>();
		result.put("transformer", transformerMap);
		result.put("station", stationMap);
		result.put("pole", poleMap);
		result.put("pillar", pillarMap);
		result.put("overhead", overheadMap);
		result.put("underground", undergroundMap);

		return result;
	}

}
