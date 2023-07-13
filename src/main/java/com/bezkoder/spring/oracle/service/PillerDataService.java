package com.bezkoder.spring.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.utils.Constants;

@Service
public class PillerDataService {

	@Autowired
	ApiDataService apiDataService;

	public int getMainFeederPillarCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {

		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer3(Constants.MedcZone1, "BUSBARTYPE='MBB' AND SUBTYPECD=3");
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.MazonZone2, "BUSBARTYPE='MBB' AND SUBTYPECD=3");
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.TanweerZone2, "BUSBARTYPE='MBB' AND SUBTYPECD=3");
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.MajanZone3, "SUBTYPECD=1");
		}
		return result;
	}

	public int getMiniFeederPillarCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {

		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer3(Constants.MedcZone1, "BUSBARTYPE='MBB' AND SUBTYPECD=5");
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.MazonZone2, "BUSBARTYPE='MBB' AND SUBTYPECD=5");
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.TanweerZone2, "BUSBARTYPE='MBB' AND SUBTYPECD=5");
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.MajanZone3, "SUBTYPECD=2");
		}
		return result;
	}

	public int getCutOutBoxCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {

		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer3(Constants.MedcZone1, "BUSBARTYPE='MBB' AND SUBTYPECD=7");
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.MazonZone2, "BUSBARTYPE='MBB' AND SUBTYPECD=7");
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.TanweerZone2, "BUSBARTYPE='MBB' AND SUBTYPECD=7");
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer3(Constants.MajanZone3, "SUBTYPECD=3");
		}
		return result;
	}

}
