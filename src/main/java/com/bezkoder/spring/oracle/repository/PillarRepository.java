package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.Pillar;

public interface PillarRepository extends JpaRepository<Pillar, Long> {

	Long countPillarByInstallationDateBetween(Date fromDate, Date toDate);

	Long countPillarByInstallationDateBetweenAndEastingIsNull(Date fromDate, Date toDate);

	Long countPillarByInstallationDateBetweenAndNorthingIsNull(Date fromDate, Date toDate);

	Long countPillarByInstallationDateBetweenAndInstallationDateIsNull(Date fromDate, Date toDate);

	Long countPillarByInstallationDateBetweenAndManufacturerIsNull(Date fromDate, Date toDate);

	Long countPillarByInstallationDateBetweenAndManufacturingYearIsNull(Date fromDate, Date toDate);

	Long countPillarByInstallationDateBetweenAndCurrentRatingIsNull(Date fromDate, Date toDate);

	Long countPillarByInstallationDateBetweenAndNominalVoltageIsNull(Date fromDate, Date toDate);

	Long countPillarByInstallationDateBetweenAndTypeIsNull(Date fromDate, Date toDate);

	Long countPillarByInstallationDateBetweenAndSerialNumberIsNull(Date fromDate, Date toDate);

	List<Pillar> findAllPillarByInstallationDateBetween(Date fromDate, Date toDate);
}
