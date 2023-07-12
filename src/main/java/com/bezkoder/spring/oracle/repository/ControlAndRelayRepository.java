package com.bezkoder.spring.oracle.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.ControlAndRelay;

public interface ControlAndRelayRepository extends JpaRepository<ControlAndRelay, Long> {

	Long countControlAndRelayByManufacturerIsNull();
	Long countControlAndRelayByControlVoltageIsNull();

}
