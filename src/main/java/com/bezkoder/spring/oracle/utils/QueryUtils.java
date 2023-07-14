package com.bezkoder.spring.oracle.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class QueryUtils {

	public static String getGeometryString(Double xmin, Double ymin, Double xmax, Double ymax) {
		Map<String, Double> values = new LinkedHashMap<>();

		values.put("xmin", xmin);
		values.put("ymin", ymin);
		values.put("xmax", xmax);
		values.put("ymax", ymax);

		StringBuilder geometryString = new StringBuilder();
		for (Map.Entry<String, Double> entry : values.entrySet()) {
			String key = entry.getKey();
			Double value = entry.getValue();
			geometryString.append(key).append(": ").append(value).append(", ");
		}

		// Remove the trailing comma and space
		if (geometryString.length() > 0) {
			geometryString.setLength(geometryString.length() - 2);
		}

		return geometryString.toString();
	}

}
