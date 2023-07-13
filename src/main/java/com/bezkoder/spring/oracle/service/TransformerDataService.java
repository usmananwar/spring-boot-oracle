package com.bezkoder.spring.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.utils.Constants;

@Service
public class TransformerDataService {

	@Autowired
	ApiDataService apiDataService;

	public int getDssGmtCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		String subTypeCode = "SUBTYPECD=2";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer2(Constants.MedcZone1, subTypeCode);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MazonZone2, "TRANSFORMERTYPE = 'TXD' AND " + subTypeCode);
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.TanweerZone2, subTypeCode);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MajanZone3, subTypeCode);
		}
		return result;
	}

	public int getDssPmtCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer2(Constants.MedcZone1, "SUBTYPECD=1");
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MazonZone2, "TRANSFORMERTYPE = 'TXD' AND " + "SUBTYPECD=1");
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.TanweerZone2, "SUBTYPECD=3");
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MajanZone3, "SUBTYPECD=3");
		}
		return result;
	}

	public int getPowerTransformerCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {

		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer2(Constants.MedcZone1, "SUBTYPECD=3");
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MazonZone2, "TRANSFORMERTYPE = 'TXP'");
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.TanweerZone2, "SUBTYPECD=1");
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MajanZone3, "SUBTYPECD=1");
		}
		return result;
	}

	public int getStationTransformerCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer2(Constants.MedcZone1, "SUBTYPECD=4");
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MazonZone2, "TRANSFORMERTYPE = 'TXS'");
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.TanweerZone2, "SUBTYPECD=4");
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MajanZone3, "SUBTYPECD=4");
		}
		return result;
	}

}
