package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "SECONDARYUNDERGROUNDCABLE")
public class SecondaryUndergroundCable {

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

	@Column(name = "CURRENTRATING")
	private String currentRating;

	@Column(name = "CONDUCTORMATERIAL")
	private String conductorMaterial;

	public SecondaryUndergroundCable(long objectId, Date installationDate, Integer manufacturingYear, String manufacturer, Integer nominalVoltage, String conductorSize, Integer numberOfForces, String currentRating, String conductorMaterial) {
		this.objectId = objectId;
		this.installationDate = installationDate;
		this.manufacturingYear = manufacturingYear;
		this.manufacturer = manufacturer;
		this.nominalVoltage = nominalVoltage;
		this.conductorSize = conductorSize;
		this.numberOfForces = numberOfForces;
		//this.shapeLength = shapeLength;
		this.currentRating = currentRating;
		this.conductorMaterial = conductorMaterial;
	}

	public SecondaryUndergroundCable() {

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

	public String getCurrentRating() {
		return currentRating;
	}

	public void setCurrentRating(String currentRating) {
		this.currentRating = currentRating;
	}

	public String getConductorMaterial() {
		return conductorMaterial;
	}

	public void setConductorMaterial(String conductorMaterial) {
		this.conductorMaterial = conductorMaterial;
	}
}
