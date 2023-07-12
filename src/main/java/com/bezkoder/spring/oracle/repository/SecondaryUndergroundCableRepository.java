package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.SecondaryUndergroundCable;

public interface SecondaryUndergroundCableRepository extends JpaRepository<SecondaryUndergroundCable, Long> {

	Long countSecondaryUndergroundCableByInstallationDateBetween(Date fromDate, Date toDate);

	Long countSecondaryUndergroundCableByInstallationDateBetweenAndInstallationDateIsNull(Date fromDate, Date toDate);

	Long countSecondaryUndergroundCableByInstallationDateBetweenAndManufacturingYearIsNull(Date fromDate, Date toDate);

	Long countSecondaryUndergroundCableByInstallationDateBetweenAndManufacturerIsNull(Date fromDate, Date toDate);

	Long countSecondaryUndergroundCableByInstallationDateBetweenAndNominalVoltageIsNull(Date fromDate, Date toDate);

	Long countSecondaryUndergroundCableByInstallationDateBetweenAndConductorSizeIsNull(Date fromDate, Date toDate);

	Long countSecondaryUndergroundCableByInstallationDateBetweenAndNumberOfForcesIsNull(Date fromDate, Date toDate);

	//Long countSecondaryUndergroundCableByInstallationDateBetweenAndShapeLengthIsNull(Date fromDate, Date toDate);

	Long countSecondaryUndergroundCableByInstallationDateBetweenAndCurrentRatingIsNull(Date fromDate, Date toDate);

	Long countSecondaryUndergroundCableByInstallationDateBetweenAndConductorMaterialIsNull(Date fromDate, Date toDate);

	List<SecondaryUndergroundCable> findAllSecondaryUndergroundCableByInstallationDateBetween(Date fromDate, Date toDate);

}
