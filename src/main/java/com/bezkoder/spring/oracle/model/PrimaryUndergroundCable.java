package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "PRIMARYUNDERGROUNDCABLE")
public class PrimaryUndergroundCable {

	@Id
	@Column(name = "OBJECTID")
	private long objectId;

	@Temporal( TemporalType.DATE)
	@Column(name = "INSTALLATIONDATE")
	private Date installationDate;

	@Column(name = "MANUFACTURINGYEAR")
	private Integer manufacturingYear;

	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "NOMINALVOLTAGE")
	private Integer nominalVoltage;

	@Column(name = "CONDUCTORSIZE")
	private String conductorSize;

	@Column(name = "NUMBEROFCORES")
	private Integer numberOfForces;

//	@Column(name = "SHAPE")
//	private Float shapeLength;

	@Column(name = "CURRENT_CARRYING_CAPACITY")
	private String currentCarryingCapacity;

	@Column(name = "CONDUCTORMATERIAL")
	private String conductorMaterial;

	public PrimaryUndergroundCable(long objectId, Date installationDate, Integer manufacturingYear, String manufacturer, Integer nominalVoltage, String conductorSize, Integer numberOfForces, String currentCarryingCapacity, String conductorMaterial) {
		this.objectId = objectId;
		this.installationDate = installationDate;
		this.manufacturingYear = manufacturingYear;
		this.manufacturer = manufacturer;
		this.nominalVoltage = nominalVoltage;
		this.conductorSize = conductorSize;
		this.numberOfForces = numberOfForces;
		//this.shapeLength = shapeLength;
		this.currentCarryingCapacity = currentCarryingCapacity;
		this.conductorMaterial = conductorMaterial;
	}

	public PrimaryUndergroundCable() {

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

	public Integer getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(Integer manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getNominalVoltage() {
		return nominalVoltage;
	}

	public void setNominalVoltage(Integer nominalVoltage) {
		this.nominalVoltage = nominalVoltage;
	}

	public String getConductorSize() {
		return conductorSize;
	}

	public void setConductorSize(String conductorSize) {
		this.conductorSize = conductorSize;
	}

	public Integer getNumberOfForces() {
		return numberOfForces;
	}

	public void setNumberOfForces(Integer numberOfForces) {
		this.numberOfForces = numberOfForces;
	}

//	public Float getShapeLength() {
//		return shapeLength;
//	}

//	public void setShapeLength(Float shapeLength) {
//		this.shapeLength = shapeLength;
//	}

	public String getCurrentCarryingCapacity() {
		return currentCarryingCapacity;
	}

	public void setCurrentCarryingCapacity(String currentCarryingCapacity) {
		this.currentCarryingCapacity = currentCarryingCapacity;
	}

	public String getConductorMaterial() {
		return conductorMaterial;
	}

	public void setConductorMaterial(String conductorMaterial) {
		this.conductorMaterial = conductorMaterial;
	}
}
