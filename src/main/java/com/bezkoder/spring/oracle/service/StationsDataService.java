package com.bezkoder.spring.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.utils.Constants;

@Service
public class StationsDataService {

	@Autowired
	ApiDataService apiDataService;

	public int getGridCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		String subTypeCode = "SUBTYPECD=1";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer8(Constants.MedcZone1, subTypeCode);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MazonZone2, subTypeCode);
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.TanweerZone2, subTypeCode);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MajanZone3, subTypeCode);
		}
		return result;
	}

	public int getPrimaryCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		String subTypeCode = "SUBTYPECD=2";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer8(Constants.MedcZone1, subTypeCode);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MazonZone2, subTypeCode);
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.TanweerZone2, subTypeCode);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MajanZone3, subTypeCode);
		}
		return result;
	}

	public int getDistributionCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		String subTypeCode = "SUBTYPECD=4";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer8(Constants.MedcZone1, subTypeCode);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MazonZone2, subTypeCode + " OR SUBTYPECD=6");
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.TanweerZone2, subTypeCode + " OR SUBTYPECD=6");
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MajanZone3, subTypeCode);
		}
		return result;
	}

}
