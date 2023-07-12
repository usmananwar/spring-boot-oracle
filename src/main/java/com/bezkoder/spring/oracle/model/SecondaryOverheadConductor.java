package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "SECONDARYOVERHEADCONDUCTOR")
public class SecondaryOverheadConductor {

	@Id
	@Column(name = "OBJECTID")
	private long objectId;

	@Temporal( TemporalType.DATE)
	@Column(name = "INSTALLATIONDATE")
	private Date installationDate;

	@Column(name = "CONDUCTORSIZE")
	private String conductorSize;

	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "MANUFACTURINGYEAR")
	private Integer manufacturingYear;

	@Column(name = "NOMINALVOLTAGE")
	private Integer nominalVoltage;

	@Column(name = "CURRENTRATING")
	private String currentRating;

//	@Column(name = "SHAPE")
//	private Float shapeLength;

	@Column(name = "CONDUCTORTYPE")
	private String conductorType;

	public SecondaryOverheadConductor(long objectId, Date installationDate, String conductorSize, String manufacturer, Integer manufacturingYear, Integer nominalVoltage, String currentRating, String conductorType) {
		this.objectId = objectId;
		this.installationDate = installationDate;
		this.conductorSize = conductorSize;
		this.manufacturer = manufacturer;
		this.manufacturingYear = manufacturingYear;
		this.nominalVoltage = nominalVoltage;
		this.currentRating = currentRating;
		//this.shapeLength = shapeLength;
		this.conductorType = conductorType;
	}

	public SecondaryOverheadConductor() {

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

	public String getConductorSize() {
		return conductorSize;
	}

	public void setConductorSize(String conductorSize) {
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

	public String getCurrentRating() {
		return currentRating;
	}

	public void setCurrentRating(String currentRating) {
		this.currentRating = currentRating;
	}

//	public Float getShapeLength() {
//		return shapeLength;
//	}

//	public void setShapeLength(Float shapeLength) {
//		this.shapeLength = shapeLength;
//	}

	public String getConductorType() {
		return conductorType;
	}

	public void setConductorType(String conductorType) {
		this.conductorType = conductorType;
	}
}
