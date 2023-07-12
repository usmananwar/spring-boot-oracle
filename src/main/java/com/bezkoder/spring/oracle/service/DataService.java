package com.bezkoder.spring.oracle.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bezkoder.spring.oracle.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class DataService {

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

	public List<AssetProperty> getTransformerColumnCountResult(Date fromDate, Date toDate, List<Integer> subTypeCds) {

		long totalRecord = 0;
		long installationDate = 0;
		long manufactureYear = 0;
		long manufacturer = 0;
		long serialNumber = 0;
		long vectorGroup = 0;
		long lowSideVoltage = 0;
		long highSideVoltage = 0;
		long rating = 0;
		long coolingType = 0;
		long impedance = 0;
		long easting = 0;
		long northing = 0;
		long hvRatedCurrent = 0;
		long lvRatedCurrent = 0;
		long oltcManufacturer = 0;
		long oltcManufacturerYear = 0;
		long oltcType = 0;
		long oltcTapsNo = 0;
		long oltcSerialNumber = 0;
		long insulation = 0;

		totalRecord = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdIn(fromDate, toDate, subTypeCds);
		installationDate = transformerRepository.countTransformerByInstallationDateBetweenAndInstallationDateIsNullAndSubtypeCdIn(fromDate, toDate, subTypeCds);
		manufactureYear = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndManufacturingYearIsNull(fromDate, toDate, subTypeCds);
		manufacturer = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndManufacturerIsNull(fromDate, toDate, subTypeCds);
		serialNumber = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndSerialNumberIsNull(fromDate, toDate, subTypeCds);
		vectorGroup = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndVectorGroupIsNull(fromDate, toDate, subTypeCds);
		lowSideVoltage = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndLowSideVoltageIsNull(fromDate, toDate, subTypeCds);
		highSideVoltage = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndHighSideVoltageIsNull(fromDate, toDate, subTypeCds);
		rating = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndRatingIsNull(fromDate, toDate, subTypeCds);
		coolingType = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndCoolingTypeIsNull(fromDate, toDate, subTypeCds);
		impedance = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndImpedanceIsNull(fromDate, toDate, subTypeCds);
		hvRatedCurrent = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndHvRatedCurrentIsNull(fromDate, toDate, subTypeCds);
		lvRatedCurrent = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndLvRatedCurrentIsNull(fromDate, toDate, subTypeCds);
		oltcManufacturer = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcManufacturerIsNull(fromDate, toDate, subTypeCds);
		oltcManufacturerYear = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcManufacturerYearIsNull(fromDate, toDate, subTypeCds);
		oltcType = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcTypeIsNull(fromDate, toDate, subTypeCds);
//		oltcTapsNo = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcTapsNoIsNullOrInstallationDateBetweenAndOltcTapsNo(fromDate, toDate, subTypeCds, fromDate, toDate, "Not Applicable");
		oltcTapsNo = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcTapsNoIsNull(fromDate, toDate, subTypeCds);
		oltcSerialNumber = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcSerialNumberIsNull(fromDate, toDate, subTypeCds);
		insulation = transformerRepository.countTransformerByInstallationDateBetweenAndSubtypeCdInAndInsulationIsNull(fromDate, toDate, subTypeCds);

		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Serial Number").value(Long.toString(serialNumber)).build());
		assetDetails.add(AssetProperty.builder().key("Vector Group").value(Long.toString(vectorGroup)).build());

		assetDetails.add(AssetProperty.builder().key("Low Side Voltage").value(Long.toString(lowSideVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("High Side Voltage").value(Long.toString(highSideVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("Rating").value(Long.toString(rating)).build());
		assetDetails.add(AssetProperty.builder().key("Cooling Type").value(Long.toString(coolingType)).build());

		assetDetails.add(AssetProperty.builder().key("Impedance").value(Long.toString(impedance)).build());

		assetDetails.add(AssetProperty.builder().key("Easting").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Northing").value(Long.toString(totalRecord)).build());

		assetDetails.add(AssetProperty.builder().key("HV Rated Current").value(Long.toString(hvRatedCurrent)).build());
		assetDetails.add(AssetProperty.builder().key("LV Rated Current").value(Long.toString(lvRatedCurrent)).build());
		assetDetails.add(AssetProperty.builder().key("OLTC Manufacturer").value(Long.toString(oltcManufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("OLTC Manufacturer Year").value(Long.toString(oltcManufacturerYear)).build());
		assetDetails.add(AssetProperty.builder().key("OLTC Type").value(Long.toString(oltcType)).build());
		assetDetails.add(AssetProperty.builder().key("OLTC Taps No").value(Long.toString(oltcTapsNo)).build());
		assetDetails.add(AssetProperty.builder().key("OLTC Serial Number").value(Long.toString(oltcSerialNumber)).build());
		assetDetails.add(AssetProperty.builder().key("Insulation").value(Long.toString(insulation)).build());
		return assetDetails;

	}

	public List<AssetProperty> getDynamicProtectiveDeviceColumnCountResult(Date fromDate, Date toDate, Integer subTypeCd) {

		long totalRecord = 0;
		long installationDate = 0;
		long manufacturer = 0;
		long manufactureYear = 0;
		long currentRating = 0;
		long nominalVoltage = 0;
		long type = 0;
		long interrupting = 0;
		long serialNumber = 0;

		totalRecord = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCd(fromDate, toDate, subTypeCd);
		installationDate = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndInstallationDateIsNull(fromDate, toDate, subTypeCd);
		manufacturer = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndManufacturerIsNull(fromDate, toDate, subTypeCd);
		manufactureYear = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndManufacturingYearIsNull(fromDate, toDate, subTypeCd);
		currentRating = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndCurrentRattingIsNull(fromDate, toDate, subTypeCd);
		nominalVoltage = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndNominalVoltageIsNull(fromDate, toDate, subTypeCd);
		if(subTypeCd == 1){
			type = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndTypeIsNull(fromDate, toDate, subTypeCd);
			serialNumber = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndSerialNumberIsNull(fromDate, toDate, subTypeCd);
		}
		if(subTypeCd == 2){
			interrupting = dynamicProtectiveDeviceRepository.countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndInterruptingMediumIsNull(fromDate, toDate, subTypeCd);
		}

		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Current Rating").value(Long.toString(currentRating)).build());
		assetDetails.add(AssetProperty.builder().key("Nominal Voltage").value(Long.toString(nominalVoltage)).build());
		if(subTypeCd == 1){
			assetDetails.add(AssetProperty.builder().key("Type").value(Long.toString(type)).build());
			assetDetails.add(AssetProperty.builder().key("Serial Number").value(Long.toString(serialNumber)).build());
		}
		if(subTypeCd == 2){
			assetDetails.add(AssetProperty.builder().key("Interrupting").value(Long.toString(interrupting)).build());
		}
		return assetDetails;
	}

	public List<AssetProperty> getSwitchColumnCountResult(Date fromDate, Date toDate, Integer subTypeCd) {

		long totalRecord = 0;
		long installationDate = 0;
		long manufacturer = 0;
		long manufactureYear = 0;
		long currentRating = 0;
		long nominalVoltage = 0;
		long model = 0;
		long serialNumber = 0;
		long mountingType = 0;


		totalRecord = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCd(fromDate, toDate, subTypeCd);
		installationDate = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndInstallationDateIsNull(fromDate, toDate, subTypeCd);
		manufacturer = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndManufacturerIsNull(fromDate, toDate, subTypeCd);
		manufactureYear = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndManufacturingYearIsNull(fromDate, toDate, subTypeCd);
		currentRating = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndCurrentRattingIsNull(fromDate, toDate, subTypeCd);
		nominalVoltage = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndNominalVoltageIsNull(fromDate, toDate, subTypeCd);

		if(subTypeCd == 2){
			model = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndModelIsNull(fromDate, toDate, subTypeCd);
			serialNumber = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndSerialNumberIsNull(fromDate, toDate, subTypeCd);
		}
		if(subTypeCd == 1){
			mountingType = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndMountingTypeIsNull(fromDate, toDate, subTypeCd);
		}
		if(subTypeCd == 3){
			serialNumber = switchsRepository.countSwitchByInstallationDateBetweenAndSubtypeCdAndSerialNumberIsNull(fromDate, toDate, subTypeCd);
		}


		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Current Rating").value(Long.toString(currentRating)).build());
		assetDetails.add(AssetProperty.builder().key("Nominal Voltage").value(Long.toString(nominalVoltage)).build());
		if(subTypeCd == 2){
			assetDetails.add(AssetProperty.builder().key("Type/Model").value(Long.toString(model)).build());
			assetDetails.add(AssetProperty.builder().key("Serial Number").value(Long.toString(serialNumber)).build());
		}
		if(subTypeCd == 1){
			assetDetails.add(AssetProperty.builder().key("Mounting Type").value(Long.toString(mountingType)).build());
		}
		if(subTypeCd == 3){
			assetDetails.add(AssetProperty.builder().key("Serial Number").value(Long.toString(serialNumber)).build());
		}
		return assetDetails;
	}

	public List<AssetProperty> getBusbarColumnCountResult(Date fromDate, Date toDate, List<Integer> subTypeCds) {

		long totalRecord = 0;
		long installationDate = 0;
		long manufacturer = 0;
		long manufactureYear = 0;
		long currentRating = 0;
		long nominalVoltage = 0;
		long busbarType = 0;

		totalRecord = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdIn(fromDate, toDate,"MBB", subTypeCds);
		installationDate = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndInstallationDateIsNull(fromDate, toDate,"MBB", subTypeCds);
		manufacturer = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndManufacturerIsNull(fromDate, toDate,"MBB", subTypeCds);
		manufactureYear = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndManufacturingYearIsNull(fromDate, toDate, "MBB",subTypeCds);
		currentRating = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndCurrentRatingIsNull(fromDate, toDate, "MBB",subTypeCds);
		nominalVoltage = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndNominalVoltageIsNull(fromDate, toDate, "MBB",subTypeCds);
		busbarType = busbarRepository.countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndBusbarTypeIsNull(fromDate, toDate, "MBB",subTypeCds);

		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Current Rating").value(Long.toString(currentRating)).build());
		assetDetails.add(AssetProperty.builder().key("Nominal Voltage").value(Long.toString(nominalVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("Busbar Type").value(Long.toString(busbarType)).build());

		return assetDetails;
	}

	public List<AssetProperty> getCapacitorBankColumnCountResult(Date fromDate, Date toDate) {

		long totalRecord = 0;
		long installationDate = 0;
		long manufacturer = 0;
		long manufactureYear = 0;
		long nominalVoltage = 0;
		long type = 0;
		long serialNumber = 0;
		long ratingMVAR = 0;

		totalRecord = capacitorBankRepository.countCapacitorBankByInstallationDateBetween(fromDate, toDate);
		installationDate = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		manufacturer = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYear = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		nominalVoltage = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndNominalVoltageIsNull(fromDate, toDate);
		type = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndTypeIsNull(fromDate, toDate);
		serialNumber = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndSerialNumberIsNull(fromDate, toDate);
		ratingMVAR = capacitorBankRepository.countCapacitorBankByInstallationDateBetweenAndRatingMVARIsNull(fromDate, toDate);

		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Nominal Voltage").value(Long.toString(nominalVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("Type").value(Long.toString(type)).build());
		assetDetails.add(AssetProperty.builder().key("Serial Number").value(Long.toString(serialNumber)).build());
		assetDetails.add(AssetProperty.builder().key("Rating MVAR").value(Long.toString(ratingMVAR)).build());

		return assetDetails;
	}

	public List<AssetProperty> getPoleColumnCountResult(Date fromDate, Date toDate) {

		long totalRecord = 0;
		long height = 0;
		long installationDate = 0;
		long manufacturer = 0;
		long manufactureYear = 0;
		long foundationType = 0;
		long material = 0;
		long subTypeCd = 0;

		totalRecord = poleRepository.countPoleByInstallationDateBetween(fromDate, toDate);
		height = poleRepository.countPoleByInstallationDateBetweenAndHeightIsNull(fromDate, toDate);
		installationDate = poleRepository.countPoleByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		manufacturer = poleRepository.countPoleByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYear = poleRepository.countPoleByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		foundationType = poleRepository.countPoleByInstallationDateBetweenAndFoundationTypeIsNull(fromDate, toDate);
		material = poleRepository.countPoleByInstallationDateBetweenAndMaterialIsNull(fromDate, toDate);
		subTypeCd = poleRepository.countPoleByInstallationDateBetweenAndSubtypeCdIsNull(fromDate, toDate);

		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Height").value(Long.toString(height)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Foundation Type").value(Long.toString(foundationType)).build());
		assetDetails.add(AssetProperty.builder().key("Material").value(Long.toString(material)).build());
		assetDetails.add(AssetProperty.builder().key("Sub Type Cd").value(Long.toString(subTypeCd)).build());

		return assetDetails;
	}

	public List<AssetProperty> getControlAndRelayCountResult() {

		long totalRecord = 0;
		long manufacturer = 0;
		long controlVoltage = 0;

		totalRecord = controlAndRelayRepository.count();
		manufacturer = controlAndRelayRepository.countControlAndRelayByManufacturerIsNull();
		controlVoltage = controlAndRelayRepository.countControlAndRelayByControlVoltageIsNull();

		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Control Voltage").value(Long.toString(controlVoltage)).build());

		return assetDetails;
	}

	public List<AssetProperty> getBatteryBankColumnCountResult(Date fromDate, Date toDate) {

		long totalRecord = 0;
		long installationDate = 0;
		long manufacturer = 0;
		long manufactureYear = 0;
		long cellRatedVoltage = 0;
		long batteryType = 0;
		long serialNumber = 0;
		long batteryAmpHour = 0;
		long batteryCount = 0;
		long batteryChargerAcInputVoltage = 0;
		long batteryChargerAcInputCurrent = 0;
		long batteryChargerDcOutputVoltage = 0;
		long batteryChargerDcOutputCurrent = 0;
		long batteryChargerManufacturer = 0;
		long batteryChargerManufacturingYear = 0;
		long batteryChargerType = 0;
		long batteryChargerSerialNumber = 0;

		totalRecord = batteryBankRepository.countBatteryBankByInstallationDateBetween(fromDate, toDate);
		installationDate = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		manufacturer = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYear = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		cellRatedVoltage = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndCellRatedVoltageIsNull(fromDate, toDate);
		batteryType = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryTypeIsNull(fromDate, toDate);
		serialNumber = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndSerialNumberIsNull(fromDate, toDate);
		batteryAmpHour = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryAmpHourIsNull(fromDate, toDate);
		batteryCount = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryCountIsNull(fromDate, toDate);
		batteryChargerAcInputVoltage = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerAcInputVoltageIsNull(fromDate, toDate);
		batteryChargerAcInputCurrent = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerAcInputCurrentIsNull(fromDate, toDate);
		batteryChargerDcOutputVoltage = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerDcOutputVoltageIsNull(fromDate, toDate);
		batteryChargerDcOutputCurrent = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerDcOutputCurrentIsNull(fromDate, toDate);
		batteryChargerManufacturer = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerManufacturerIsNull(fromDate, toDate);
		batteryChargerManufacturingYear = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerManufacturingYearIsNull(fromDate, toDate);
		batteryChargerType = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerTypeIsNull(fromDate, toDate);
		batteryChargerSerialNumber = batteryBankRepository.countBatteryBankByInstallationDateBetweenAndBatteryChargerSerialNumberIsNull(fromDate, toDate);

		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Cell Rated Voltage").value(Long.toString(cellRatedVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("BatteryType").value(Long.toString(batteryType)).build());
		assetDetails.add(AssetProperty.builder().key("Serial Number").value(Long.toString(serialNumber)).build());
		assetDetails.add(AssetProperty.builder().key("Battery Amp Hour").value(Long.toString(batteryAmpHour)).build());
		assetDetails.add(AssetProperty.builder().key("Battery Count").value(Long.toString(batteryCount)).build());
		assetDetails.add(AssetProperty.builder().key("Battery Charger Ac Input Voltage").value(Long.toString(batteryChargerAcInputVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("Battery Charger Ac Input Current").value(Long.toString(batteryChargerAcInputCurrent)).build());
		assetDetails.add(AssetProperty.builder().key("Battery Charger Dc Output Voltage").value(Long.toString(batteryChargerDcOutputVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("Battery Charger Dc Output Current").value(Long.toString(batteryChargerDcOutputCurrent)).build());
		assetDetails.add(AssetProperty.builder().key("Battery Charger Manufacturer").value(Long.toString(batteryChargerManufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Battery Charger Manufacturing Year").value(Long.toString(batteryChargerManufacturingYear)).build());
		assetDetails.add(AssetProperty.builder().key("Battery Charger Type").value(Long.toString(batteryChargerType)).build());
		assetDetails.add(AssetProperty.builder().key("Battery Charger Serial Number").value(Long.toString(batteryChargerSerialNumber)).build());

		return assetDetails;
	}

	public List<AssetProperty> getPillarColumnCountResult(Date fromDate, Date toDate) {

		long totalRecord = 0;
		long installationDate = 0;
		long manufacturer = 0;
		long manufactureYear = 0;
		long currentRating = 0;
		long nominalVoltage = 0;
		long type = 0;
		long serialNumber = 0;


		totalRecord = pillarRepository.countPillarByInstallationDateBetween(fromDate, toDate);
		installationDate = pillarRepository.countPillarByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		manufacturer = pillarRepository.countPillarByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYear = pillarRepository.countPillarByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		currentRating = pillarRepository.countPillarByInstallationDateBetweenAndCurrentRatingIsNull(fromDate, toDate);
		nominalVoltage = pillarRepository.countPillarByInstallationDateBetweenAndNominalVoltageIsNull(fromDate, toDate);
		type = pillarRepository.countPillarByInstallationDateBetweenAndTypeIsNull(fromDate, toDate);
		serialNumber = pillarRepository.countPillarByInstallationDateBetweenAndSerialNumberIsNull(fromDate, toDate);


		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Current Rating").value(Long.toString(currentRating)).build());
		assetDetails.add(AssetProperty.builder().key("Nominal Voltage").value(Long.toString(nominalVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("Type").value(Long.toString(type)).build());
		assetDetails.add(AssetProperty.builder().key("Serial Number").value(Long.toString(serialNumber)).build());

		return assetDetails;
	}

	public List<AssetProperty> getFuseColumnCountResult(Date fromDate, Date toDate, Integer subTypeCd) {

		long totalRecord = 0;
		long installationDate = 0;
		long manufacturer = 0;
		long manufactureYear = 0;
		long currentRating = 0;
		long nominalVoltage = 0;
		long serialNumber = 0;

		totalRecord = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCd(fromDate, toDate, subTypeCd);
		installationDate = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndInstallationDateIsNull(fromDate, toDate, subTypeCd);
		manufacturer = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndManufacturerIsNull(fromDate, toDate, subTypeCd);
		manufactureYear = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndManufacturingYearIsNull(fromDate, toDate, subTypeCd);
		currentRating = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndCurrentRatingIsNull(fromDate, toDate, subTypeCd);
		nominalVoltage = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndNominalVoltageIsNull(fromDate, toDate, subTypeCd);
		serialNumber = fuseRepository.countFuseByInstallationDateBetweenAndSubtypeCdAndSerialNumberIsNull(fromDate, toDate, subTypeCd);

		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Current Rating").value(Long.toString(currentRating)).build());
		assetDetails.add(AssetProperty.builder().key("Nominal Voltage").value(Long.toString(nominalVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("Serial Number").value(Long.toString(serialNumber)).build());

		return assetDetails;
	}

	public List<AssetProperty> getSecondaryOverheadConductorColumnCountResult(Date fromDate, Date toDate) {

		long totalRecord = 0;
		long installationDate = 0;
		long conductorSize = 0;
		long manufacturer = 0;
		long manufactureYear = 0;
		long nominalVoltage = 0;
		long currentRating = 0;
		//long shapeLength = 0;
		long conductorType = 0;

		totalRecord = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetween(fromDate, toDate);
		installationDate = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		conductorSize = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndConductorSizeIsNull(fromDate, toDate);
		manufacturer = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYear = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		nominalVoltage = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndNominalVoltageIsNull(fromDate, toDate);
		currentRating = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndCurrentRatingIsNull(fromDate, toDate);
		//shapeLength = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndShapeLengthIsNull(fromDate, toDate);
		conductorType = secondaryOverheadConductorRepository.countSecondaryOverheadConductorByInstallationDateBetweenAndConductorTypeIsNull(fromDate, toDate);

		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("conductorSize").value(Long.toString(conductorSize)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Nominal Voltage").value(Long.toString(nominalVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("Current Rating").value(Long.toString(currentRating)).build());
		//assetDetails.add(AssetProperty.builder().key("Shape Length").value(Long.toString(shapeLength)).build());
		assetDetails.add(AssetProperty.builder().key("Conductor Type").value(Long.toString(conductorType)).build());

		return assetDetails;
	}

	public List<AssetProperty> getPrimaryOverheadConductorColumnCountResult(Date fromDate, Date toDate) {

		long totalRecord = 0;
		long installationDate = 0;
		long conductorSize = 0;
		long manufacturer = 0;
		long manufactureYear = 0;
		long nominalVoltage = 0;
		long currentCarryingCapacity = 0;
		long conductorType = 0;

		totalRecord = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetween(fromDate, toDate);
		installationDate = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		conductorSize = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndConductorSizeIsNull(fromDate, toDate);
		manufacturer = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYear = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		nominalVoltage = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndNominalVoltageIsNull(fromDate, toDate);
		currentCarryingCapacity = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndCurrentCarryingCapacityIsNull(fromDate, toDate);
		conductorType = primaryOverheadConductorRepository.countPrimaryOverheadConductorByInstallationDateBetweenAndConductorTypeIsNull(fromDate, toDate);

		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("conductorSize").value(Long.toString(conductorSize)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Nominal Voltage").value(Long.toString(nominalVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("Current Carrying Capacity").value(Long.toString(currentCarryingCapacity)).build());
		assetDetails.add(AssetProperty.builder().key("Conductor Type").value(Long.toString(conductorType)).build());

		return assetDetails;
	}

	public List<AssetProperty> getPrimaryUndergroundCableColumnCountResult(Date fromDate, Date toDate) {

		long totalRecord = 0;
		long installationDate = 0;
		long conductorSize = 0;
		long manufacturer = 0;
		long manufactureYear = 0;
		long nominalVoltage = 0;
		long currentCarryingCapacity = 0;
		//long shapeLength = 0;
		long conductorMaterial = 0;

		totalRecord = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetween(fromDate, toDate);
		installationDate = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		conductorSize = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndConductorSizeIsNull(fromDate, toDate);
		manufacturer = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		manufactureYear = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		nominalVoltage = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndNominalVoltageIsNull(fromDate, toDate);
		currentCarryingCapacity = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndCurrentCarryingCapacityIsNull(fromDate, toDate);
		//shapeLength = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndShapeLengthIsNull(fromDate, toDate);
		conductorMaterial = primaryUndergroundCableRepository.countPrimaryUndergroundCableByInstallationDateBetweenAndConductorMaterialIsNull(fromDate, toDate);

		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("conductorSize").value(Long.toString(conductorSize)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Nominal Voltage").value(Long.toString(nominalVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("Current Carrying Capacity").value(Long.toString(currentCarryingCapacity)).build());
		//assetDetails.add(AssetProperty.builder().key("Shape Length").value(Long.toString(shapeLength)).build());
		assetDetails.add(AssetProperty.builder().key("Conductor Material").value(Long.toString(conductorMaterial)).build());

		return assetDetails;
	}

	public List<AssetProperty> getSecondaryUndergroundCableColumnCountResult(Date fromDate, Date toDate) {

		long totalRecord = 0;
		long installationDate = 0;
		long manufactureYear = 0;
		long manufacturer = 0;
		long nominalVoltage = 0;
		long conductorSize = 0;
		long numberOfForces = 0;
		//long shapeLength = 0;
		long currentRating = 0;
		long conductorMaterial = 0;

		totalRecord = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetween(fromDate, toDate);
		installationDate = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndInstallationDateIsNull(fromDate, toDate);
		manufactureYear = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndManufacturingYearIsNull(fromDate, toDate);
		manufacturer = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndManufacturerIsNull(fromDate, toDate);
		nominalVoltage = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndNominalVoltageIsNull(fromDate, toDate);
		conductorSize = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndConductorSizeIsNull(fromDate, toDate);
		numberOfForces = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndNumberOfForcesIsNull(fromDate, toDate);
		//shapeLength = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndShapeLengthIsNull(fromDate, toDate);
		currentRating = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndCurrentRatingIsNull(fromDate, toDate);
		conductorMaterial = secondaryUndergroundCableRepository.countSecondaryUndergroundCableByInstallationDateBetweenAndConductorMaterialIsNull(fromDate, toDate);

		List<AssetProperty> assetDetails = new ArrayList<>();

		assetDetails.add(AssetProperty.builder().key("Total Record").value(Long.toString(totalRecord)).build());
		assetDetails.add(AssetProperty.builder().key("Installation Date").value(Long.toString(installationDate)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacture Year").value(Long.toString(manufactureYear)).build());
		assetDetails.add(AssetProperty.builder().key("Manufacturer").value(Long.toString(manufacturer)).build());
		assetDetails.add(AssetProperty.builder().key("Nominal Voltage").value(Long.toString(nominalVoltage)).build());
		assetDetails.add(AssetProperty.builder().key("Conductor Size").value(Long.toString(conductorSize)).build());
		assetDetails.add(AssetProperty.builder().key("Number of Forces").value(Long.toString(numberOfForces)).build());
		//assetDetails.add(AssetProperty.builder().key("Shape Length").value(Long.toString(shapeLength)).build());
		assetDetails.add(AssetProperty.builder().key("Current Rating").value(Long.toString(currentRating)).build());
		assetDetails.add(AssetProperty.builder().key("Conductor Material").value(Long.toString(conductorMaterial)).build());

		return assetDetails;
	}

	public List<Transformer> getTranformersByDateAndSubTypeCd(Date fromDate, Date toDate, List<Integer> subTypeCds) {
		return transformerRepository.findAllTransformerByInstallationDateBetweenAndSubtypeCdIn(fromDate, toDate, subTypeCds);
	}

	public List<DynamicProtectiveDevice> getDynamicProtectiveDeviceByDateAndSubTypeCd(Date fromDate, Date toDate, Integer subTypeCd) {
		return dynamicProtectiveDeviceRepository.findAllDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCd(fromDate, toDate, subTypeCd);
	}

	public List<Switchs> getSwitchsByDateAndSubTypeCd(Date fromDate, Date toDate, Integer subTypeCd) {
		return switchsRepository.findAllSwitchByInstallationDateBetweenAndSubtypeCd(fromDate, toDate, subTypeCd);
	}

	public List<Busbar> getBusbarByDateAndSubTypeCd(Date fromDate,Date toDate, String busbarType , List<Integer> subTypeCds) {
		return busbarRepository.findAllBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdIn(fromDate, toDate, busbarType, subTypeCds);
	}

	public List<CapacitorBank> getCapacitorBankByDateAndSubTypeCd(Date fromDate, Date toDate) {
		return capacitorBankRepository.findAllCapacitorBankByInstallationDateBetween(fromDate, toDate);
	}

	public List<Pole> getPoleByDateAndSubTypeCd(Date fromDate, Date toDate) {
		return poleRepository.findAllPoleByInstallationDateBetween(fromDate, toDate);
	}

	public List<ControlAndRelay> getControlAndRelayByDateAndSubTypeCd() {
		return controlAndRelayRepository.findAll();
	}

	public List<BatteryBank> getBatteryBankByDateAndSubTypeCd(Date fromDate, Date toDate) {
		return batteryBankRepository.findAllBatteryBankByInstallationDateBetween(fromDate, toDate);
	}

	public List<Pillar> getPillarByDate(Date fromDate, Date toDate) {
		return pillarRepository.findAllPillarByInstallationDateBetween(fromDate, toDate);
	}

	public List<Fuse> getFuseByDateAndSubTypeCd(Date fromDate, Date toDate, Integer subTypeCd) {
		return fuseRepository.findAllFuseByInstallationDateBetweenAndSubtypeCd(fromDate, toDate, subTypeCd);
	}

	public List<SecondaryOverheadConductor> getSecondaryOverheadCounductorByDate(Date fromDate, Date toDate) {
		return secondaryOverheadConductorRepository.findAllSecondaryOverheadConductorByInstallationDateBetween(fromDate, toDate);
	}

	public List<PrimaryOverheadConductor> getPrimaryOverheadCounductorByDate(Date fromDate, Date toDate) {
		return primaryOverheadConductorRepository.findAllPrimaryOverheadConductorByInstallationDateBetween(fromDate, toDate);
	}

	public List<SecondaryUndergroundCable> getSeondaryUndergroundCableByDate(Date fromDate, Date toDate) {
		return secondaryUndergroundCableRepository.findAllSecondaryUndergroundCableByInstallationDateBetween(fromDate, toDate);
	}

	public List<PrimaryUndergroundCable> getPrimaryUndergroundCableByDate(Date fromDate, Date toDate) {
		return primaryUndergroundCableRepository.findAllPrimaryUndergroundCableByInstallationDateBetween(fromDate, toDate);
	}
}
