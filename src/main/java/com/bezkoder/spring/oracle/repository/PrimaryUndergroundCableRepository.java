package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.PrimaryUndergroundCable;

public interface PrimaryUndergroundCableRepository extends JpaRepository<PrimaryUndergroundCable, Long> {

	Long countPrimaryUndergroundCableByInstallationDateBetween(Date fromDate, Date toDate);

	Long countPrimaryUndergroundCableByInstallationDateBetweenAndInstallationDateIsNull(Date fromDate, Date toDate);

	Long countPrimaryUndergroundCableByInstallationDateBetweenAndManufacturingYearIsNull(Date fromDate, Date toDate);

	Long countPrimaryUndergroundCableByInstallationDateBetweenAndManufacturerIsNull(Date fromDate, Date toDate);

	Long countPrimaryUndergroundCableByInstallationDateBetweenAndNominalVoltageIsNull(Date fromDate, Date toDate);

	Long countPrimaryUndergroundCableByInstallationDateBetweenAndConductorSizeIsNull(Date fromDate, Date toDate);

	Long countPrimaryUndergroundCableByInstallationDateBetweenAndNumberOfForcesIsNull(Date fromDate, Date toDate);

	Long countPrimaryUndergroundCableByInstallationDateBetweenAndCurrentCarryingCapacityIsNull(Date fromDate, Date toDate);

//	Long countPrimaryUndergroundCableByInstallationDateBetweenAndShapeLengthIsNull(Date fromDate, Date toDate);

	Long countPrimaryUndergroundCableByInstallationDateBetweenAndConductorMaterialIsNull(Date fromDate, Date toDate);

	List<PrimaryUndergroundCable> findAllPrimaryUndergroundCableByInstallationDateBetween(Date fromDate, Date toDate);
}
