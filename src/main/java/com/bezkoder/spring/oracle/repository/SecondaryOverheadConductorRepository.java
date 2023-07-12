package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.SecondaryOverheadConductor;

public interface SecondaryOverheadConductorRepository extends JpaRepository<SecondaryOverheadConductor, Long> {

	Long countSecondaryOverheadConductorByInstallationDateBetween(Date fromDate, Date toDate);

	Long countSecondaryOverheadConductorByInstallationDateBetweenAndInstallationDateIsNull(Date fromDate, Date toDate);

	Long countSecondaryOverheadConductorByInstallationDateBetweenAndConductorSizeIsNull(Date fromDate, Date toDate);

	Long countSecondaryOverheadConductorByInstallationDateBetweenAndManufacturerIsNull(Date fromDate, Date toDate);

	Long countSecondaryOverheadConductorByInstallationDateBetweenAndManufacturingYearIsNull(Date fromDate, Date toDate);

	Long countSecondaryOverheadConductorByInstallationDateBetweenAndNominalVoltageIsNull(Date fromDate, Date toDate);

	Long countSecondaryOverheadConductorByInstallationDateBetweenAndCurrentRatingIsNull(Date fromDate, Date toDate);

	//Long countSecondaryOverheadConductorByInstallationDateBetweenAndShapeLengthIsNull(Date fromDate, Date toDate);

	Long countSecondaryOverheadConductorByInstallationDateBetweenAndConductorTypeIsNull(Date fromDate, Date toDate);

	List<SecondaryOverheadConductor> findAllSecondaryOverheadConductorByInstallationDateBetween(Date fromDate, Date toDate);
}
