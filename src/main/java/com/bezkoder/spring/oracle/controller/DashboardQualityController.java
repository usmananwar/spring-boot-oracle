package com.bezkoder.spring.oracle.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.bezkoder.spring.oracle.model.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.oracle.AssetProperty;
import com.bezkoder.spring.oracle.repository.BatteryBankRepository;
import com.bezkoder.spring.oracle.repository.BusbarRepository;
import com.bezkoder.spring.oracle.repository.CapacitorBankRepository;
import com.bezkoder.spring.oracle.repository.ControlAndRelayRepository;
import com.bezkoder.spring.oracle.repository.DynamicProtectiveDeviceRepository;
import com.bezkoder.spring.oracle.repository.FuseRepository;
import com.bezkoder.spring.oracle.repository.PillarRepository;
import com.bezkoder.spring.oracle.repository.PoleRepository;
import com.bezkoder.spring.oracle.repository.PrimaryOverheadConductorRepository;
import com.bezkoder.spring.oracle.repository.PrimaryUndergroundCableRepository;
import com.bezkoder.spring.oracle.repository.SecondaryOverheadConductorRepository;
import com.bezkoder.spring.oracle.repository.SecondaryUndergroundCableRepository;
import com.bezkoder.spring.oracle.repository.SwitchsRepository;
import com.bezkoder.spring.oracle.repository.TransformerRepository;
import com.bezkoder.spring.oracle.service.DataService;
import com.bezkoder.spring.oracle.service.ExcelService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DashboardQualityController {

	@Autowired
	TransformerRepository transformerRepository;
	@Autowired
	DynamicProtectiveDeviceRepository dynamicProtectiveDeviceRepository;
	@Autowired
	SwitchsRepository switchsRepository;
	@Autowired
	CapacitorBankRepository capacitorBankRepository;
	@Autowired
	PoleRepository poleRepository;
	@Autowired
	ControlAndRelayRepository controlAndRelayRepository;
	@Autowired
	BatteryBankRepository batteryBankRepository;
	@Autowired
	PillarRepository pillarRepository;
	@Autowired
	BusbarRepository busbarRepository;
	@Autowired
	FuseRepository fuseRepository;
	@Autowired
	SecondaryOverheadConductorRepository secondaryOverheadConductorRepository;
	@Autowired
	PrimaryOverheadConductorRepository primaryOverheadConductorRepository;
	@Autowired
	PrimaryUndergroundCableRepository primaryUndergroundCableRepository;
	@Autowired
	SecondaryUndergroundCableRepository secondaryUndergroundCableRepository;

	@Autowired
	DataService dataService;

	@Autowired
	ExcelService excelService;

	@GetMapping("/getAllAssestSummaryCount")
	public ResponseEntity<?> getAllAssestSummaryCount(@RequestParam(required = false) String fromDateString, @RequestParam(required = false) String toDateString) {
		log.info("From Date: {}, To Date: {}", fromDateString, toDateString);
		try {
			Date fromDate = null;
			Date toDate = null;
			if (StringUtils.isEmpty(fromDateString) || StringUtils.isEmpty(toDateString)) {
				fromDate = getCurrentQuarterStartDate();
				toDate = new Date();
			} else {
				fromDate = formatDate(fromDateString);
				toDate = formatDate(toDateString);
			}

			Map<String, Map<String, String>> mainResult = new HashMap<>();
			ArrayList<Map<String, String>> mainResultArrList = new ArrayList<>();

			Map<String, String> powerTransformerResult = getTransformerAverageCountResult(fromDate, toDate, 1, "TXP", "TXP", "green");
			mainResultArrList.add(powerTransformerResult);
			Map<String, String> stationTransformerResult = getTransformerAverageCountResult(fromDate, toDate, 4, "TXS", "TXS", "info");
			mainResultArrList.add(stationTransformerResult);
			Map<String, String> distributionTransformerResult = getDistributionTransformerAverageCountResult(fromDate, toDate, "TXD", Arrays.asList(2, 3));
			mainResultArrList.add(distributionTransformerResult);

			Map<String, String> circutBreakerResult = getDynamicProtectiveDeviceAverageCountResult(fromDate, toDate, 1, "CBR");
			mainResultArrList.add(circutBreakerResult);
			Map<String, String> arcResult = getDynamicProtectiveDeviceAverageCountResult(fromDate, toDate, 2, "ARC");
			mainResultArrList.add(arcResult);
			Map<String, String> rmuResult = getSwitchAverageCountResult(fromDate, toDate, 2, "RMU");
			mainResultArrList.add(rmuResult);
			Map<String, String> absResult = getSwitchAverageCountResult(fromDate, toDate, 1, "ABS");
			mainResultArrList.add(absResult);
			Map<String, String> oluResult = getSwitchAverageCountResult(fromDate, toDate, 3, "OLU");
			mainResultArrList.add(oluResult);
			Map<String, String> capacitorBankResult = getCapacitorBankAverageCountResult(fromDate, toDate, "CAP");
			mainResultArrList.add(capacitorBankResult);
			Map<String, String> poleResult = getPoleAverageCountResult(fromDate, toDate, "POL");
			mainResultArrList.add(poleResult);
			Map<String, String> controlAndRelayResult = getControlAndRelayCountResult("RCP");
			mainResultArrList.add(controlAndRelayResult);
			Map<String, String> batteryBankResult = getBatteryBankAverageCountResult(fromDate, toDate, "BBK");
			mainResultArrList.add(batteryBankResult);
			Map<String, String> pillarResult = getPillarAverageCountResult(fromDate, toDate, "PLR");
			mainResultArrList.add(pillarResult);
			Map<String, String> busbarResult = getBusbarAverageCountResult(fromDate, toDate, "BSB");
			mainResultArrList.add(busbarResult);
			Map<String, String> fuseResult = getFuseAverageCountResult(fromDate, toDate, 3, "HFU");
			mainResultArrList.add(fuseResult);
			Map<String, String> secondaryOverheadConductorResult = getSecondaryOverheadConductorAverageCountResult(fromDate, toDate, "SOC");
			mainResultArrList.add(secondaryOverheadConductorResult);
			Map<String, String> primaryOverheadConductorResult = getPrimaryOverheadConductorAverageCountResult(fromDate, toDate, "POC");
			mainResultArrList.add(primaryOverheadConductorResult);
			Map<String, String> primaryUndergroundCableResult = getPrimaryUndergroundCableAverageCountResult(fromDate, toDate, "PUC");
			mainResultArrList.add(primaryUndergroundCableResult);
			Map<String, String> secondaryUndergroundCableResult = getSecondaryUndergroundCableAverageCountResult(fromDate, toDate, "SUC");
			mainResultArrList.add(secondaryUndergroundCableResult);

			System.out.println(mainResultArrList);

			return new ResponseEntity(mainResultArrList, HttpStatus.OK);

		} catch (Exception e) {

			log.error("Excption occurred", e);
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAssetsNonAvailibiltyDetail")
	ResponseEntity<?> getAssetsNonAvailibiltyDetail(@RequestParam(required = false) String fromDateString, @RequestParam(required = false) String toDateString, @RequestParam(required = true) String assetAliasStr, @RequestParam(required = false) String subTypeCode) throws ParseException {

		log.info("From Date: {}, To Date: {}, Asset Alias: {}, SubTypeCd: {}", fromDateString, toDateString, assetAliasStr);

		Date fromDate = null;
		Date toDate = null;
		if (StringUtils.isEmpty(fromDateString) || StringUtils.isEmpty(toDateString)) {
			fromDate = getCurrentQuarterStartDate();
			toDate = new Date();
		} else {
			fromDate = formatDate(fromDateString);
			toDate = formatDate(toDateString);
		}

		List<AssetProperty> mainResult = new ArrayList<>();

		try {

			if ("TXP".equals(assetAliasStr) && subTypeCode.equals("1")) {
				mainResult = dataService.getTransformerColumnCountResult(fromDate, toDate, Arrays.asList(1));

			} else if ("TXS".equals(assetAliasStr) && subTypeCode.equals("4")) {
				mainResult = dataService.getTransformerColumnCountResult(fromDate, toDate, Arrays.asList(4));

			} else if ("TXD".equals(assetAliasStr)) {
				mainResult = dataService.getTransformerColumnCountResult(fromDate, toDate, Arrays.asList(2, 3));

			} else if ("CBR".equals(assetAliasStr) && subTypeCode.equals("1")) {
				mainResult = dataService.getDynamicProtectiveDeviceColumnCountResult(fromDate, toDate, 1);

			} else if ("ARC".equals(assetAliasStr) && subTypeCode.equals("2")) {
				mainResult = dataService.getDynamicProtectiveDeviceColumnCountResult(fromDate, toDate, 2);

			} else if ("RMU".equals(assetAliasStr) && subTypeCode.equals("2")) {
				mainResult = dataService.getSwitchColumnCountResult(fromDate, toDate, Integer.valueOf(subTypeCode));

			} else if ("ABS".equals(assetAliasStr) && subTypeCode.equals("1")) {
				mainResult = dataService.getSwitchColumnCountResult(fromDate, toDate, Integer.valueOf(subTypeCode));

			} else if ("OLU".equals(assetAliasStr) && subTypeCode.equals("3")) {
				mainResult = dataService.getSwitchColumnCountResult(fromDate, toDate, Integer.valueOf(subTypeCode));

			} else if ("BSB".equals(assetAliasStr)) {
				mainResult =  dataService.getBusbarColumnCountResult(fromDate, toDate, Arrays.asList(1, 2));

			} else if ("CAP".equals(assetAliasStr)) {
				mainResult = dataService.getCapacitorBankColumnCountResult(fromDate, toDate);

			} else if ("POL".equals(assetAliasStr)) {
				mainResult = dataService.getPoleColumnCountResult(fromDate, toDate);

			} else if ("RCP".equals(assetAliasStr)) {
				mainResult = dataService.getControlAndRelayCountResult();

			} else if ("BBK".equals(assetAliasStr)) {
				mainResult = dataService.getBatteryBankColumnCountResult(fromDate, toDate);

			} else if ("PLR".equals(assetAliasStr)) {
				mainResult = dataService.getPillarColumnCountResult(fromDate, toDate);

			} else if ("HFU".equals(assetAliasStr)) {
				mainResult = dataService.getFuseColumnCountResult(fromDate, toDate, Integer.valueOf(subTypeCode));

			} else if ("SOC".equals(assetAliasStr)) {
				mainResult = dataService.getSecondaryOverheadConductorColumnCountResult(fromDate, toDate);

			} else if ("POC".equals(assetAliasStr)) {
				mainResult = dataService.getPrimaryOverheadConductorColumnCountResult(fromDate, toDate);

			} else if ("SUC".equals(assetAliasStr)) {
				mainResult = dataService.getSecondaryUndergroundCableColumnCountResult(fromDate, toDate);

			} else if ("PUC".equals(assetAliasStr)) {
				mainResult = dataService.getPrimaryUndergroundCableColumnCountResult(fromDate, toDate);

			} else {
				throw new Exception("SubTypeCode or Asset alias not supported");
			}

			return new ResponseEntity(mainResult, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Date formatDate(String dateValue) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.parse(dateValue);
	}

	private String formatDateToSqlString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(date) + " 00:00";
	}

	@GetMapping("/downloadReport")
	public void downloadReport(@RequestParam(required = false) String fromDateString, @RequestParam(required = false) String toDateString, @RequestParam(required = true) String assetAliasStr, @RequestParam(required = false) String subTypeCode, HttpServletResponse response) throws IOException, ParseException {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=" + assetAliasStr + ".xls");

		log.info("From Date: {}, To Date: {}, SubTypeCd: {}", fromDateString, toDateString, subTypeCode);

		try {
			Date fromDate = null;
			Date toDate = null;
			if (StringUtils.isEmpty(fromDateString) || StringUtils.isEmpty(toDateString)) {
				fromDate = getCurrentQuarterStartDate();
				toDate = new Date();
			} else {
				fromDate = formatDate(fromDateString);
				toDate = formatDate(toDateString);
			}

			List<AssetProperty> mainResult = new ArrayList<>();

			if ("TXP".equals(assetAliasStr) && subTypeCode.equals("1")) {
				mainResult = dataService.getTransformerColumnCountResult(fromDate, toDate, Arrays.asList(1));

			} else if ("TXS".equals(assetAliasStr) && subTypeCode.equals("4")) {
				mainResult = dataService.getTransformerColumnCountResult(fromDate, toDate, Arrays.asList(4));

			} else if ("TXD".equals(assetAliasStr)) {
				mainResult = dataService.getTransformerColumnCountResult(fromDate, toDate, Arrays.asList(2, 4));

			} else if ("CBR".equals(assetAliasStr) && subTypeCode.equals("1")) {
				mainResult = dataService.getDynamicProtectiveDeviceColumnCountResult(fromDate, toDate, 1);

			} else if ("ARC".equals(assetAliasStr) && subTypeCode.equals("2")) {
				mainResult = dataService.getDynamicProtectiveDeviceColumnCountResult(fromDate, toDate, 2);

			} else if ("RMU".equals(assetAliasStr) && subTypeCode.equals("2")) {
				mainResult = dataService.getSwitchColumnCountResult(fromDate, toDate, Integer.valueOf(subTypeCode));

			} else if ("ABS".equals(assetAliasStr) && subTypeCode.equals("1")) {
				mainResult = dataService.getSwitchColumnCountResult(fromDate, toDate, Integer.valueOf(subTypeCode));

			} else if ("OLU".equals(assetAliasStr) && subTypeCode.equals("3")) {
				mainResult = dataService.getSwitchColumnCountResult(fromDate, toDate, Integer.valueOf(subTypeCode));

			} else if ("BSB".equals(assetAliasStr)) {
				mainResult =  dataService.getBusbarColumnCountResult(fromDate, toDate, Arrays.asList(1, 2));

			} else if ("CAP".equals(assetAliasStr)) {
				mainResult = dataService.getCapacitorBankColumnCountResult(fromDate, toDate);

			} else if ("POL".equals(assetAliasStr)) {
				mainResult = dataService.getPoleColumnCountResult(fromDate, toDate);

			} else if ("RCP".equals(assetAliasStr)) {
				mainResult = dataService.getControlAndRelayCountResult();

			} else if ("BBK".equals(assetAliasStr)) {
				mainResult = dataService.getBatteryBankColumnCountResult(fromDate, toDate);

			} else if ("PLR".equals(assetAliasStr)) {
				mainResult = dataService.getPillarColumnCountResult(fromDate, toDate);

			} else if ("HFU".equals(assetAliasStr)) {
				mainResult = dataService.getFuseColumnCountResult(fromDate, toDate, Integer.valueOf(subTypeCode));

			} else if ("SOC".equals(assetAliasStr)) {
				mainResult = dataService.getSecondaryOverheadConductorColumnCountResult(fromDate, toDate);

			} else if ("POC".equals(assetAliasStr)) {
				mainResult = dataService.getPrimaryOverheadConductorColumnCountResult(fromDate, toDate);

			} else if ("SUC".equals(assetAliasStr)) {
				mainResult = dataService.getSecondaryUndergroundCableColumnCountResult(fromDate, toDate);

			} else if ("PUC".equals(assetAliasStr)) {
				mainResult = dataService.getPrimaryUndergroundCableColumnCountResult(fromDate, toDate);

			} else {
				throw new Exception("SubTypeCode or Asset alias not supported");
			}

			HSSFWorkbook workbook = new HSSFWorkbook();
			Sheet sheet = workbook.createSheet("Sheet1");

			Row headingRow = sheet.createRow(0);
			Row valueRow = sheet.createRow(1);

			int i = 0;
			for (AssetProperty assetProperty : mainResult) {
				Cell headingCell = headingRow.createCell(i);
				headingCell.setCellValue(assetProperty.getKey());

				Cell valueCell = valueRow.createCell(i);
				valueCell.setCellValue(assetProperty.getValue());
				i++;
			}

			workbook.write(response.getOutputStream());

			// return new ResponseEntity("", HttpStatus.OK);

		} catch (Exception e) {
			// return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
			log.error("Exception", e);
		}

	}

	@GetMapping("/downloadData")
	public void downloadData(@RequestParam(required = false) String fromDateString, @RequestParam(required = false) String toDateString, @RequestParam(required = true) String assetAliasStr, @RequestParam(required = false) String subTypeCode,

			HttpServletResponse response) throws Exception {

		log.info("From Date: {}, To Date: {}, Asset Alias: {}, SubTypeCd: {}", fromDateString, toDateString, assetAliasStr, subTypeCode);

		try {
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=" + assetAliasStr + ".xls");

			Date fromDate = null;
			Date toDate = null;
			if (StringUtils.isEmpty(fromDateString) || StringUtils.isEmpty(toDateString)) {
				fromDate = getCurrentQuarterStartDate();
				toDate = new Date();
			} else {
				fromDate = formatDate(fromDateString);
				toDate = formatDate(toDateString);
			}

			HSSFWorkbook workbook = new HSSFWorkbook();

			if ("TXP".equals(assetAliasStr) && subTypeCode.equals("1")) {
				List<Transformer> transformers = dataService.getTranformersByDateAndSubTypeCd(fromDate, toDate, Arrays.asList(Integer.valueOf(subTypeCode)));
				excelService.prepareExcelForTransformersSubType1and4(transformers, workbook);

			} else if ("TXS".equals(assetAliasStr) && subTypeCode.equals("4")) {
				List<Transformer> transformers = dataService.getTranformersByDateAndSubTypeCd(fromDate, toDate, Arrays.asList(Integer.valueOf(subTypeCode)));
				excelService.prepareExcelForTransformersSubType1and4(transformers, workbook);

			} else if ("TXD".equals(assetAliasStr)) {
				List<Transformer> transformers = dataService.getTranformersByDateAndSubTypeCd(fromDate, toDate, Arrays.asList(2, 3));
				excelService.prepareExcelForTransformersSubType2Or3(transformers, workbook);

			} else if ("CBR".equals(assetAliasStr) && subTypeCode.equals("1")) {
				List<DynamicProtectiveDevice> dynamicProtectiveDevice = dataService.getDynamicProtectiveDeviceByDateAndSubTypeCd(fromDate, toDate, Integer.valueOf(subTypeCode));
				excelService.prepareExcelForDynamicProtectiveDeviceSubType1(dynamicProtectiveDevice, workbook);

			} else if ("ARC".equals(assetAliasStr) && subTypeCode.equals("2")) {
				List<DynamicProtectiveDevice> dynamicProtectiveDevice = dataService.getDynamicProtectiveDeviceByDateAndSubTypeCd(fromDate, toDate, Integer.valueOf(subTypeCode));
				excelService.prepareExcelForDynamicProtectiveDeviceSubType2(dynamicProtectiveDevice, workbook);

			} else if ("RMU".equals(assetAliasStr) && subTypeCode.equals("2")) {
				List<Switchs> switchs = dataService.getSwitchsByDateAndSubTypeCd(fromDate, toDate, Integer.valueOf(subTypeCode));
				excelService.prepareExcelForSwitchsSubType2(switchs, workbook);

			} else if ("ABS".equals(assetAliasStr) && subTypeCode.equals("1")) {
				List<Switchs> switchs = dataService.getSwitchsByDateAndSubTypeCd(fromDate, toDate, Integer.valueOf(subTypeCode));
				excelService.prepareExcelForSwitchsSubType1(switchs, workbook);

			} else if ("OLU".equals(assetAliasStr) && subTypeCode.equals("3")) {
				List<Switchs> switchs = dataService.getSwitchsByDateAndSubTypeCd(fromDate, toDate, Integer.valueOf(subTypeCode));
				excelService.prepareExcelForSwitchsSubType3(switchs, workbook);

			} else if ("BSB".equals(assetAliasStr)) {
				List<Busbar> busbar = dataService.getBusbarByDateAndSubTypeCd(fromDate, toDate,"MBB", Arrays.asList(1, 2));
				excelService.prepareExcelForBusbarSubType1or2(busbar, workbook);

			} else if ("CAP".equals(assetAliasStr)) {
				List<CapacitorBank> list = dataService.getCapacitorBankByDateAndSubTypeCd(fromDate, toDate);
				excelService.prepareExcelForCapacitorBank(list, workbook);

			} else if ("POL".equals(assetAliasStr)) {
				List<Pole> list = dataService.getPoleByDateAndSubTypeCd(fromDate, toDate);
				excelService.prepareExcelForPole(list, workbook);
			} else if ("RCP".equals(assetAliasStr)) {
				 List<ControlAndRelay> list =
				 dataService.getControlAndRelayByDateAndSubTypeCd();
				 excelService.prepareExcelForControlAndRelay(list, workbook);
			} else if ("BBK".equals(assetAliasStr)) {
				List<BatteryBank> list = dataService.getBatteryBankByDateAndSubTypeCd(fromDate, toDate);
				excelService.prepareExcelForBatteryBank(list, workbook);
			} else if ("PLR".equals(assetAliasStr)) {
				List<Pillar> list = dataService.getPillarByDate(fromDate, toDate);
				excelService.prepareExcelForPillar(list, workbook);
			} else if ("HFU".equals(assetAliasStr)) {
				List<Fuse> list = dataService.getFuseByDateAndSubTypeCd(fromDate, toDate, Integer.valueOf(subTypeCode));
				excelService.prepareExcelForHFU(list, workbook);
			} else if ("SOC".equals(assetAliasStr)) {
				List<SecondaryOverheadConductor> list = dataService.getSecondaryOverheadCounductorByDate(fromDate, toDate);
				excelService.prepareExcelForSecondaryOverhead(list, workbook);
			} else if ("POC".equals(assetAliasStr)) {
				List<PrimaryOverheadConductor> list = dataService.getPrimaryOverheadCounductorByDate(fromDate, toDate);
				excelService.prepareExcelForPrimaryOverheadConductor(list, workbook);
			} else if ("SUC".equals(assetAliasStr)) {
				List<SecondaryUndergroundCable> list = dataService.getSeondaryUndergroundCableByDate(fromDate, toDate);
				excelService.prepareExcelForSeondaryUndergroundCable(list, workbook);
			} else if ("PUC".equals(assetAliasStr)) {
				List<PrimaryUndergroundCable> list = dataService.getPrimaryUndergroundCableByDate(fromDate, toDate);
				excelService.prepareExcelForPrimaryUndergroundCable(list, workbook);
			} else {
				throw new Exception("SubTypeCode or Asset alias not supported");
			}

			workbook.write(response.getOutputStream());

			// return new ResponseEntity("", HttpStatus.OK);

		} catch (Exception e) {
			log.error("Exception", e);
			// return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	private Date getCurrentQuarterStartDate() {
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		// Subtracting time
		cal.add(Calendar.MONTH, -5);
		// convert calendar to date
		return cal.getTime();
	}

	private Map<String, String> getTransformerAverageCountResult(Date fromDate, Date toDate, Integer subTypeCd, String assetName, String assetAlias, String assetColor) throws ParseException {

		long totalRecord = 0;
		long installationDateNullCount = 0;
		long manufactureYearNullCount = 0;
		long manufacturerNullCount = 0;
		long serialNumberNullCount = 0;
		long vectorGroupNullCount = 0;
		long lowSideVoltageNullCount = 0;
		long highSideVoltageNullCount = 0;
		long ratingNullCount = 0;
		long coolingTypeNullCount = 0;
		long impedanceNullCount = 0;
		long eastingNullCount = 0;
		long northingNullCount = 0;
		long hvRatedCurrentNullCount = 0;
		long lvRatedCurrentNullCount = 0;
		long oltcManufacturerNullCount = 0;
		long oltcManufacturerYearNullCount = 0;
		long oltcTypeNullCount = 0;
		long oltcTapsNoNullCount = 0;
		long oltcSerialNumberNullCount = 0;
		long insulationNullCount = 0;

		totalRecord = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdIn(fromDate, toDate, Arrays.asList(subTypeCd));
		installationDateNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndInstallationDateIsNullAndSubtypeCdIn(fromDate, toDate, Arrays.asList(subTypeCd));
		manufactureYearNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndManufacturingYearIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		manufacturerNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndManufacturerIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		serialNumberNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndSerialNumberIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		vectorGroupNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndVectorGroupIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		lowSideVoltageNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndLowSideVoltageIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		highSideVoltageNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndHighSideVoltageIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		ratingNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndRatingIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		coolingTypeNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndCoolingTypeIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		impedanceNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndImpedanceIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
//		eastingNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndEastingIsNull(Date fromDate, Date toDate,,subTypeCd);
//		northingNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndNorthingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam,subTypeCd);
		hvRatedCurrentNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndHvRatedCurrentIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		lvRatedCurrentNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndLvRatedCurrentIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		oltcManufacturerNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcManufacturerIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		oltcManufacturerYearNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcManufacturerYearIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		oltcTypeNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcTypeIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
//		oltcTapsNoNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcTapsNoIsNullOrInstallationDateBetweenAndOltcTapsNo(fromDate, toDate, Arrays.asList(subTypeCd), fromDate, toDate, "Not Applicable");
		oltcTapsNoNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcTapsNoIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		oltcSerialNumberNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcSerialNumberIsNull(fromDate, toDate, Arrays.asList(subTypeCd));
		insulationNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndInsulationIsNull(fromDate, toDate, Arrays.asList(subTypeCd));

		ArrayList<Double> transformers = new ArrayList<Double>();

		if (totalRecord > 0) {

			transformers.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) serialNumberNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) vectorGroupNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) lowSideVoltageNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) highSideVoltageNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) ratingNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) coolingTypeNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) impedanceNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) eastingNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) northingNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) hvRatedCurrentNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) lvRatedCurrentNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) oltcManufacturerNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) oltcManufacturerYearNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) oltcTypeNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) oltcTapsNoNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) oltcSerialNumberNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) insulationNullCount / totalRecord) * 100));
		}

		ArrayList<String> resultArrayStr = summaryList(transformers);
//		System.out.println(transformers);

		Map<String, String> result = new HashMap<>();
//		Long.toString(transformerRepository.count());
		result.put("assetName", assetName);
		// result.put("assetAlias", assetAlias);
		// result.put("assetColor", assetColor);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getDistributionTransformerAverageCountResult(Date fromDate, Date toDate, String assetName, List<Integer> subTypeCd) {

		ArrayList<Double> transformers = new ArrayList<Double>();

		long totalRecord = 0;
		long installationDateNullCount = 0;
		long manufactureYearNullCount = 0;
		long manufacturerNullCount = 0;
		long serialNumberNullCount = 0;
		long vectorGroupNullCount = 0;
		long lowSideVoltageNullCount = 0;
		long highSideVoltageNullCount = 0;
		long ratingNullCount = 0;
		long coolingTypeNullCount = 0;
		long impedanceNullCount = 0;
		long eastingNullCount = 0;
		long northingNullCount = 0;
		long hvRatedCurrentNullCount = 0;
		long lvRatedCurrentNullCount = 0;
		long oltcManufacturerNullCount = 0;
		long oltcManufacturerYearNullCount = 0;
		long oltcTypeNullCount = 0;
		long oltcTapsNoNullCount = 0;
		long oltcSerialNumberNullCount = 0;
		long insulationNullCount = 0;

		totalRecord = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdIn(fromDate, toDate, Arrays.asList(2, 3));
		installationDateNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndInstallationDateIsNullAndSubtypeCdIn(fromDate, toDate, Arrays.asList(2, 3));
		manufactureYearNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndManufacturingYearIsNull(fromDate, toDate, Arrays.asList(2, 3));
		manufacturerNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndManufacturerIsNull(fromDate, toDate, Arrays.asList(2, 3));
		serialNumberNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndSerialNumberIsNull(fromDate, toDate, Arrays.asList(2, 3));
		vectorGroupNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndVectorGroupIsNull(fromDate, toDate, Arrays.asList(2, 3));
		lowSideVoltageNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndLowSideVoltageIsNull(fromDate, toDate, Arrays.asList(2, 3));
		highSideVoltageNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndHighSideVoltageIsNull(fromDate, toDate, Arrays.asList(2, 3));
		ratingNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndRatingIsNull(fromDate, toDate, Arrays.asList(2, 3));
		coolingTypeNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndCoolingTypeIsNull(fromDate, toDate, Arrays.asList(2, 3));
		impedanceNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndImpedanceIsNull(fromDate, toDate, Arrays.asList(2, 3));
//		eastingNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndEastingIsNull(Date fromDate, Date toDate,,subTypeCd);
//		northingNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndNorthingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam,subTypeCd);
		hvRatedCurrentNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndHvRatedCurrentIsNull(fromDate, toDate, Arrays.asList(2, 3));
		lvRatedCurrentNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndLvRatedCurrentIsNull(fromDate, toDate, Arrays.asList(2, 3));
		oltcManufacturerNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcManufacturerIsNull(fromDate, toDate, Arrays.asList(2, 3));
		oltcManufacturerYearNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcManufacturerYearIsNull(fromDate, toDate, Arrays.asList(2, 3));
		oltcTypeNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcTypeIsNull(fromDate, toDate, Arrays.asList(2, 3));
//		oltcTapsNoNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcTapsNoIsNullOrInstallationDateBetweenAndOltcTapsNo(fromDate, toDate, Arrays.asList(2, 3), fromDate, toDate, "Not Applicable");
		oltcTapsNoNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcTapsNoIsNull(fromDate, toDate, Arrays.asList(2, 3));
		oltcSerialNumberNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcSerialNumberIsNull(fromDate, toDate, Arrays.asList(2, 3));
		insulationNullCount = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndInsulationIsNull(fromDate, toDate, Arrays.asList(2, 3));

		if (totalRecord > 0) {

			transformers.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) serialNumberNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) vectorGroupNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) lowSideVoltageNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) highSideVoltageNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) ratingNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) coolingTypeNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) impedanceNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) eastingNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) northingNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) hvRatedCurrentNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) lvRatedCurrentNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) oltcManufacturerNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) oltcManufacturerYearNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) oltcTypeNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) oltcTapsNoNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) oltcSerialNumberNullCount / totalRecord) * 100));
			transformers.add(Double.valueOf(((double) insulationNullCount / totalRecord) * 100));

		}
		ArrayList<String> resultArrayStr = summaryList(transformers);
//		System.out.println(transformers);

		Map<String, String> result = new HashMap<>();
//		Long.toString(transformerRepository.count());
		result.put("assetName", assetName);
		// result.put("assetAlias", assetAlias);
		// result.put("assetColor", assetColor);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getDynamicProtectiveDeviceAverageCountResult(Date fromDate, Date toDate, Integer subTypeCd, String assetName) {

		ArrayList<Double> dynamicProtectiveDevice = new ArrayList<Double>();
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		// Subtracting time
		cal.add(Calendar.MONTH, -20);
		// convert calendar to date
		Date currentQuarterDate = cal.getTime();
		long totalRecord = 0;
		long eastingNullCount = 0;
		long northingNullCount = 0;
		long installationDateNullCount = 0;
		long manufacturerNullCount = 0;
		long manufactureYearNullCount = 0;
		long currentRatingNullCount = 0;
		long nominalVoltageNullCount = 0;
		long typeNullCount = 0;
		long serialNumberNullCount = 0;
		long interruptingMediumNullCount = 0;

		totalRecord = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCd(fromDate, toDate, subTypeCd);
//		eastingNullCount = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndEastingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam,subTypeCd);
//		northingNullCount = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndNorthingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam,subTypeCd);
		installationDateNullCount = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndInstallationDateIsNull(fromDate, toDate, subTypeCd);
		manufacturerNullCount = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndManufacturerIsNull(fromDate, toDate, subTypeCd);
		manufactureYearNullCount = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndManufacturingYearIsNull(fromDate, toDate, subTypeCd);
		currentRatingNullCount = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndCurrentRattingIsNull(fromDate, toDate, subTypeCd);
		nominalVoltageNullCount = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndNominalVoltageIsNull(fromDate, toDate, subTypeCd);
		typeNullCount = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndTypeIsNull(fromDate, toDate, subTypeCd);
		serialNumberNullCount = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndSerialNumberIsNull(fromDate, toDate, subTypeCd);
		interruptingMediumNullCount = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndInterruptingMediumIsNull(fromDate, toDate, subTypeCd);

		if (totalRecord > 0) {

			dynamicProtectiveDevice.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			dynamicProtectiveDevice.add(Double.valueOf(((double) eastingNullCount / totalRecord) * 100));
			dynamicProtectiveDevice.add(Double.valueOf(((double) northingNullCount / totalRecord) * 100));
			dynamicProtectiveDevice.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			dynamicProtectiveDevice.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			dynamicProtectiveDevice.add(Double.valueOf(((double) currentRatingNullCount / totalRecord) * 100));
			dynamicProtectiveDevice.add(Double.valueOf(((double) nominalVoltageNullCount / totalRecord) * 100));
			if (subTypeCd == 1) {
				dynamicProtectiveDevice.add(Double.valueOf(((double) typeNullCount / totalRecord) * 100));
				dynamicProtectiveDevice.add(Double.valueOf(((double) serialNumberNullCount / totalRecord) * 100));
			}
			if (subTypeCd == 2) {
				dynamicProtectiveDevice.add(Double.valueOf(((double) interruptingMediumNullCount / totalRecord) * 100));
			}

		}
		ArrayList<String> resultArrayStr = summaryList(dynamicProtectiveDevice);

		Map<String, String> result = new HashMap<>();
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getSwitchAverageCountResult(Date fromDate, Date toDate, Integer subTypeCd, String assetName) {

		ArrayList<Double> switchs = new ArrayList<Double>();
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		// Subtracting time
		cal.add(Calendar.MONTH, -20);
		// convert calendar to date
		Date currentQuarterDate = cal.getTime();
		long totalRecord = 0;
		long eastingNullCount = 0;
		long northingNullCount = 0;
		long installationDateNullCount = 0;
		long manufacturerNullCount = 0;
		long manufactureYearNullCount = 0;
		long currentRatingNullCount = 0;
		long nominalVoltageNullCount = 0;
		long modelNullCount = 0;
		long serialNumberNullCount = 0;
		long mountingTypeNullCount = 0;

		totalRecord = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCd(fromDate, toDate, subTypeCd);
//		eastingNullCount = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndEastingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam,subTypeCd);
//		northingNullCount = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndNorthingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam,subTypeCd);
		installationDateNullCount = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndInstallationDateIsNull(fromDate, toDate, subTypeCd);
		manufacturerNullCount = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndManufacturerIsNull(fromDate, toDate, subTypeCd);
		manufactureYearNullCount = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndManufacturingYearIsNull(fromDate, toDate, subTypeCd);
		currentRatingNullCount = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndCurrentRattingIsNull(fromDate, toDate, subTypeCd);
		nominalVoltageNullCount = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndNominalVoltageIsNull(fromDate, toDate, subTypeCd);
		modelNullCount = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndModelIsNull(fromDate, toDate, subTypeCd);
		serialNumberNullCount = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndSerialNumberIsNull(fromDate, toDate, subTypeCd);
		mountingTypeNullCount = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndMountingTypeIsNull(fromDate, toDate, subTypeCd);

		if (totalRecord > 0) {

			switchs.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			switchs.add(Double.valueOf(((double) eastingNullCount / totalRecord) * 100));
			switchs.add(Double.valueOf(((double) northingNullCount / totalRecord) * 100));
			switchs.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			switchs.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			switchs.add(Double.valueOf(((double) currentRatingNullCount / totalRecord) * 100));
			switchs.add(Double.valueOf(((double) nominalVoltageNullCount / totalRecord) * 100));
			if (subTypeCd == 2) {
				switchs.add(Double.valueOf(((double) modelNullCount / totalRecord) * 100));
				switchs.add(Double.valueOf(((double) serialNumberNullCount / totalRecord) * 100));
			}
			if (subTypeCd == 1) {
				switchs.add(Double.valueOf(((double) mountingTypeNullCount / totalRecord) * 100));
			}
			if (subTypeCd == 3) {
				switchs.add(Double.valueOf(((double) serialNumberNullCount / totalRecord) * 100));
			}

		}

		ArrayList<String> resultArrayStr = summaryList(switchs);

		Map<String, String> result = new HashMap<>();
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getCapacitorBankAverageCountResult(Date fromDate, Date toDate, String assetName) {

		ArrayList<Double> capacitorBank = new ArrayList<Double>();
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		// Subtracting time
		cal.add(Calendar.MONTH, -20);
		// convert calendar to date
		Date currentQuarterDate = cal.getTime();
		long totalRecord = 0;
		long eastingNullCount = 0;
		long northingNullCount = 0;
		long installationDateNullCount = 0;
		long manufacturerNullCount = 0;
		long manufactureYearNullCount = 0;
		long currentRatingNullCount = 0;
		long nominalVoltageNullCount = 0;
		long typeNullCount = 0;
		long serialNumberNullCount = 0;
		long ratingMVARNullCount = 0;

		totalRecord = capacitorBankRepository.countCapacitorBankByInstallationDateBetween(fromDate, toDate);
//		eastingNullCount = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndEastingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam);
//		northingNullCount = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndNorthingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam);
		installationDateNullCount = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		manufacturerNullCount = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYearNullCount = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		nominalVoltageNullCount = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndNominalVoltageIsNull(fromDate, toDate);
		typeNullCount = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndTypeIsNull(fromDate, toDate);
		serialNumberNullCount = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndSerialNumberIsNull(fromDate, toDate);
		ratingMVARNullCount = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndRatingMVARIsNull(fromDate, toDate);

		if (totalRecord > 0) {
			capacitorBank.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			capacitorBank.add(Double.valueOf(((double) eastingNullCount / totalRecord) * 100));
			capacitorBank.add(Double.valueOf(((double) northingNullCount / totalRecord) * 100));
			capacitorBank.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			capacitorBank.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			capacitorBank.add(Double.valueOf(((double) currentRatingNullCount / totalRecord) * 100));
			capacitorBank.add(Double.valueOf(((double) nominalVoltageNullCount / totalRecord) * 100));
			capacitorBank.add(Double.valueOf(((double) typeNullCount / totalRecord) * 100));
			capacitorBank.add(Double.valueOf(((double) serialNumberNullCount / totalRecord) * 100));
			capacitorBank.add(Double.valueOf(((double) ratingMVARNullCount / totalRecord) * 100));

		}
		ArrayList<String> resultArrayStr = summaryList(capacitorBank);

		Map<String, String> result = new HashMap<>();
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getPoleAverageCountResult(Date fromDate, Date toDate, String assetName) {

		ArrayList<Double> pole = new ArrayList<Double>();

		long totalRecord = 0;
		long eastingNullCount = 0;
		long northingNullCount = 0;
		long heightNullCount = 0;
		long installationDateNullCount = 0;
		long manufacturerNullCount = 0;
		long manufactureYearNullCount = 0;
		long foundationTypeNullCount = 0;
		long materialNullCount = 0;
		long subTypeCdNullCount = 0;

		totalRecord = poleRepository.countPoleByInstallationDateBetween(fromDate, toDate);
//		eastingNullCount = poleRepository.countPoleByInstallationDateBetweenAndEastingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam);
//		northingNullCount = poleRepository.countPoleByInstallationDateBetweenAndNorthingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam);
		heightNullCount = poleRepository.countPoleByInstallationDateBetweenAndHeightIsNull(fromDate, toDate);
		installationDateNullCount = poleRepository.countPoleByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		manufacturerNullCount = poleRepository.countPoleByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYearNullCount = poleRepository.countPoleByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		foundationTypeNullCount = poleRepository.countPoleByInstallationDateBetweenAndFoundationTypeIsNull(fromDate, toDate);
		materialNullCount = poleRepository.countPoleByInstallationDateBetweenAndMaterialIsNull(fromDate, toDate);
		subTypeCdNullCount = poleRepository.countPoleByInstallationDateBetweenAndSubtypeCdIsNull(fromDate, toDate);

		if (totalRecord > 0) {
			pole.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			pole.add(Double.valueOf(((double) eastingNullCount / totalRecord) * 100));
			pole.add(Double.valueOf(((double) northingNullCount / totalRecord) * 100));
			pole.add(Double.valueOf(((double) heightNullCount / totalRecord) * 100));
			pole.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			pole.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			pole.add(Double.valueOf(((double) foundationTypeNullCount / totalRecord) * 100));
			pole.add(Double.valueOf(((double) materialNullCount / totalRecord) * 100));
			pole.add(Double.valueOf(((double) subTypeCdNullCount / totalRecord) * 100));

		}
		ArrayList<String> resultArrayStr = summaryList(pole);

		Map<String, String> result = new HashMap<>();
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getControlAndRelayCountResult(String assetName) {

		ArrayList<Double> controlAndRelayArrList = new ArrayList<Double>();
		long totalRecord = 0;
		long manufacturerNullCount = 0;
		long controlVoltageNullCount = 0;

		totalRecord = controlAndRelayRepository.count();
		manufacturerNullCount = controlAndRelayRepository.countControlAndRelayByManufacturerIsNull();
		controlVoltageNullCount = controlAndRelayRepository.countControlAndRelayByControlVoltageIsNull();

		if (totalRecord > 0) {
			controlAndRelayArrList.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			controlAndRelayArrList.add(Double.valueOf(((double) controlVoltageNullCount / totalRecord) * 100));
		}
		ArrayList<String> resultArrayStr = summaryList(controlAndRelayArrList);

		Map<String, String> result = new HashMap<>();
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getBatteryBankAverageCountResult(Date fromDate, Date toDate, String assetName) {

		ArrayList<Double> batteryBankArrList = new ArrayList<Double>();

		long totalRecord = 0;
		long eastingNullCount = 0;
		long northingNullCount = 0;
		long installationDateNullCount = 0;
		long manufacturerNullCount = 0;
		long manufactureYearNullCount = 0;
		long cellRatedVoltageNullCount = 0;
		long batteryTypeNullCount = 0;
		long serialNumberNullCount = 0;
		long batteryAmpHourNullCount = 0;
		long batteryCountNullCount = 0;
		long batteryChargerAcInputVoltageNullCount = 0;
		long batteryChargerAcInputCurrentNullCount = 0;
		long batteryChargerDcOutputVoltageNullCount = 0;
		long batteryChargerDcOutputCurrentNullCount = 0;
		long batteryChargerManufacturerNullCount = 0;
		long batteryChargerManufacturingYearNullCount = 0;
		long batteryChargerTypeNullCount = 0;
		long batteryChargerSerialNumberNullCount = 0;

		totalRecord = batteryBankRepository.countBatteryBankByInstallationDateBetween(fromDate, toDate);
//		eastingNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndEastingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam);
//		northingNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndNorthingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam);
		installationDateNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		manufacturerNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYearNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		cellRatedVoltageNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndCellRatedVoltageIsNull(fromDate, toDate);
		batteryTypeNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryTypeIsNull(fromDate, toDate);
		serialNumberNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndSerialNumberIsNull(fromDate, toDate);
		batteryAmpHourNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryAmpHourIsNull(fromDate, toDate);
		batteryCountNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryCountIsNull(fromDate, toDate);
		batteryChargerAcInputVoltageNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerAcInputVoltageIsNull(fromDate, toDate);
		batteryChargerAcInputCurrentNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerAcInputCurrentIsNull(fromDate, toDate);
		batteryChargerDcOutputVoltageNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerDcOutputVoltageIsNull(fromDate, toDate);
		batteryChargerDcOutputCurrentNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerDcOutputCurrentIsNull(fromDate, toDate);
		batteryChargerManufacturerNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerManufacturerIsNull(fromDate, toDate);
		batteryChargerManufacturingYearNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerManufacturingYearIsNull(fromDate, toDate);
		batteryChargerTypeNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerTypeIsNull(fromDate, toDate);
		batteryChargerSerialNumberNullCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerSerialNumberIsNull(fromDate, toDate);

		if (totalRecord > 0) {
			batteryBankArrList.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) eastingNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) northingNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) cellRatedVoltageNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) batteryTypeNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) serialNumberNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) batteryAmpHourNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) batteryCountNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) batteryChargerAcInputVoltageNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) batteryChargerAcInputCurrentNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) batteryChargerDcOutputVoltageNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) batteryChargerDcOutputCurrentNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) batteryChargerManufacturerNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) batteryChargerManufacturingYearNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) batteryChargerTypeNullCount / totalRecord) * 100));
			batteryBankArrList.add(Double.valueOf(((double) batteryChargerSerialNumberNullCount / totalRecord) * 100));

		}
		ArrayList<String> resultArrayStr = summaryList(batteryBankArrList);

		Map<String, String> result = new HashMap<>();
//		Long.toString(batteryBankRepository.count());
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getPillarAverageCountResult(Date fromDate, Date toDate, String assetName) {

		ArrayList<Double> pillar = new ArrayList<Double>();
		long totalRecord = 0;
		long eastingNullCount = 0;
		long northingNullCount = 0;
		long installationDateNullCount = 0;
		long manufacturerNullCount = 0;
		long manufactureYearNullCount = 0;
		long currentRatingNullCount = 0;
		long nominalVoltageNullCount = 0;
		long typeNullCount = 0;
		long serialNumberNullCount = 0;

		totalRecord = pillarRepository.countPillarByInstallationDateBetween(fromDate, toDate);
//		eastingNullCount = pillarRepository.countPillarByInstallationDateBetweenAndEastingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam);
//		northingNullCount = pillarRepository.countPillarByInstallationDateBetweenAndNorthingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam);
		installationDateNullCount = pillarRepository.countPillarByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		manufacturerNullCount = pillarRepository.countPillarByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYearNullCount = pillarRepository.countPillarByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		currentRatingNullCount = pillarRepository.countPillarByInstallationDateBetweenAndCurrentRatingIsNull(fromDate, toDate);
		nominalVoltageNullCount = pillarRepository.countPillarByInstallationDateBetweenAndNominalVoltageIsNull(fromDate, toDate);
		typeNullCount = pillarRepository.countPillarByInstallationDateBetweenAndTypeIsNull(fromDate, toDate);
		serialNumberNullCount = pillarRepository.countPillarByInstallationDateBetweenAndSerialNumberIsNull(fromDate, toDate);

		if (totalRecord > 0) {
			pillar.add(Double.valueOf(((double) eastingNullCount / totalRecord) * 100));
			pillar.add(Double.valueOf(((double) northingNullCount / totalRecord) * 100));
			pillar.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			pillar.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			pillar.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			pillar.add(Double.valueOf(((double) currentRatingNullCount / totalRecord) * 100));
			pillar.add(Double.valueOf(((double) nominalVoltageNullCount / totalRecord) * 100));
			pillar.add(Double.valueOf(((double) typeNullCount / totalRecord) * 100));
			pillar.add(Double.valueOf(((double) serialNumberNullCount / totalRecord) * 100));

		}
		ArrayList<String> resultArrayStr = summaryList(pillar);
//		System.out.println("Pillar = " +pillar.size());

		Map<String, String> result = new HashMap<>();
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getBusbarAverageCountResult(Date fromDate, Date toDate, String assetName) {

		ArrayList<Double> busbar = new ArrayList<Double>();

		long totalRecord = 0;
		long eastingNullCount = 0;
		long northingNullCount = 0;
		long installationDateNullCount = 0;
		long manufacturerNullCount = 0;
		long manufactureYearNullCount = 0;
		long currentRatingNullCount = 0;
		long nominalVoltageNullCount = 0;
		long busbarTypeNullCount = 0;

		totalRecord = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdIn(fromDate, toDate, "MBB", Arrays.asList(1, 2));

//		eastingNullCount = busbarRepository.findEastingIsNull(installationDateParam == null ? stringCurrentQuarterDate: installationDateParam);
//		northingNullCount = busbarRepository.findNorthingIsNull(installationDateParam == null ? stringCurrentQuarterDate: installationDateParam);
		installationDateNullCount = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndInstallationDateIsNull(fromDate, toDate, "MBB", Arrays.asList(1, 2));

		manufactureYearNullCount = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndManufacturingYearIsNull(fromDate, toDate, "MBB", Arrays.asList(1, 2));
		manufacturerNullCount = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndManufacturerIsNull(fromDate, toDate, "MBB", Arrays.asList(1, 2));

		currentRatingNullCount = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndCurrentRatingIsNull(fromDate, toDate, "MBB", Arrays.asList(1, 2));
		nominalVoltageNullCount = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndNominalVoltageIsNull(fromDate, toDate, "MBB", Arrays.asList(1, 2));
		busbarTypeNullCount = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndBusbarTypeIsNull(fromDate, toDate, "MBB", Arrays.asList(1, 2));

		if (totalRecord > 0) {
			busbar.add(Double.valueOf(((double) eastingNullCount / totalRecord) * 100));
			busbar.add(Double.valueOf(((double) northingNullCount / totalRecord) * 100));
			busbar.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			busbar.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			busbar.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			busbar.add(Double.valueOf(((double) currentRatingNullCount / totalRecord) * 100));
			busbar.add(Double.valueOf(((double) nominalVoltageNullCount / totalRecord) * 100));
			busbar.add(Double.valueOf(((double) busbarTypeNullCount / totalRecord) * 100));

		}
		ArrayList<String> resultArrayStr = summaryList(busbar);

		Map<String, String> result = new HashMap<>();
//		Long.toString(busbarRepository.count());
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getFuseAverageCountResult(Date fromDate, Date toDate, Integer subTypeCd, String assetName) {

		ArrayList<Double> fuse = new ArrayList<Double>();

		long totalRecord = 0;
		long eastingNullCount = 0;
		long northingNullCount = 0;
		long installationDateNullCount = 0;
		long manufactureYearNullCount = 0;
		long manufacturerNullCount = 0;
		long currentRatingNullCount = 0;
		long nominalVoltageNullCount = 0;
		long serialNumberNullCount = 0;

		totalRecord = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCd(fromDate, toDate, subTypeCd);
//		eastingNullCount = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndEastingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam,subTypeCd);
//		northingNullCount = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndNorthingIsNull(installationDateParam == null ? currentQuarterDate: installationDateParam,subTypeCd);
		installationDateNullCount = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndInstallationDateIsNull(fromDate, toDate, subTypeCd);
		manufactureYearNullCount = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndManufacturingYearIsNull(fromDate, toDate, subTypeCd);
		manufacturerNullCount = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndManufacturerIsNull(fromDate, toDate, subTypeCd);
		currentRatingNullCount = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndCurrentRatingIsNull(fromDate, toDate, subTypeCd);
		nominalVoltageNullCount = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndNominalVoltageIsNull(fromDate, toDate, subTypeCd);
		serialNumberNullCount = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndSerialNumberIsNull(fromDate, toDate, subTypeCd);

		if (totalRecord > 0) {
			fuse.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			fuse.add(Double.valueOf(((double) eastingNullCount / totalRecord) * 100));
			fuse.add(Double.valueOf(((double) northingNullCount / totalRecord) * 100));
			fuse.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			fuse.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			fuse.add(Double.valueOf(((double) currentRatingNullCount / totalRecord) * 100));
			fuse.add(Double.valueOf(((double) nominalVoltageNullCount / totalRecord) * 100));
			fuse.add(Double.valueOf(((double) serialNumberNullCount / totalRecord) * 100));

		}
		ArrayList<String> resultArrayStr = summaryList(fuse);
		System.out.println("Fuse = " + fuse.size());

		Map<String, String> result = new HashMap<>();
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getSecondaryOverheadConductorAverageCountResult(Date fromDate, Date toDate, String assetName) {

		ArrayList<Double> secondaryOverheadConductor = new ArrayList<Double>();
		long totalRecord = 0;

		long installationDateNullCount = 0;
		long conductorSizeNullCount = 0;
		long manufacturerNullCount = 0;
		long manufactureYearNullCount = 0;
		long currentRatingNullCount = 0;
		long nominalVoltageNullCount = 0;
		long shapeLengthNullCount = 0;
		long conductorTypeNullCount = 0;

		totalRecord = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetween(fromDate, toDate);
		installationDateNullCount = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		conductorSizeNullCount = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndConductorSizeIsNull(fromDate, toDate);
		manufacturerNullCount = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYearNullCount = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		nominalVoltageNullCount = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndNominalVoltageIsNull(fromDate, toDate);
		currentRatingNullCount = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndCurrentRatingIsNull(fromDate, toDate);
		//shapeLengthNullCount = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndShapeLengthIsNull(fromDate, toDate);
		conductorTypeNullCount = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndConductorTypeIsNull(fromDate, toDate);

		if (totalRecord > 0) {

			secondaryOverheadConductor.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			secondaryOverheadConductor.add(Double.valueOf(((double) conductorSizeNullCount / totalRecord) * 100));
			secondaryOverheadConductor.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			secondaryOverheadConductor.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			secondaryOverheadConductor.add(Double.valueOf(((double) currentRatingNullCount / totalRecord) * 100));
			secondaryOverheadConductor.add(Double.valueOf(((double) nominalVoltageNullCount / totalRecord) * 100));
			//secondaryOverheadConductor.add(Double.valueOf(((double) shapeLengthNullCount / totalRecord) * 100));
			secondaryOverheadConductor.add(Double.valueOf(((double) conductorTypeNullCount / totalRecord) * 100));

		}
		ArrayList<String> resultArrayStr = summaryList(secondaryOverheadConductor);
		System.out.println("secondaryOverheadConductor = " + secondaryOverheadConductor.size());

		Map<String, String> result = new HashMap<>();
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getPrimaryOverheadConductorAverageCountResult(Date fromDate, Date toDate, String assetName) {

		ArrayList<Double> primaryOverheadConductor = new ArrayList<Double>();
		long totalRecord = 0;

		long installationDateNullCount = 0;
		long conductorSizeNullCount = 0;
		long manufacturerNullCount = 0;
		long manufactureYearNullCount = 0;
		long carryingCapacityNullCount = 0;
		long nominalVoltageNullCount = 0;
		long conductorTypeNullCount = 0;

		totalRecord = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetween(fromDate, toDate);
		installationDateNullCount = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		conductorSizeNullCount = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndConductorSizeIsNull(fromDate, toDate);
		manufacturerNullCount = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYearNullCount = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		nominalVoltageNullCount = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndNominalVoltageIsNull(fromDate, toDate);
		carryingCapacityNullCount = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndCurrentCarryingCapacityIsNull(fromDate, toDate);
		conductorTypeNullCount = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndConductorTypeIsNull(fromDate, toDate);
		if (totalRecord > 0) {
			primaryOverheadConductor.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			primaryOverheadConductor.add(Double.valueOf(((double) conductorSizeNullCount / totalRecord) * 100));
			primaryOverheadConductor.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			primaryOverheadConductor.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			primaryOverheadConductor.add(Double.valueOf(((double) carryingCapacityNullCount / totalRecord) * 100));
			primaryOverheadConductor.add(Double.valueOf(((double) nominalVoltageNullCount / totalRecord) * 100));
			primaryOverheadConductor.add(Double.valueOf(((double) conductorTypeNullCount / totalRecord) * 100));

		}
		ArrayList<String> resultArrayStr = summaryList(primaryOverheadConductor);
		System.out.println("primaryOverheadConductor = " + primaryOverheadConductor.size());

		Map<String, String> result = new HashMap<>();
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getPrimaryUndergroundCableAverageCountResult(Date fromDate, Date toDate, String assetName) {

		ArrayList<Double> primaryUndergroundCable = new ArrayList<Double>();
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		// Subtracting time
		cal.add(Calendar.MONTH, -20);
		// convert calendar to date
		Date currentQuarterDate = cal.getTime();
		long totalRecord = 0;

		long installationDateNullCount = 0;
		long manufactureYearNullCount = 0;
		long manufacturerNullCount = 0;
		long nominalVoltageNullCount = 0;
		long conductorSizeNullCount = 0;
		long numberOfForcesNullCount = 0;
		//long shapeLengthNullCount = 0;
		long carryingCapacityNullCount = 0;
		long conductorMaterialNullCount = 0;

		totalRecord = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetween(fromDate, toDate);
		installationDateNullCount = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		manufactureYearNullCount = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		manufacturerNullCount = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		nominalVoltageNullCount = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndNominalVoltageIsNull(fromDate, toDate);
		conductorSizeNullCount = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndConductorSizeIsNull(fromDate, toDate);
		numberOfForcesNullCount = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndNumberOfForcesIsNull(fromDate, toDate);
		//shapeLengthNullCount = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndShapeLengthIsNull(fromDate, toDate);
		carryingCapacityNullCount = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndCurrentCarryingCapacityIsNull(fromDate, toDate);
		conductorMaterialNullCount = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndConductorMaterialIsNull(fromDate, toDate);
		if (totalRecord > 0) {
			primaryUndergroundCable.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			primaryUndergroundCable.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			primaryUndergroundCable.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			primaryUndergroundCable.add(Double.valueOf(((double) nominalVoltageNullCount / totalRecord) * 100));
			primaryUndergroundCable.add(Double.valueOf(((double) conductorSizeNullCount / totalRecord) * 100));
			primaryUndergroundCable.add(Double.valueOf(((double) numberOfForcesNullCount / totalRecord) * 100));
			//primaryUndergroundCable.add(Double.valueOf(((double) shapeLengthNullCount / totalRecord) * 100));
			primaryUndergroundCable.add(Double.valueOf(((double) carryingCapacityNullCount / totalRecord) * 100));
			primaryUndergroundCable.add(Double.valueOf(((double) conductorMaterialNullCount / totalRecord) * 100));
		}
		ArrayList<String> resultArrayStr = summaryList(primaryUndergroundCable);
		System.out.println("PrimaryUndergroundCable = " + primaryUndergroundCable.size());

		Map<String, String> result = new HashMap<>();
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private Map<String, String> getSecondaryUndergroundCableAverageCountResult(Date fromDate, Date toDate, String assetName) {

		ArrayList<Double> secondaryUndergroundCable = new ArrayList<Double>();

		long totalRecord = 0;

		long installationDateNullCount = 0;
		long manufactureYearNullCount = 0;
		long manufacturerNullCount = 0;
		long nominalVoltageNullCount = 0;
		long conductorSizeNullCount = 0;
		long numberOfForcesNullCount = 0;
		//long shapeLengthNullCount = 0;
		long currentRatingNullCount = 0;
		long conductorMaterialNullCount = 0;

		totalRecord = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetween(fromDate, toDate);
		installationDateNullCount = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		manufactureYearNullCount = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		manufacturerNullCount = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		nominalVoltageNullCount = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndNominalVoltageIsNull(fromDate, toDate);
		conductorSizeNullCount = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndConductorSizeIsNull(fromDate, toDate);
		numberOfForcesNullCount = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndNumberOfForcesIsNull(fromDate, toDate);
		//shapeLengthNullCount = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndShapeLengthIsNull(fromDate, toDate);
		currentRatingNullCount = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndCurrentRatingIsNull(fromDate, toDate);
		conductorMaterialNullCount = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndConductorMaterialIsNull(fromDate, toDate);
		if (totalRecord > 0) {
			secondaryUndergroundCable.add(Double.valueOf(((double) installationDateNullCount / totalRecord) * 100));
			secondaryUndergroundCable.add(Double.valueOf(((double) manufactureYearNullCount / totalRecord) * 100));
			secondaryUndergroundCable.add(Double.valueOf(((double) manufacturerNullCount / totalRecord) * 100));
			secondaryUndergroundCable.add(Double.valueOf(((double) nominalVoltageNullCount / totalRecord) * 100));
			secondaryUndergroundCable.add(Double.valueOf(((double) conductorSizeNullCount / totalRecord) * 100));
			secondaryUndergroundCable.add(Double.valueOf(((double) numberOfForcesNullCount / totalRecord) * 100));
			//secondaryUndergroundCable.add(Double.valueOf(((double) shapeLengthNullCount / totalRecord) * 100));
			secondaryUndergroundCable.add(Double.valueOf(((double) currentRatingNullCount / totalRecord) * 100));
			secondaryUndergroundCable.add(Double.valueOf(((double) conductorMaterialNullCount / totalRecord) * 100));
		}
		ArrayList<String> resultArrayStr = summaryList(secondaryUndergroundCable);
		System.out.println("secondaryUndergroundCable = " + secondaryUndergroundCable.size());

		Map<String, String> result = new HashMap<>();
		result.put("assetName", assetName);
		result.put("totalRecord", Long.toString(totalRecord));
		result.put("dataAvailability", resultArrayStr.get(0));
		result.put("totalPercentageOfNonAvailableData", resultArrayStr.get(1));
		return result;
	}

	private ArrayList<String> summaryList(ArrayList<Double> countList) {

		ArrayList<String> result = new ArrayList<>();
		double sumCountAllColumns = 0;
		double totalPercentage = 100;
		double dataAvailibilty = 0;
		double totalPercentageOfDataNonAvailibleData = 0;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		for (int i = 0; i < countList.size(); i++) {
			sumCountAllColumns = sumCountAllColumns + countList.get(i);
		}
//		System.out.println(sumCountAllColumns);

		if (countList.size() > 0) {
			totalPercentageOfDataNonAvailibleData = ((double) sumCountAllColumns / countList.size());
		} else {
			totalPercentageOfDataNonAvailibleData = 100.0;
		}
		dataAvailibilty = totalPercentage - totalPercentageOfDataNonAvailibleData;
		result.add(nf.format(dataAvailibilty));
		result.add(nf.format(totalPercentageOfDataNonAvailibleData));
		return result;
	}
}
