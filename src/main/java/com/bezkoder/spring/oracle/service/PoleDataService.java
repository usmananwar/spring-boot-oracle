package com.bezkoder.spring.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.utils.Constants;

@Service
public class PoleDataService {

	@Autowired
	ApiDataService apiDataService;

	public int getPoleCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		String whereClause = "1=1";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer1(Constants.MedcZone1, whereClause);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MazonZone2, whereClause);
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.TanweerZone2, whereClause);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer8(Constants.MajanZone3, whereClause);
		}
		return result;
	}
}
