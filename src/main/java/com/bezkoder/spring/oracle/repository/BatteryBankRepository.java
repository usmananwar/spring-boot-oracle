package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.BatteryBank;

public interface BatteryBankRepository extends JpaRepository<BatteryBank, Long> {

	Long countBatteryBankByInstallationDateBetween(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndEastingIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndNorthingIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndInstallationDateIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndManufacturerIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndManufacturingYearIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndCellRatedVoltageIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndBatteryTypeIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndSerialNumberIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndBatteryAmpHourIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndBatteryCountIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndBatteryChargerAcInputVoltageIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndBatteryChargerAcInputCurrentIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndBatteryChargerDcOutputVoltageIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndBatteryChargerDcOutputCurrentIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndBatteryChargerManufacturerIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndBatteryChargerManufacturingYearIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndBatteryChargerTypeIsNull(Date fromDate, Date toDate);

	Long countBatteryBankByInstallationDateBetweenAndBatteryChargerSerialNumberIsNull(Date fromDate, Date toDate);

	List<BatteryBank> findAllBatteryBankByInstallationDateBetween(Date fromDate, Date toDate);

}
