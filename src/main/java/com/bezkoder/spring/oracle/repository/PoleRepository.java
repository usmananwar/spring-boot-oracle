package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.Pole;

public interface PoleRepository extends JpaRepository<Pole, Long> {

	Long countPoleByInstallationDateBetween(Date fromDate, Date toDate);
	Long countPoleByInstallationDateBetweenAndEastingIsNull(Date fromDate, Date toDate);
	Long countPoleByInstallationDateBetweenAndNorthingIsNull(Date fromDate, Date toDate);
	Long countPoleByInstallationDateBetweenAndHeightIsNull(Date fromDate, Date toDate);
	Long countPoleByInstallationDateBetweenAndInstallationDateIsNull(Date fromDate, Date toDate);
	Long countPoleByInstallationDateBetweenAndManufacturerIsNull(Date fromDate, Date toDate);
	Long countPoleByInstallationDateBetweenAndManufacturingYearIsNull(Date fromDate, Date toDate);
	Long countPoleByInstallationDateBetweenAndFoundationTypeIsNull(Date fromDate, Date toDate);
	Long countPoleByInstallationDateBetweenAndMaterialIsNull(Date fromDate, Date toDate);
	Long countPoleByInstallationDateBetweenAndSubtypeCdIsNull(Date fromDate, Date toDate);
	
	
	List<Pole> findAllPoleByInstallationDateBetween(Date fromDate, Date toDate);
}
