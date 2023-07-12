package com.bezkoder.spring.oracle.repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.bezkoder.spring.oracle.model.Transformer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransformerRepository extends JpaRepository<Transformer, Long> {

	//List<Transformer> findByInstallationDateGreaterThanEqual(LocalDate installationDate);

	Long countTransformerByInstallationDateBetweenAndSubtypeCdIn(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndInstallationDateIsNullAndSubtypeCdIn(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndManufacturingYearIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndManufacturerIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndSerialNumberIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndVectorGroupIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndLowSideVoltageIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndHighSideVoltageIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndRatingIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndCoolingTypeIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndImpedanceIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndEastingIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndNorthingIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndHvRatedCurrentIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndLvRatedCurrentIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcManufacturerIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcManufacturerYearIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcTypeIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
//	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcTapsNoIsNullOrInstallationDateBetweenAndOltcTapsNo(Date fromDate, Date toDate, List<Integer> subTypeCd, Date fromDate2, Date toDate2,String OltcTapsNo);
    Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcTapsNoIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndOltcSerialNumberIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);
	Long countTransformerByInstallationDateBetweenAndSubtypeCdInAndInsulationIsNull(Date fromDate, Date toDate, List<Integer> subTypeCd);

	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3)", nativeQuery = true)
	Long findTransformerTotalNullCountByInstallationDateBetweenAndSubtypeCd(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.INSTALLATIONDATE is NULL", nativeQuery = true)
	Long findTransformerByInstallationDateAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.ManufacturingYear is NULL", nativeQuery = true)
	Long findTransformerByManufacturingYearAndInstallationDateIsLessThanEqual(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.Manufacturer is NULL", nativeQuery = true)
	Long findTransformerByManufacturerAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.SerialNumber is NULL", nativeQuery = true)
	Long findTransformerBySerialNumberAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.VectorGroup is NULL", nativeQuery = true)
	Long findTransformerByVectorGroupAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.LowSideVoltage is NULL", nativeQuery = true)
	Long findTransformerByLowSideVoltageAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.HighSideVoltage is NULL", nativeQuery = true)
	Long findTransformerByHighSideVoltageAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.RatedKVA is NULL", nativeQuery = true)
	Long findTransformerByRatingAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.CoolingType is NULL", nativeQuery = true)
	Long findTransformerByCoolingTypeAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.Impedance is NULL", nativeQuery = true)
	Long findTransformerByImpedanceAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.Easting is NULL", nativeQuery = true)
	Long findTransformerByEastingAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.Northing is NULL", nativeQuery = true)
	Long findTransformerByNorthingAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.Hv_Rated_Current is NULL", nativeQuery = true)
	Long findTransformerByHvRatedCurrentInstallationDateIsLessThanEqual(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.Lv_Rated_Current is NULL", nativeQuery = true)
	Long findTransformerByLvRatedCurrentAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.Oltc_Manufacturer is NULL", nativeQuery = true)
	Long findTransformerByOltcManufacturerAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.OLTC_MANUFACTUREYEAR is NULL", nativeQuery = true)
	Long findTransformerByOltcManufacturerYearAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.Oltc_Type is NULL", nativeQuery = true)
	Long findTransformerByOltcTypeAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.Oltc_TapsNo is NULL", nativeQuery = true)
	Long findTransformerByOltcTapsNoAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.Oltc_SerialNumber is NULL", nativeQuery = true)
	Long findTransformerByOltcSerialNumberInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	@Query(value = "SELECT COUNT(*) FROM MJEC.TRANSFORMER t WHERE t.INSTALLATIONDATE BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')  and (t.SUBTYPECD = 2 OR t.SUBTYPECD = 3) and t.INTERRUPTION_MEDUIM is NULL", nativeQuery = true)
	Long findTransformerByInsulationAndInstallationDateBetween(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	
	
	
	List<Transformer> findAllTransformerByInstallationDateBetweenAndSubtypeCdIn(Date fromDate, Date toDate, List<Integer> subTypeCds);

}
