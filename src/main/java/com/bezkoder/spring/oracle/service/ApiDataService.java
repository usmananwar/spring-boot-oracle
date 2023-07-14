package com.bezkoder.spring.oracle.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.api.models.ApiCountResult;
import com.bezkoder.spring.api.models.ApiFeaturesResult;
import com.bezkoder.spring.api.models.Feature;
import com.bezkoder.spring.oracle.http.HttpApiClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

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

	public double getFeaturesByZonesFromMapServer5(String zone, String whereClause, String outFields, String geometry) {
		return getFeaturesShapeLengthByZonesFromMapServer(zone, "5", whereClause, outFields, geometry);
	}

	public double getFeaturesByZonesFromMapServer6(String zone, String whereClause, String outFields, String geometry) {
		return getFeaturesShapeLengthByZonesFromMapServer(zone, "6", whereClause, outFields, geometry);
	}

	public double getFeaturesByZonesFromMapServer4(String zone, String whereClause, String outFields, String geometry) {
		return getFeaturesShapeLengthByZonesFromMapServer(zone, "4", whereClause, outFields, geometry);
	}

	public double getFeaturesByZonesFromMapServer7(String zone, String whereClause, String outFields, String geometry) {
		return getFeaturesShapeLengthByZonesFromMapServer(zone, "7", whereClause, outFields, geometry);
	}

	public double getFeaturesShapeLengthByZonesFromMapServer(String zone, String mapServerId, String whereClause, String outFields, String geometry) {
		Map<String, String> parameters = new LinkedHashMap<>();
		parameters.put("where", whereClause);
		if (geometry != null) {
			parameters.put("geometry", geometry);
		}
		parameters.putAll(defaultParameters);
		parameters.put("returnCountOnly", "false");
		parameters.put("outFields", outFields);
		String content = httpApiClient.mapServerQuery(zone, mapServerId, parameters);
		ApiFeaturesResult result = stringToFeaturesObject(content);

		double sum = 0;
		for (Feature feature : result.getFeatures()) {
			if (feature.getAttributes().getShapeLength() != null) {
				sum = sum + feature.getAttributes().getShapeLength();
			} else if (feature.getAttributes().getShapeLen() != null) {
				sum = sum + feature.getAttributes().getShapeLen();
			} else if (feature.getAttributes().getShapeLength2() != null) {
				sum = sum + feature.getAttributes().getShapeLength2();
			}
		}
		log.debug("Result: {}", sum);
		return sum;
	}

	public int getCountByZonesFromMapServer(String zone, String mapServerId, String whereClause, String geometry) {
		Map<String, String> parameters = new LinkedHashMap<>();
		parameters.put("where", whereClause);
		if (geometry != null) {
			parameters.put("geometry", geometry);
		}
		parameters.putAll(defaultParameters);
		String content = httpApiClient.mapServerQuery(zone, mapServerId, parameters);
		ApiCountResult result = stringToCountObject(content);
		log.debug("Result: {}", result);
		return result.getCount();
	}

	private ApiFeaturesResult stringToFeaturesObject(String content) {
		if (content.contains("error")) {
			log.error("Received error from the server: {}", content);
			throw new RuntimeException("Received error from the server: " + content);
		} else {

			ApiFeaturesResult result = null;
			try {
				result = om.readValue(content, ApiFeaturesResult.class);
			} catch (JsonProcessingException e) {
				log.debug("Exception", e);
			}
			return result;
		}
	}

	private ApiCountResult stringToCountObject(String content) {

		if (content.contains("error")) {
			log.error("Received error from the server: {}", content);
			throw new RuntimeException("Received error from the server: " + content);
		} else {

			ApiCountResult result = null;
			try {
				result = om.readValue(content, ApiCountResult.class);
			} catch (JsonProcessingException e) {
				log.debug("Exception", e);
			}
			return result;
		}
	}

}
