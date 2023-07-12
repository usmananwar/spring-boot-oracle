package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.DynamicProtectiveDevice;

public interface DynamicProtectiveDeviceRepository extends JpaRepository<DynamicProtectiveDevice, Long> {

	Long countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCd(Date fromDate, Date toDate, Integer subTypeCd);

	Long countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndEastingIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndNorthingIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndInstallationDateIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndManufacturerIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndManufacturingYearIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndCurrentRattingIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndNominalVoltageIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndTypeIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndSerialNumberIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCdAndInterruptingMediumIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	List<DynamicProtectiveDevice> findAllDynamicProtectiveDeviceByInstallationDateBetweenAndSubtypeCd(Date fromDate, Date toDate, Integer subTypeCd);
}
