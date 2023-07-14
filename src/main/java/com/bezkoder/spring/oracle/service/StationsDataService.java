package com.bezkoder.spring.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.utils.Constants;
import com.bezkoder.spring.oracle.utils.QueryUtils;

@Service
public class StationsDataService {

	@Autowired
	ApiDataService apiDataService;

	public int getGridCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getGridCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getGridCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getGridCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getGridCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		String subTypeCode = "SUBTYPECD=1";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer8(Constants.MedcZone1, subTypeCode, geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MazonZone2, subTypeCode, geometry);
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.TanweerZone2, subTypeCode, geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MajanZone3, subTypeCode, geometry);
		}
		return result;
	}

	public int getPrimaryCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getPrimaryCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getPrimaryCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getPrimaryCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getPrimaryCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		String subTypeCode = "SUBTYPECD=2";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer8(Constants.MedcZone1, subTypeCode, geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MazonZone2, subTypeCode, geometry);
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.TanweerZone2, subTypeCode, geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MajanZone3, subTypeCode, geometry);
		}
		return result;
	}

	public int getDistributionCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getDistributionCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getDistributionCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getDistributionCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getDistributionCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		String subTypeCode = "SUBTYPECD=4";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer8(Constants.MedcZone1, subTypeCode, geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MazonZone2, subTypeCode + " OR SUBTYPECD=6", geometry);
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.TanweerZone2, subTypeCode + " OR SUBTYPECD=6", geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MajanZone3, subTypeCode, geometry);
		}
		return result;
	}

}
