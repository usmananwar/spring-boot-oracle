package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "RELAYANDCONTROL")
public class ControlAndRelay {

	@Id
	@Column(name = "OBJECTID")
	private long objectId;

	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "CONTROLVOLTAGE")
	private String controlVoltage;

	public ControlAndRelay(long objectId, String manufacturer, String controlVoltage) {
		this.objectId = objectId;
		this.manufacturer = manufacturer;
		this.controlVoltage = controlVoltage;
	}

	public ControlAndRelay() {

	}

	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getControlVoltage() {
		return controlVoltage;
	}

	public void setControlVoltage(String controlVoltage) {
		this.controlVoltage = controlVoltage;
	}
}
