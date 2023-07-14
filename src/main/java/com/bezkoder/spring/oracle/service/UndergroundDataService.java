package com.bezkoder.spring.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.utils.Constants;
import com.bezkoder.spring.oracle.utils.QueryUtils;

@Service
public class UndergroundDataService {

	@Autowired
	ApiDataService apiDataService;

	public int getThrityThreeKvCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getThrityThreeKvCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getThrityThreeKvCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getThrityThreeKvCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getThrityThreeKvCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		String whereClause = "SUBTYPECD=2";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer6(Constants.MedcZone1, whereClause, geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer6(Constants.MazonZone2, whereClause, geometry);
			result = result + apiDataService.getCountByZonesFromMapServer6(Constants.TanweerZone2, whereClause, geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer6(Constants.MajanZone3, whereClause, geometry);
		}
		return result;
	}

	public int getElevenKvCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getElevenKvCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getElevenKvCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getElevenKvCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getElevenKvCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		String whereClause = "SUBTYPECD=1";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer6(Constants.MedcZone1, whereClause, geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer6(Constants.MazonZone2, whereClause, geometry);
			result = result + apiDataService.getCountByZonesFromMapServer6(Constants.TanweerZone2, whereClause, geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer6(Constants.MajanZone3, whereClause, geometry);
		}
		return result;
	}

	public int getOneVCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getOneVCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getOneVCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getOneVCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getOneVCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		String whereClause = "1=1";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer7(Constants.MedcZone1, whereClause, geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer7(Constants.MazonZone2, whereClause, geometry);
			result = result + apiDataService.getCountByZonesFromMapServer7(Constants.TanweerZone2, whereClause, geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer7(Constants.MajanZone3, whereClause, geometry);
		}
		return result;
	}
}
