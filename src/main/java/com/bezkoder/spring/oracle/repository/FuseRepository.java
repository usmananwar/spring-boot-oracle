package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.Fuse;

public interface FuseRepository extends JpaRepository<Fuse, Long> {

	Long countFuseByInstallationDateBetweenAndSubtypeCd(Date fromDate, Date toDate, Integer subTypeCd);

	Long countFuseByInstallationDateBetweenAndSubtypeCdAndEastingIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countFuseByInstallationDateBetweenAndSubtypeCdAndNorthingIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countFuseByInstallationDateBetweenAndSubtypeCdAndInstallationDateIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countFuseByInstallationDateBetweenAndSubtypeCdAndManufacturerIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countFuseByInstallationDateBetweenAndSubtypeCdAndManufacturingYearIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countFuseByInstallationDateBetweenAndSubtypeCdAndCurrentRatingIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countFuseByInstallationDateBetweenAndSubtypeCdAndNominalVoltageIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	Long countFuseByInstallationDateBetweenAndSubtypeCdAndSerialNumberIsNull(Date fromDate, Date toDate, Integer subTypeCd);

	List<Fuse> findAllFuseByInstallationDateBetweenAndSubtypeCd(Date fromDate, Date toDate, Integer subTypeCd);

}
