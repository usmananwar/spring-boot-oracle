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

	public int getCountByZonesFromMapServer2(String zone, String whereClause, String geometry) {
		return getCountByZonesFromMapServer(zone, "2", whereClause, geometry);
	}

	public int getCountByZonesFromMapServer8(String zone, String whereClause, String geometry) {
		return getCountByZonesFromMapServer(zone, "8", whereClause, geometry);
	}

	public int getCountByZonesFromMapServer1(String zone, String whereClause, String geometry) {
		return getCountByZonesFromMapServer(zone, "1", whereClause, geometry);
	}

	public int getCountByZonesFromMapServer3(String zone, String whereClause, String geometry) {
		return getCountByZonesFromMapServer(zone, "3", whereClause, geometry);
	}

	public int getCountByZonesFromMapServer5(String zone, String whereClause, String geometry) {
		return getCountByZonesFromMapServer(zone, "5", whereClause, geometry);
	}

	public int getCountByZonesFromMapServer6(String zone, String whereClause, String geometry) {
		return getCountByZonesFromMapServer(zone, "6", whereClause, geometry);
	}

	public int getCountByZonesFromMapServer4(String zone, String whereClause, String geometry) {
		return getCountByZonesFromMapServer(zone, "4", whereClause, geometry);
	}

	public int getCountByZonesFromMapServer7(String zone, String whereClause, String geometry) {
		return getCountByZonesFromMapServer(zone, "7", whereClause, geometry);
	}

	public int getCountByZonesFromMapServer(String zone, String mapServerId, String whereClause, String geometry) {
		Map<String, String> parameters = new LinkedHashMap<>();
		parameters.put("where", whereClause);
		if (geometry != null) {
			parameters.put("geometry", geometry);
		}
		parameters.putAll(defaultParameters);
		String content = httpApiClient.mapServerQuery(zone, mapServerId, parameters);
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
