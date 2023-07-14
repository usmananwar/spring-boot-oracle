package com.bezkoder.spring.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.utils.Constants;
import com.bezkoder.spring.oracle.utils.QueryUtils;

@Service
public class PoleDataService {

	@Autowired
	ApiDataService apiDataService;

	public int getPoleCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getPoleCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getPoleCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getPoleCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getPoleCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		String whereClause = "1=1";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer1(Constants.MedcZone1, whereClause, geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MazonZone2, whereClause, geometry);
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.TanweerZone2, whereClause, geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MajanZone3, whereClause, geometry);
		}
		return result;
	}
}
