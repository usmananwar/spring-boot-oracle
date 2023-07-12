package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "PILLAR")
public class Pillar {

	@Id
	@Column(name = "OBJECTID")
	private long objectId;

	@Column(name = "EASTING")
	private String easting;

	@Column(name = "NORTHING")
	private String northing;

	@Temporal( TemporalType.DATE)
	@Column(name = "INSTALLATIONDATE")
	private Date installationDate;

	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "MANUFACTURINGYEAR")
	private Integer manufacturingYear;

	@Column(name = "CURRENT_RATING")
	private String currentRating;

	@Column(name = "NOMINALVOLTAGE")
	private Integer nominalVoltage;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "SERIALNUMBER")
	private String serialNumber;

	public Pillar(long objectId, String easting, String northing, Date installationDate, String manufacturer, Integer manufacturingYear, String currentRating, Integer nominalVoltage, String type, String serialNumber) {
		this.objectId = objectId;
		this.easting = easting;
		this.northing = northing;
		this.installationDate = installationDate;
		this.manufacturer = manufacturer;
		this.manufacturingYear = manufacturingYear;
		this.currentRating = currentRating;
		this.nominalVoltage = nominalVoltage;
		this.type = type;
		this.serialNumber = serialNumber;
	}

	public Pillar() {

	}

	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}

	public String getEasting() {
		return easting;
	}

	public void setEasting(String easting) {
		this.easting = easting;
	}

	public String getNorthing() {
		return northing;
	}

	public void setNorthing(String northing) {
		this.northing = northing;
	}

	public Date getInstallationDate() {
		return installationDate;
	}

	public void setInstallationDate(Date installationDate) {
		this.installationDate = installationDate;
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

	public String getCurrentRating() {
		return currentRating;
	}

	public void setCurrentRating(String currentRating) {
		this.currentRating = currentRating;
	}

	public Integer getNominalVoltage() {
		return nominalVoltage;
	}

	public void setNominalVoltage(Integer nominalVoltage) {
		this.nominalVoltage = nominalVoltage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
}
