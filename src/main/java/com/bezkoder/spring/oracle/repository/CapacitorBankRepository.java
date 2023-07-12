package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.CapacitorBank;

public interface CapacitorBankRepository extends JpaRepository<CapacitorBank, Long> {

	Long countCapacitorBankByInstallationDateBetween(Date fromDate, Date toDate);

	Long countCapacitorBankByInstallationDateBetweenAndEastingIsNull(Date fromDate, Date toDate);

	Long countCapacitorBankByInstallationDateBetweenAndNorthingIsNull(Date fromDate, Date toDate);

	Long countCapacitorBankByInstallationDateBetweenAndInstallationDateIsNull(Date fromDate, Date toDate);

	Long countCapacitorBankByInstallationDateBetweenAndManufacturerIsNull(Date fromDate, Date toDate);

	Long countCapacitorBankByInstallationDateBetweenAndManufacturingYearIsNull(Date fromDate, Date toDate);

	Long countCapacitorBankByInstallationDateBetweenAndNominalVoltageIsNull(Date fromDate, Date toDate);

	Long countCapacitorBankByInstallationDateBetweenAndTypeIsNull(Date fromDate, Date toDate);

	Long countCapacitorBankByInstallationDateBetweenAndSerialNumberIsNull(Date fromDate, Date toDate);

	Long countCapacitorBankByInstallationDateBetweenAndRatingMVARIsNull(Date fromDate, Date toDate);

	List<CapacitorBank> findAllCapacitorBankByInstallationDateBetween(Date fromDate, Date toDate);
}
