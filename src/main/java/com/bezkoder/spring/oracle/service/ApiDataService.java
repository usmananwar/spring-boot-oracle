package com.bezkoder.spring.oracle.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.http.HttpApiClient;
import com.bezkoder.spring.oracle.model.ApiResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApiDataService {

	@Autowired
	HttpApiClient httpApiClient;

	final static Map<String, String> defaultParameters = new LinkedHashMap<>();

	public ApiDataService() {
		defaultParameters.put("geometryType", "esriGeometryEnvelope");
		defaultParameters.put("spatialRel", "esriSpatialRelIntersects");
		defaultParameters.put("returnGeometry", "false");
		defaultParameters.put("returnIdsOnly", "false");
		defaultParameters.put("returnCountOnly", "true");
		defaultParameters.put("returnZ", "false");
		defaultParameters.put("returnM", "false");
		defaultParameters.put("returnDistinctValues", "false");
		defaultParameters.put("f", "pjson");
	}

	public int getCountByZones(String zone, String whereClause) {
		Map<String, String> parameters = new LinkedHashMap<>();
		parameters.put("where", whereClause);
		parameters.putAll(defaultParameters);
		ApiResult result = httpApiClient.mapServer2Query(zone, parameters);
		log.debug("Result: {}", result);
		return result.getCount();
	}

}
