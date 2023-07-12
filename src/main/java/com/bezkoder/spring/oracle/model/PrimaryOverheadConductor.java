package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "PRIMARYOVERHEADCONDUCTOR")
public class PrimaryOverheadConductor {

	@Id
	@Column(name = "OBJECTID")
	private long objectId;

	@Temporal( TemporalType.DATE)
	@Column(name = "INSTALLATIONDATE")
	private Date installationDate;

	@Column(name = "CONDUCTORSIZE")
	private Integer conductorSize;

	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "MANUFACTURINGYEAR")
	private Integer manufacturingYear;

	@Column(name = "NOMINALVOLTAGE")
	private Integer nominalVoltage;

	@Column(name = "CURRENT_CARRYING_CAPACITY")
	private String currentCarryingCapacity;

	@Column(name = "CONDUCTORTYPE")
	private String conductorType;

	public PrimaryOverheadConductor(long objectId, Date installationDate, Integer conductorSize, String manufacturer, Integer manufacturingYear, Integer nominalVoltage, String currentCarryingCapacity, String conductorType) {
		this.objectId = objectId;
		this.installationDate = installationDate;
		this.conductorSize = conductorSize;
		this.manufacturer = manufacturer;
		this.manufacturingYear = manufacturingYear;
		this.nominalVoltage = nominalVoltage;
		this.currentCarryingCapacity = currentCarryingCapacity;
		this.conductorType = conductorType;
	}

	public PrimaryOverheadConductor() {

	}

	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}

	public Date getInstallationDate() {
		return installationDate;
	}

	public void setInstallationDate(Date installationDate) {
		this.installationDate = installationDate;
	}

	public Integer getConductorSize() {
		return conductorSize;
	}

	public void setConductorSize(Integer conductorSize) {
		this.conductorSize = conductorSize;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(Integer manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public Integer getNominalVoltage() {
		return nominalVoltage;
	}

	public void setNominalVoltage(Integer nominalVoltage) {
		this.nominalVoltage = nominalVoltage;
	}

	public String getCurrentCarryingCapacity() {
		return currentCarryingCapacity;
	}

	public void setCurrentCarryingCapacity(String currentCarryingCapacity) {
		this.currentCarryingCapacity = currentCarryingCapacity;
	}
	public String getConductorType() {
		return conductorType;
	}

	public void setConductorType(String conductorType) {
		this.conductorType = conductorType;
	}
}
