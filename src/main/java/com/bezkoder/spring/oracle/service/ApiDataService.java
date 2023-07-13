package com.bezkoder.spring.oracle.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.http.HttpApiClient;
import com.bezkoder.spring.oracle.model.ApiResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApiDataService {

	@Autowired
	HttpApiClient httpApiClient;

	ObjectMapper om = new ObjectMapper();

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

	public int getCountByZonesFromMapServer2(String zone, String whereClause) {
		Map<String, String> parameters = new LinkedHashMap<>();
		parameters.put("where", whereClause);
		parameters.putAll(defaultParameters);
		String content = httpApiClient.mapServer2Query(zone, parameters);
		ApiResult result = stringToObject(content);
		log.debug("Result: {}", result);
		return result.getCount();
	}

	public int getCountByZonesFromMapServer8(String zone, String whereClause) {
		Map<String, String> parameters = new LinkedHashMap<>();
		parameters.put("where", whereClause);
		parameters.putAll(defaultParameters);
		String content = httpApiClient.mapServer8Query(zone, parameters);
		ApiResult result = stringToObject(content);
		log.debug("Result: {}", result);
		return result.getCount();
	}

	public int getCountByZonesFromMapServer1(String zone, String whereClause) {
		Map<String, String> parameters = new LinkedHashMap<>();
		parameters.put("where", whereClause);
		parameters.putAll(defaultParameters);
		String content = httpApiClient.mapServer1Query(zone, parameters);
		ApiResult result = stringToObject(content);
		log.debug("Result: {}", result);
		return result.getCount();
	}
	
	
	public int getCountByZonesFromMapServer3(String zone, String whereClause) {
		Map<String, String> parameters = new LinkedHashMap<>();
		parameters.put("where", whereClause);
		parameters.putAll(defaultParameters);
		String content = httpApiClient.mapServer3Query(zone, parameters);
		ApiResult result = stringToObject(content);
		log.debug("Result: {}", result);
		return result.getCount();
	}

	private ApiResult stringToObject(String content) {

		if (content.contains("error")) {
			log.error("Received error from the server: {}", content);
			throw new RuntimeException("Received error from the server: " + content);
		} else {

			ApiResult result = null;
			try {
				result = om.readValue(content, ApiResult.class);
			} catch (JsonProcessingException e) {
				log.debug("Exception", e);
			}
			return result;
		}
	}

}
