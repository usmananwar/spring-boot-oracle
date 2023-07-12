package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.Busbar;

public interface BusbarRepository extends JpaRepository<Busbar, Long> {

	Long countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdIn(Date fromDate, Date toDate, String busbarType, List<Integer> subTypeCd);

	Long countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndInstallationDateIsNull(Date fromDate, Date toDate, String busbarType, List<Integer> subTypeCd);

	Long countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndEastingIsNull(Date fromDate, Date toDate, String busbarType, List<Integer> subTypeCd);

	Long countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndNorthingIsNull(Date fromDate, Date toDate, String busbarType, List<Integer> subTypeCd);

	Long countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndManufacturerIsNull(Date fromDate, Date toDate, String busbarType, List<Integer> subTypeCd);

	Long countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndManufacturingYearIsNull(Date fromDate, Date toDate, String busbarType, List<Integer> subTypeCd);

	Long countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndCurrentRatingIsNull(Date fromDate, Date toDate, String busbarType, List<Integer> subTypeCd);

	Long countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndNominalVoltageIsNull(Date fromDate, Date toDate, String busbarType, List<Integer> subTypeCd);

	Long countBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdInAndBusbarTypeIsNull(Date fromDate, Date toDate, String busbarType, List<Integer> subTypeCd);

	List<Busbar> findAllBusbarByInstallationDateBetweenAndBusbarTypeAndSubTypeCdIn(Date fromDate, Date toDate,String busbarType, List<Integer> subTypeCd);
}
