package com.bezkoder.spring.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.utils.Constants;
import com.bezkoder.spring.oracle.utils.QueryUtils;

@Service
public class PillerDataService {

	@Autowired
	ApiDataService apiDataService;

	public int getMainFeederPillarCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getMainFeederPillarCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getMainFeederPillarCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getMainFeederPillarCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getMainFeederPillarCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {

		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer3(Constants.MedcZone1, "BUSBARTYPE='MBB' AND SUBTYPECD=3", geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.MazonZone2, "BUSBARTYPE='MBB' AND SUBTYPECD=3", geometry);
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.TanweerZone2, "BUSBARTYPE='MBB' AND SUBTYPECD=3", geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.MajanZone3, "SUBTYPECD=1", geometry);
		}
		return result;
	}

	public int getMiniFeederPillarCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getMiniFeederPillarCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getMiniFeederPillarCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getMiniFeederPillarCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getMiniFeederPillarCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {

		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer3(Constants.MedcZone1, "BUSBARTYPE='MBB' AND SUBTYPECD=5", geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.MazonZone2, "BUSBARTYPE='MBB' AND SUBTYPECD=5", geometry);
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.TanweerZone2, "BUSBARTYPE='MBB' AND SUBTYPECD=5", geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.MajanZone3, "SUBTYPECD=2", geometry);
		}
		return result;
	}

	public int getCutOutBoxCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getCutOutBoxCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getCutOutBoxCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getCutOutBoxCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getCutOutBoxCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {

		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer3(Constants.MedcZone1, "BUSBARTYPE='MBB' AND SUBTYPECD=7", geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.MazonZone2, "BUSBARTYPE='MBB' AND SUBTYPECD=7", geometry);
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.TanweerZone2, "BUSBARTYPE='MBB' AND SUBTYPECD=7", geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.MajanZone3, "SUBTYPECD=3", geometry);
		}
		return result;
	}

}
