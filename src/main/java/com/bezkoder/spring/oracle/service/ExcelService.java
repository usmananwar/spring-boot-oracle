package com.bezkoder.spring.oracle.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.oracle.model.BatteryBank;
import com.bezkoder.spring.oracle.model.Busbar;
import com.bezkoder.spring.oracle.model.CapacitorBank;
import com.bezkoder.spring.oracle.model.ControlAndRelay;
import com.bezkoder.spring.oracle.model.DynamicProtectiveDevice;
import com.bezkoder.spring.oracle.model.Fuse;
import com.bezkoder.spring.oracle.model.Pillar;
import com.bezkoder.spring.oracle.model.Pole;
import com.bezkoder.spring.oracle.model.PrimaryOverheadConductor;
import com.bezkoder.spring.oracle.model.PrimaryUndergroundCable;
import com.bezkoder.spring.oracle.model.SecondaryOverheadConductor;
import com.bezkoder.spring.oracle.model.SecondaryUndergroundCable;
import com.bezkoder.spring.oracle.model.Switchs;
import com.bezkoder.spring.oracle.model.Transformer;

@Service
public class ExcelService {

	public void prepareExcelForTransformersSubType1and4(List<Transformer> transformers, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("Installation Date");
		headingRow.createCell(3).setCellValue("Manufacturing Year");
		headingRow.createCell(4).setCellValue("Manufacturer");
		headingRow.createCell(5).setCellValue("Serial Number");
		headingRow.createCell(6).setCellValue("Vector Group");
		headingRow.createCell(7).setCellValue("Low Side Voltage");
		headingRow.createCell(8).setCellValue("High Side Voltage");
		headingRow.createCell(9).setCellValue("Rating");
		headingRow.createCell(10).setCellValue("Cooling Type");
		headingRow.createCell(11).setCellValue("Impedance");
		headingRow.createCell(12).setCellValue("EASTING");
		headingRow.createCell(13).setCellValue("NORTHING");
		headingRow.createCell(14).setCellValue("HV Rated Current");
		headingRow.createCell(15).setCellValue("LV Rated Current");
		headingRow.createCell(16).setCellValue("OLTC Manufacturer");
		headingRow.createCell(17).setCellValue("OLTC_MANUFACTUREYEAR");
		headingRow.createCell(18).setCellValue("OLTC Type");
		headingRow.createCell(19).setCellValue("OLTC TAPS No");
		headingRow.createCell(20).setCellValue("OLTC Serial Number");
		headingRow.createCell(21).setCellValue("Insulation");

		rowIndex++;
		int i = 0;
		for (Transformer transformer : transformers) {
			Row valueRow = sheet.createRow(rowIndex);
			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(transformer.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(transformer.getInstallationDate()));
			valueRow.createCell(3).setCellValue(String.valueOf(transformer.getManufacturingYear()));
			valueRow.createCell(4).setCellValue(String.valueOf(transformer.getSerialNumber()));

			valueRow.createCell(5).setCellValue(String.valueOf(transformer.getVectorGroup()));
			valueRow.createCell(6).setCellValue(String.valueOf(transformer.getLowSideVoltage()));
			valueRow.createCell(7).setCellValue(String.valueOf(transformer.getHighSideVoltage()));
			valueRow.createCell(8).setCellValue(String.valueOf(transformer.getRating()));
			valueRow.createCell(9).setCellValue(String.valueOf(transformer.getCoolingType()));
			valueRow.createCell(11).setCellValue(String.valueOf(transformer.getImpedance()));
			// valueRow.createCell(12).setCellValue(String.valueOf(transformer.getEasting()));
			// valueRow.createCell(13).setCellValue(String.valueOf(transformer.getNorthing()));
			valueRow.createCell(14).setCellValue(String.valueOf(transformer.getHvRatedCurrent()));
			valueRow.createCell(15).setCellValue(String.valueOf(transformer.getLvRatedCurrent()));
			valueRow.createCell(16).setCellValue(String.valueOf(transformer.getOltcManufacturer()));
			valueRow.createCell(17).setCellValue(String.valueOf(transformer.getOltcManufacturerYear()));
			valueRow.createCell(18).setCellValue(String.valueOf(transformer.getOltcType()));
			valueRow.createCell(19).setCellValue(String.valueOf(transformer.getOltcTapsNo()));
			valueRow.createCell(20).setCellValue(String.valueOf(transformer.getOltcSerialNumber()));
			valueRow.createCell(21).setCellValue(String.valueOf(transformer.getInsulation()));
			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForTransformersSubType2Or3(List<Transformer> transformers, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("Serial Number");
		headingRow.createCell(3).setCellValue("EASTING");
		headingRow.createCell(4).setCellValue("NORTHING");
		headingRow.createCell(5).setCellValue("Installation Date");

		headingRow.createCell(6).setCellValue("Manufacturer");
		headingRow.createCell(7).setCellValue("Manufacturing Year");
		headingRow.createCell(8).setCellValue("High Side Voltage");
		headingRow.createCell(9).setCellValue("Low Side Voltage");
		headingRow.createCell(10).setCellValue("Cooling Type");
		headingRow.createCell(11).setCellValue("Rating");
		headingRow.createCell(12).setCellValue("Impedance");
		headingRow.createCell(13).setCellValue("Vector Group");

		rowIndex++;
		int i = 0;
		for (Transformer transformer : transformers) {
			Row valueRow = sheet.createRow(rowIndex);
			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(transformer.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(transformer.getSerialNumber()));
			// valueRow.createCell(3).setCellValue(String.valueOf(transformer.getEasting()));
			// valueRow.createCell(4).setCellValue(String.valueOf(transformer.getNorthing()));
			valueRow.createCell(5).setCellValue(String.valueOf(transformer.getInstallationDate()));
			valueRow.createCell(6).setCellValue(String.valueOf(transformer.getManufacturer()));
			valueRow.createCell(7).setCellValue(String.valueOf(transformer.getManufacturingYear()));
			valueRow.createCell(8).setCellValue(String.valueOf(transformer.getHighSideVoltage()));
			valueRow.createCell(9).setCellValue(String.valueOf(transformer.getLowSideVoltage()));
			valueRow.createCell(10).setCellValue(String.valueOf(transformer.getCoolingType()));
			valueRow.createCell(11).setCellValue(String.valueOf(transformer.getRating()));
			valueRow.createCell(12).setCellValue(String.valueOf(transformer.getImpedance()));
			valueRow.createCell(13).setCellValue(String.valueOf(transformer.getVectorGroup()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForDynamicProtectiveDeviceSubType1(List<DynamicProtectiveDevice> dynamicProtectiveDevicesList, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("EASTING");
		headingRow.createCell(3).setCellValue("NORTHING");
		headingRow.createCell(4).setCellValue("Installation Date");
		headingRow.createCell(5).setCellValue("Manufacturer");
		headingRow.createCell(6).setCellValue("Manufacturing Year");
		headingRow.createCell(7).setCellValue("Current Rating");
		headingRow.createCell(8).setCellValue("Nominal Voltage");
		headingRow.createCell(9).setCellValue("Type");
		headingRow.createCell(10).setCellValue("Serial Number");

		rowIndex++;
		int i = 0;
		for (DynamicProtectiveDevice dynamicProtectiveDevices : dynamicProtectiveDevicesList) {
			Row valueRow = sheet.createRow(rowIndex);
			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(dynamicProtectiveDevices.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(dynamicProtectiveDevices.getEasting()));
			valueRow.createCell(3).setCellValue(String.valueOf(dynamicProtectiveDevices.getNorthing()));
			valueRow.createCell(4).setCellValue(String.valueOf(dynamicProtectiveDevices.getInstallationDate()));
			valueRow.createCell(5).setCellValue(String.valueOf(dynamicProtectiveDevices.getManufacturer()));
			valueRow.createCell(6).setCellValue(String.valueOf(dynamicProtectiveDevices.getManufacturingYear()));
			valueRow.createCell(7).setCellValue(String.valueOf(dynamicProtectiveDevices.getCurrentRatting()));
			valueRow.createCell(8).setCellValue(String.valueOf(dynamicProtectiveDevices.getNominalVoltage()));
			valueRow.createCell(9).setCellValue(String.valueOf(dynamicProtectiveDevices.getType()));
			valueRow.createCell(10).setCellValue(String.valueOf(dynamicProtectiveDevices.getSerialNumber()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForDynamicProtectiveDeviceSubType2(List<DynamicProtectiveDevice> dynamicProtectiveDevicesList, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("EASTING");
		headingRow.createCell(3).setCellValue("NORTHING");
		headingRow.createCell(4).setCellValue("Installation Date");
		headingRow.createCell(5).setCellValue("Manufacturer");
		headingRow.createCell(6).setCellValue("Manufacturing Year");
		headingRow.createCell(7).setCellValue("Current Rating");
		headingRow.createCell(8).setCellValue("Nominal Voltage");
		headingRow.createCell(9).setCellValue("Interrupting Medium");

		rowIndex++;
		int i = 0;
		for (DynamicProtectiveDevice dynamicProtectiveDevices : dynamicProtectiveDevicesList) {
			Row valueRow = sheet.createRow(rowIndex);
			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(dynamicProtectiveDevices.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(dynamicProtectiveDevices.getEasting()));
			valueRow.createCell(3).setCellValue(String.valueOf(dynamicProtectiveDevices.getNorthing()));
			valueRow.createCell(4).setCellValue(String.valueOf(dynamicProtectiveDevices.getInstallationDate()));
			valueRow.createCell(5).setCellValue(String.valueOf(dynamicProtectiveDevices.getManufacturer()));
			valueRow.createCell(6).setCellValue(String.valueOf(dynamicProtectiveDevices.getManufacturingYear()));
			valueRow.createCell(7).setCellValue(String.valueOf(dynamicProtectiveDevices.getCurrentRatting()));
			valueRow.createCell(8).setCellValue(String.valueOf(dynamicProtectiveDevices.getNominalVoltage()));
			valueRow.createCell(9).setCellValue(String.valueOf(dynamicProtectiveDevices.getInterruptingMedium()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForSwitchsSubType2(List<Switchs> switchsList, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("EASTING");
		headingRow.createCell(3).setCellValue("NORTHING");
		headingRow.createCell(4).setCellValue("Installation Date");
		headingRow.createCell(5).setCellValue("Manufacturer");
		headingRow.createCell(6).setCellValue("Manufacturing Year");
		headingRow.createCell(7).setCellValue("Current Rating");
		headingRow.createCell(8).setCellValue("Nominal Voltage");
		headingRow.createCell(9).setCellValue("Type/Model");
		headingRow.createCell(10).setCellValue("Serial Number");

		rowIndex++;
		int i = 0;
		for (Switchs switchs : switchsList) {
			Row valueRow = sheet.createRow(rowIndex);
			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(switchs.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(switchs.getEasting()));
			valueRow.createCell(3).setCellValue(String.valueOf(switchs.getNorthing()));
			valueRow.createCell(4).setCellValue(String.valueOf(switchs.getInstallationDate()));
			valueRow.createCell(5).setCellValue(String.valueOf(switchs.getManufacturer()));
			valueRow.createCell(6).setCellValue(String.valueOf(switchs.getManufacturingYear()));
			valueRow.createCell(7).setCellValue(String.valueOf(switchs.getCurrentRatting()));
			valueRow.createCell(8).setCellValue(String.valueOf(switchs.getNominalVoltage()));
			valueRow.createCell(9).setCellValue(String.valueOf(switchs.getModel()));
			valueRow.createCell(10).setCellValue(String.valueOf(switchs.getSerialNumber()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForSwitchsSubType1(List<Switchs> switchsList, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("EASTING");
		headingRow.createCell(3).setCellValue("NORTHING");
		headingRow.createCell(4).setCellValue("Installation Date");
		headingRow.createCell(5).setCellValue("Manufacturer");
		headingRow.createCell(6).setCellValue("Manufacturing Year");
		headingRow.createCell(7).setCellValue("Current Rating");
		headingRow.createCell(8).setCellValue("Nominal Voltage");
		headingRow.createCell(9).setCellValue("Mounting Type");

		rowIndex++;
		int i = 0;
		for (Switchs switchs : switchsList) {
			Row valueRow = sheet.createRow(rowIndex);
			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(switchs.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(switchs.getEasting()));
			valueRow.createCell(3).setCellValue(String.valueOf(switchs.getNorthing()));
			valueRow.createCell(4).setCellValue(String.valueOf(switchs.getInstallationDate()));
			valueRow.createCell(5).setCellValue(String.valueOf(switchs.getManufacturer()));
			valueRow.createCell(6).setCellValue(String.valueOf(switchs.getManufacturingYear()));
			valueRow.createCell(7).setCellValue(String.valueOf(switchs.getCurrentRatting()));
			valueRow.createCell(8).setCellValue(String.valueOf(switchs.getNominalVoltage()));
			valueRow.createCell(9).setCellValue(String.valueOf(switchs.getMountingType()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForSwitchsSubType3(List<Switchs> switchsList, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("EASTING");
		headingRow.createCell(3).setCellValue("NORTHING");
		headingRow.createCell(4).setCellValue("Installation Date");
		headingRow.createCell(5).setCellValue("Manufacturer");
		headingRow.createCell(6).setCellValue("Manufacturing Year");
		headingRow.createCell(7).setCellValue("Nominal Voltage");
		headingRow.createCell(8).setCellValue("Serial Number");
		headingRow.createCell(9).setCellValue("Current Rating");

		rowIndex++;
		int i = 0;
		for (Switchs switchs : switchsList) {
			Row valueRow = sheet.createRow(rowIndex);
			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(switchs.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(switchs.getEasting()));
			valueRow.createCell(3).setCellValue(String.valueOf(switchs.getNorthing()));
			valueRow.createCell(4).setCellValue(String.valueOf(switchs.getInstallationDate()));
			valueRow.createCell(5).setCellValue(String.valueOf(switchs.getManufacturer()));
			valueRow.createCell(6).setCellValue(String.valueOf(switchs.getManufacturingYear()));
			valueRow.createCell(7).setCellValue(String.valueOf(switchs.getNominalVoltage()));
			valueRow.createCell(8).setCellValue(String.valueOf(switchs.getSerialNumber()));
			valueRow.createCell(9).setCellValue(String.valueOf(switchs.getCurrentRatting()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForBusbarSubType1or2(List<Busbar> busbarList, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("EASTING");
		headingRow.createCell(3).setCellValue("NORTHING");
		headingRow.createCell(4).setCellValue("Installation Date");
		headingRow.createCell(5).setCellValue("Manufacturer");
		headingRow.createCell(6).setCellValue("Manufacturing Year");
		headingRow.createCell(7).setCellValue("Nominal Voltage");
		headingRow.createCell(8).setCellValue("Current Rating");

		rowIndex++;
		int i = 0;
		for (Busbar busbar : busbarList) {
			Row valueRow = sheet.createRow(rowIndex);
			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(busbar.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(busbar.getEasting()));
			valueRow.createCell(3).setCellValue(String.valueOf(busbar.getNorthing()));
			valueRow.createCell(4).setCellValue(String.valueOf(busbar.getInstallationDate()));
			valueRow.createCell(5).setCellValue(String.valueOf(busbar.getManufacturer()));
			valueRow.createCell(6).setCellValue(String.valueOf(busbar.getManufacturingYear()));
			valueRow.createCell(7).setCellValue(String.valueOf(busbar.getNominalVoltage()));
			valueRow.createCell(8).setCellValue(String.valueOf(busbar.getCurrentRating()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForCapacitorBank(List<CapacitorBank> capacitorBankList, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("EASTING");
		headingRow.createCell(3).setCellValue("NORTHING");
		headingRow.createCell(4).setCellValue("Installation Date");
		headingRow.createCell(5).setCellValue("Manufacturer");
		headingRow.createCell(6).setCellValue("Manufacturing Year");
		headingRow.createCell(7).setCellValue("Nominal Voltage");
		headingRow.createCell(8).setCellValue("Type");
		headingRow.createCell(9).setCellValue("Serial Number");
		headingRow.createCell(10).setCellValue("Rating Mvar");

		rowIndex++;
		int i = 0;
		for (CapacitorBank capacitor : capacitorBankList) {
			Row valueRow = sheet.createRow(rowIndex);
			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(capacitor.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(capacitor.getEasting()));
			valueRow.createCell(3).setCellValue(String.valueOf(capacitor.getNorthing()));
			valueRow.createCell(4).setCellValue(String.valueOf(capacitor.getInstallationDate()));
			valueRow.createCell(5).setCellValue(String.valueOf(capacitor.getManufacturer()));
			valueRow.createCell(6).setCellValue(String.valueOf(capacitor.getManufacturingYear()));
			valueRow.createCell(7).setCellValue(String.valueOf(capacitor.getNominalVoltage()));
			valueRow.createCell(8).setCellValue(String.valueOf(capacitor.getType()));
			valueRow.createCell(9).setCellValue(String.valueOf(capacitor.getSerialNumber()));
			valueRow.createCell(10).setCellValue(String.valueOf(capacitor.getRatingMVAR()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForPole(List<Pole> poleList, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("EASTING");
		headingRow.createCell(3).setCellValue("NORTHING");
		headingRow.createCell(4).setCellValue("Height");
		headingRow.createCell(5).setCellValue("Installation Date");
		headingRow.createCell(6).setCellValue("Manufacturer");
		headingRow.createCell(7).setCellValue("Manufacturing Year");
		headingRow.createCell(8).setCellValue("Foundation Type");
		headingRow.createCell(9).setCellValue("Material");
		headingRow.createCell(10).setCellValue("Subtype CD");

		rowIndex++;
		int i = 0;
		for (Pole pole : poleList) {
			Row valueRow = sheet.createRow(rowIndex);

			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(pole.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(pole.getEasting()));
			valueRow.createCell(3).setCellValue(String.valueOf(pole.getNorthing()));
			valueRow.createCell(4).setCellValue(String.valueOf(pole.getHeight()));
			valueRow.createCell(5).setCellValue(String.valueOf(pole.getInstallationDate()));
			valueRow.createCell(6).setCellValue(String.valueOf(pole.getManufacturer()));
			valueRow.createCell(7).setCellValue(String.valueOf(pole.getManufacturingYear()));
			valueRow.createCell(8).setCellValue(String.valueOf(pole.getFoundationType()));
			valueRow.createCell(9).setCellValue(String.valueOf(pole.getMaterial()));
			valueRow.createCell(10).setCellValue(String.valueOf(pole.getSubtypeCd()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForControlAndRelay(List<ControlAndRelay> poleList, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("Control Volatage");

		rowIndex++;
		int i = 0;
		for (ControlAndRelay controlAndRelay : poleList) {
			Row valueRow = sheet.createRow(rowIndex);
			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(controlAndRelay.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(controlAndRelay.getControlVoltage()));
			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForBatteryBank(List<BatteryBank> batteryBankList, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("EASTING");
		headingRow.createCell(3).setCellValue("NORTHING");

		headingRow.createCell(4).setCellValue("Installation Date");
		headingRow.createCell(5).setCellValue("Manufacturer");
		headingRow.createCell(6).setCellValue("Manufacturing Year");
		headingRow.createCell(7).setCellValue("CELLRATEDVOLTAGE");
		headingRow.createCell(8).setCellValue("BATTERYTYPE");
		headingRow.createCell(9).setCellValue("SERIALNUMBER");

		headingRow.createCell(10).setCellValue("BATTERYAMPHOUR");
		headingRow.createCell(11).setCellValue("BATTERYCOUNT");
		headingRow.createCell(12).setCellValue("BATTERY CHARGER _AC_INPUT_VOLTAGE");

		headingRow.createCell(13).setCellValue("BATTERY_CHARGER_AC_INPUT_CURRENT");
		headingRow.createCell(14).setCellValue("BATTERY_CHARGER_DC_OUTPUT_VOLTAGE");
		headingRow.createCell(15).setCellValue("BATTERY_CHARGER_DC_OUTPUT_CURRENT");

		headingRow.createCell(16).setCellValue("BATTERY_CHARGER_MANUFACTURER");
		headingRow.createCell(17).setCellValue("BATTERY_CHARGER_MANUFACTURING_YEAR");

		headingRow.createCell(18).setCellValue("BATTERY_CHARGER_TYPE");
		headingRow.createCell(19).setCellValue("BATTERY_CHARGER_SERIAL_NUMBER");

		rowIndex++;
		int i = 0;
		for (BatteryBank batterBank : batteryBankList) {
			Row valueRow = sheet.createRow(rowIndex);

			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(batterBank.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(batterBank.getEasting()));
			valueRow.createCell(3).setCellValue(String.valueOf(batterBank.getNorthing()));

			valueRow.createCell(4).setCellValue(String.valueOf(batterBank.getInstallationDate()));
			valueRow.createCell(5).setCellValue(String.valueOf(batterBank.getManufacturer()));
			valueRow.createCell(6).setCellValue(String.valueOf(batterBank.getManufacturingYear()));
			valueRow.createCell(7).setCellValue(String.valueOf(batterBank.getCellRatedVoltage()));
			valueRow.createCell(8).setCellValue(String.valueOf(batterBank.getBatteryType()));
			valueRow.createCell(9).setCellValue(String.valueOf(batterBank.getSerialNumber()));
			valueRow.createCell(10).setCellValue(String.valueOf(batterBank.getBatteryAmpHour()));

			valueRow.createCell(11).setCellValue(String.valueOf(batterBank.getBatteryCount()));
			valueRow.createCell(12).setCellValue(String.valueOf(batterBank.getBatteryChargerAcInputVoltage()));

			valueRow.createCell(13).setCellValue(String.valueOf(batterBank.getBatteryChargerAcInputCurrent()));
			valueRow.createCell(14).setCellValue(String.valueOf(batterBank.getBatteryChargerDcOutputVoltage()));
			valueRow.createCell(15).setCellValue(String.valueOf(batterBank.getBatteryChargerDcOutputCurrent()));
			valueRow.createCell(16).setCellValue(String.valueOf(batterBank.getBatteryChargerManufacturer()));
			valueRow.createCell(17).setCellValue(String.valueOf(batterBank.getBatteryChargerManufacturingYear()));
			valueRow.createCell(18).setCellValue(String.valueOf(batterBank.getBatteryChargerType()));

			valueRow.createCell(19).setCellValue(String.valueOf(batterBank.getBatteryChargerSerialNumber()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForPillar(List<Pillar> pillarList, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("EASTING");
		headingRow.createCell(3).setCellValue("NORTHING");
		headingRow.createCell(4).setCellValue("Installation Date");
		headingRow.createCell(5).setCellValue("Manufacturer");
		headingRow.createCell(6).setCellValue("Manufacturing Year");
		headingRow.createCell(7).setCellValue("CURRENT_RATING");
		headingRow.createCell(8).setCellValue("NOMINALVOLTAGE");
		headingRow.createCell(9).setCellValue("TYPE");
		headingRow.createCell(10).setCellValue("SERIALNUMBER");

		rowIndex++;
		int i = 0;
		for (Pillar batterBank : pillarList) {
			Row valueRow = sheet.createRow(rowIndex);

			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(batterBank.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(batterBank.getEasting()));
			valueRow.createCell(3).setCellValue(String.valueOf(batterBank.getNorthing()));
			valueRow.createCell(4).setCellValue(String.valueOf(batterBank.getInstallationDate()));
			valueRow.createCell(5).setCellValue(String.valueOf(batterBank.getManufacturer()));
			valueRow.createCell(6).setCellValue(String.valueOf(batterBank.getManufacturingYear()));
			valueRow.createCell(7).setCellValue(String.valueOf(batterBank.getCurrentRating()));
			valueRow.createCell(8).setCellValue(String.valueOf(batterBank.getNominalVoltage()));
			valueRow.createCell(9).setCellValue(String.valueOf(batterBank.getType()));
			valueRow.createCell(10).setCellValue(String.valueOf(batterBank.getSerialNumber()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForHFU(List<Fuse> fuseList, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("EASTING");
		headingRow.createCell(3).setCellValue("NORTHING");
		headingRow.createCell(4).setCellValue("Installation Date");
		headingRow.createCell(5).setCellValue("Manufacturer");
		headingRow.createCell(6).setCellValue("Manufacturing Year");
		headingRow.createCell(7).setCellValue("NOMINALVOLTAGE");
		headingRow.createCell(8).setCellValue("SERIALNUMBER");
		headingRow.createCell(9).setCellValue("Current Rating");

		rowIndex++;
		int i = 0;
		for (Fuse fuse : fuseList) {
			Row valueRow = sheet.createRow(rowIndex);

			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(fuse.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(fuse.getEasting()));
			valueRow.createCell(3).setCellValue(String.valueOf(fuse.getNorthing()));
			valueRow.createCell(4).setCellValue(String.valueOf(fuse.getInstallationDate()));
			valueRow.createCell(5).setCellValue(String.valueOf(fuse.getManufacturer()));
			valueRow.createCell(6).setCellValue(String.valueOf(fuse.getManufacturingYear()));
			valueRow.createCell(7).setCellValue(String.valueOf(fuse.getNominalVoltage()));
			valueRow.createCell(8).setCellValue(String.valueOf(fuse.getSerialNumber()));
			valueRow.createCell(9).setCellValue(String.valueOf(fuse.getCurrentRating()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForSecondaryOverhead(List<SecondaryOverheadConductor> list, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);

		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("CONDUCTORSIZE");
		headingRow.createCell(3).setCellValue("MANUFACTURER");
		headingRow.createCell(4).setCellValue("MANUFACTURINGYEAR");
		headingRow.createCell(5).setCellValue("NOMINALVOLTAGE");
		headingRow.createCell(6).setCellValue("CURRENTRATING");
//		headingRow.createCell(7).setCellValue("SHAPE_LEN");
		headingRow.createCell(7).setCellValue("CONDUCTORTYPE");

		rowIndex++;
		int i = 0;
		for (SecondaryOverheadConductor overheadConductor : list) {
			Row valueRow = sheet.createRow(rowIndex);

			int cellIndexx = -1;
			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(overheadConductor.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(overheadConductor.getConductorSize()));
			valueRow.createCell(3).setCellValue(String.valueOf(overheadConductor.getManufacturer()));
			valueRow.createCell(4).setCellValue(String.valueOf(overheadConductor.getManufacturingYear()));
			valueRow.createCell(5).setCellValue(String.valueOf(overheadConductor.getNominalVoltage()));
			valueRow.createCell(6).setCellValue(String.valueOf(overheadConductor.getCurrentRating()));
//			valueRow.createCell(7).setCellValue(String.valueOf(overheadConductor.getShapeLength()));
			valueRow.createCell(7).setCellValue(String.valueOf(overheadConductor.getConductorType()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForPrimaryOverheadConductor(List<PrimaryOverheadConductor> list, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);


		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("INSTALLATIONDATE");
		headingRow.createCell(3).setCellValue("CONDUCTORSIZE");
		headingRow.createCell(4).setCellValue("MANUFACTURER");
		headingRow.createCell(5).setCellValue("MANUFACTURINGYEAR");
		headingRow.createCell(6).setCellValue("NOMINALVOLTAGE");
		headingRow.createCell(7).setCellValue("CURRENT_CARRYING_CAPACITY");
		headingRow.createCell(8).setCellValue("CONDUCTORTYPE");

		rowIndex++;
		int i = 0;
		for (PrimaryOverheadConductor overheadConductor : list) {
			Row valueRow = sheet.createRow(rowIndex);

			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(overheadConductor.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(overheadConductor.getInstallationDate()));
			valueRow.createCell(3).setCellValue(String.valueOf(overheadConductor.getConductorSize()));
			valueRow.createCell(4).setCellValue(String.valueOf(overheadConductor.getManufacturer()));
			valueRow.createCell(5).setCellValue(String.valueOf(overheadConductor.getManufacturingYear()));
			valueRow.createCell(6).setCellValue(String.valueOf(overheadConductor.getNominalVoltage()));
			valueRow.createCell(7).setCellValue(String.valueOf(overheadConductor.getCurrentCarryingCapacity()));
			valueRow.createCell(8).setCellValue(String.valueOf(overheadConductor.getConductorType()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForPrimaryUndergroundCable(List<PrimaryUndergroundCable> list, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);


		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("INSTALLATIONDATE");
		headingRow.createCell(3).setCellValue("MANUFACTURER");
		headingRow.createCell(4).setCellValue("MANUFACTURINGYEAR");
		headingRow.createCell(5).setCellValue("NOMINALVOLTAGE");
		headingRow.createCell(6).setCellValue("CONDUCTORSIZE");
		headingRow.createCell(7).setCellValue("NUMBEROFCORES");
		//headingRow.createCell(8).setCellValue("SHAPE_LEN");

		headingRow.createCell(8).setCellValue("CURRENT_CARRYING_CAPACITY");
		headingRow.createCell(9).setCellValue("CONDUCTORMATERIAL");

		rowIndex++;
		int i = 0;
		for (PrimaryUndergroundCable entry : list) {
			Row valueRow = sheet.createRow(rowIndex);


			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(entry.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(entry.getConductorSize()));
			valueRow.createCell(3).setCellValue(String.valueOf(entry.getManufacturer()));
			valueRow.createCell(4).setCellValue(String.valueOf(entry.getManufacturingYear()));
			valueRow.createCell(5).setCellValue(String.valueOf(entry.getNominalVoltage()));
			valueRow.createCell(6).setCellValue(String.valueOf(entry.getConductorSize()));
			valueRow.createCell(7).setCellValue(String.valueOf(entry.getNumberOfForces()));
			//valueRow.createCell(8).setCellValue(String.valueOf(entry.getShapeLength()));

			valueRow.createCell(8).setCellValue(String.valueOf(entry.getCurrentCarryingCapacity()));
			valueRow.createCell(9).setCellValue(String.valueOf(entry.getConductorMaterial()));

			rowIndex++;
			i++;
		}
	}

	public void prepareExcelForSeondaryUndergroundCable(List<SecondaryUndergroundCable> list, HSSFWorkbook workbook) {

		Sheet sheet = workbook.createSheet("Sheet1");
		int rowIndex = 0;
		Row headingRow = sheet.createRow(rowIndex);


		headingRow.createCell(0).setCellValue("Sl No");
		headingRow.createCell(1).setCellValue("OBJECTID");
		headingRow.createCell(2).setCellValue("INSTALLATIONDATE");
		headingRow.createCell(3).setCellValue("MANUFACTURINGYEAR");
		headingRow.createCell(4).setCellValue("MANUFACTURER");
		headingRow.createCell(5).setCellValue("NOMINALVOLTAGE");
		headingRow.createCell(6).setCellValue("CONDUCTORSIZE");
		headingRow.createCell(7).setCellValue("NUMBEROFCORES");
		//headingRow.createCell(8).setCellValue("SHAPE_LEN");
		headingRow.createCell(8).setCellValue("CURRENTRATING");
		headingRow.createCell(9).setCellValue("CONDUCTORMATERIAL");

		rowIndex++;
		int i = 0;
		for (SecondaryUndergroundCable entry : list) {
			Row valueRow = sheet.createRow(rowIndex);

			valueRow.createCell(0).setCellValue(String.valueOf(i + 1));
			valueRow.createCell(1).setCellValue(String.valueOf(entry.getObjectId()));
			valueRow.createCell(2).setCellValue(String.valueOf(entry.getConductorSize()));
			valueRow.createCell(3).setCellValue(String.valueOf(entry.getManufacturingYear()));
			valueRow.createCell(4).setCellValue(String.valueOf(entry.getManufacturer()));
			valueRow.createCell(5).setCellValue(String.valueOf(entry.getNominalVoltage()));
			valueRow.createCell(6).setCellValue(String.valueOf(entry.getConductorSize()));
			valueRow.createCell(7).setCellValue(String.valueOf(entry.getNumberOfForces()));
			//valueRow.createCell(8).setCellValue(String.valueOf(entry.getShapeLength()));
			valueRow.createCell(8).setCellValue(String.valueOf(entry.getCurrentRating()));
			valueRow.createCell(9).setCellValue(String.valueOf(entry.getConductorMaterial()));

			rowIndex++;
			i++;
		}
	}
}
