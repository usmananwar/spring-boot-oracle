package com.bezkoder.spring.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.utils.Constants;

@Service
public class TransformerDataService {

	@Autowired
	ApiDataService apiDataService;

	public int getDssGmtCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		String subTypeCode = "SUBTYPECD%3D2";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZones(Constants.MedcZone1, subTypeCode);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZones(Constants.MazonZone2,
					"TRANSFORMERTYPE+%3D+%27TXD%27+AND+" + subTypeCode);
			result = result + apiDataService.getCountByZones(Constants.TanweerZone2, subTypeCode);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZones(Constants.MajanZone3, subTypeCode);
		}
		return result;

	}

}
