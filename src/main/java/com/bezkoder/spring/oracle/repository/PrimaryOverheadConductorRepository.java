package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.PrimaryOverheadConductor;

public interface PrimaryOverheadConductorRepository extends JpaRepository<PrimaryOverheadConductor, Long> {

	Long countPrimaryOverheadConductorByInstallationDateBetween(Date fromDate, Date toDate);

	Long countPrimaryOverheadConductorByInstallationDateBetweenAndInstallationDateIsNull(Date fromDate, Date toDate);

	Long countPrimaryOverheadConductorByInstallationDateBetweenAndConductorSizeIsNull(Date fromDate, Date toDate);

	Long countPrimaryOverheadConductorByInstallationDateBetweenAndManufacturerIsNull(Date fromDate, Date toDate);

	Long countPrimaryOverheadConductorByInstallationDateBetweenAndManufacturingYearIsNull(Date fromDate, Date toDate);

	Long countPrimaryOverheadConductorByInstallationDateBetweenAndNominalVoltageIsNull(Date fromDate, Date toDate);

	Long countPrimaryOverheadConductorByInstallationDateBetweenAndCurrentCarryingCapacityIsNull(Date fromDate, Date toDate);

	Long countPrimaryOverheadConductorByInstallationDateBetweenAndConductorTypeIsNull(Date fromDate, Date toDate);

	List<PrimaryOverheadConductor> findAllPrimaryOverheadConductorByInstallationDateBetween(Date fromDate, Date toDate);
}
