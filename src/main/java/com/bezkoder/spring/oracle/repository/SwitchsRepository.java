package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.Switchs;

public interface SwitchsRepository extends JpaRepository<com.bezkoder.spring.oracle.model.Switchs, Long> {

	Long countSwitchByInstallationDateBetweenAndSubtypeCd(Date fromDate, Date toDate, Integer subTypeCd);
	Long countSwitchByInstallationDateBetweenAndSubtypeCdAndEastingIsNull(Date fromDate, Date toDate, Integer subTypeCd);
	Long countSwitchByInstallationDateBetweenAndSubtypeCdAndNorthingIsNull(Date fromDate, Date toDate, Integer subTypeCd);
	Long countSwitchByInstallationDateBetweenAndSubtypeCdAndInstallationDateIsNull(Date fromDate, Date toDate, Integer subTypeCd);
	Long countSwitchByInstallationDateBetweenAndSubtypeCdAndManufacturerIsNull(Date fromDate, Date toDate, Integer subTypeCd);
	Long countSwitchByInstallationDateBetweenAndSubtypeCdAndManufacturingYearIsNull(Date fromDate, Date toDate, Integer subTypeCd);
	Long countSwitchByInstallationDateBetweenAndSubtypeCdAndCurrentRattingIsNull(Date fromDate, Date toDate, Integer subTypeCd);
	Long countSwitchByInstallationDateBetweenAndSubtypeCdAndNominalVoltageIsNull(Date fromDate, Date toDate, Integer subTypeCd);
	Long countSwitchByInstallationDateBetweenAndSubtypeCdAndModelIsNull(Date fromDate, Date toDate, Integer subTypeCd);
	Long countSwitchByInstallationDateBetweenAndSubtypeCdAndSerialNumberIsNull(Date fromDate, Date toDate, Integer subTypeCd);
	Long countSwitchByInstallationDateBetweenAndSubtypeCdAndMountingTypeIsNull(Date fromDate, Date toDate, Integer subTypeCd);
	
	List<Switchs> findAllSwitchByInstallationDateBetweenAndSubtypeCd(Date fromDate, Date toDate, Integer subTypeCd);
	
	
}
