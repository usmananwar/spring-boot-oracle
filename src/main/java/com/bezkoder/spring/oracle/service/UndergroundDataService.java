package com.bezkoder.spring.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.utils.Constants;
import com.bezkoder.spring.oracle.utils.QueryUtils;

@Service
public class UndergroundDataService {

	@Autowired
	ApiDataService apiDataService;

	public double getThrityThreeKvCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getThrityThreeKvCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public double getThrityThreeKvCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getThrityThreeKvCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public double getThrityThreeKvCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		String whereClause = "SUBTYPECD=2";
		double result = 0;
		if (isZone1Included) {
			result = apiDataService.getFeaturesByZonesFromMapServer6(Constants.MedcZone1, whereClause, "SHAPE_Length", geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getFeaturesByZonesFromMapServer6(Constants.MazonZone2, whereClause, "SHAPE_Length", geometry);
			result = result + apiDataService.getFeaturesByZonesFromMapServer6(Constants.TanweerZone2, whereClause, "SHAPE_Length", geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getFeaturesByZonesFromMapServer6(Constants.MajanZone3, whereClause, "SHAPE.LEN", geometry);
		}
		return result;
	}

	public double getElevenKvCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getElevenKvCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public double getElevenKvCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getElevenKvCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public double getElevenKvCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		String whereClause = "SUBTYPECD=1";
		double result = 0;
		if (isZone1Included) {
			result = apiDataService.getFeaturesByZonesFromMapServer6(Constants.MedcZone1, whereClause, "SHAPE_Length", geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getFeaturesByZonesFromMapServer6(Constants.MazonZone2, whereClause, "SHAPE_Length", geometry);
			result = result + apiDataService.getFeaturesByZonesFromMapServer6(Constants.TanweerZone2, whereClause, "SHAPE_Length", geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getFeaturesByZonesFromMapServer6(Constants.MajanZone3, whereClause, "SHAPE.LEN", geometry);
		}
		return result;
	}

	public double getOneVCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getOneVCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public double getOneVCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getOneVCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public double getOneVCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		String whereClause = "1=1";
		double result = 0;
		if (isZone1Included) {
			result = apiDataService.getFeaturesByZonesFromMapServer7(Constants.MedcZone1, whereClause, "SHAPE_Length", geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getFeaturesByZonesFromMapServer7(Constants.MazonZone2, whereClause, "SHAPE_Length", geometry);
			result = result + apiDataService.getFeaturesByZonesFromMapServer7(Constants.TanweerZone2, whereClause, "SHAPE_Length", geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getFeaturesByZonesFromMapServer7(Constants.MajanZone3, whereClause, "SHAPE.LEN", geometry);
		}
		return result;
	}
}
