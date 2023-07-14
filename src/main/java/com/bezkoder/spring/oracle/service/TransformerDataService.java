package com.bezkoder.spring.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.utils.Constants;
import com.bezkoder.spring.oracle.utils.QueryUtils;

@Service
public class TransformerDataService {

	@Autowired
	ApiDataService apiDataService;

	public int getDssGmtCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getDssGmtCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getDssPmtCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getDssPmtCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getPowerTransformerCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getPowerTransformerCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getStationTransformerCountByZone(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included) {
		return getPowerTransformerCount(isZone1Included, isZone2Included, isZone3Included, null);
	}

	public int getDssGmtCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getDssGmtCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getDssPmtCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getDssPmtCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getPowerTransformerCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getPowerTransformerCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getStationTransformerCountByGeometry(Double xmin, Double ymin, Double xmax, Double ymax) {
		return getPowerTransformerCount(true, true, true, QueryUtils.getGeometryString(xmin, ymin, xmax, ymax));
	}

	public int getDssGmtCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		String subTypeCode = "SUBTYPECD=2";
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer2(Constants.MedcZone1, subTypeCode, geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MazonZone2, "TRANSFORMERTYPE = 'TXD' AND " + subTypeCode, geometry);
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.TanweerZone2, subTypeCode, geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MajanZone3, subTypeCode, geometry);
		}
		return result;
	}

	public int getDssPmtCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer2(Constants.MedcZone1, "SUBTYPECD=1", geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MazonZone2, "TRANSFORMERTYPE = 'TXD' AND " + "SUBTYPECD=1", geometry);
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.TanweerZone2, "SUBTYPECD=3", geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MajanZone3, "SUBTYPECD=3", geometry);
		}
		return result;
	}

	public int getPowerTransformerCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {

		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer2(Constants.MedcZone1, "SUBTYPECD=3", geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MazonZone2, "TRANSFORMERTYPE = 'TXP'", geometry);
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.TanweerZone2, "SUBTYPECD=1", geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MajanZone3, "SUBTYPECD=1", geometry);
		}
		return result;
	}

	public int getStationTransformerCount(boolean isZone1Included, boolean isZone2Included, boolean isZone3Included, String geometry) {
		int result = 0;
		if (isZone1Included) {
			result = apiDataService.getCountByZonesFromMapServer2(Constants.MedcZone1, "SUBTYPECD=4", geometry);
		}

		if (isZone2Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MazonZone2, "TRANSFORMERTYPE = 'TXS'", geometry);
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.TanweerZone2, "SUBTYPECD=4", geometry);
		}

		if (isZone3Included) {
			result = result + apiDataService.getCountByZonesFromMapServer2(Constants.MajanZone3, "SUBTYPECD=4", geometry);
		}
		return result;
	}

}
