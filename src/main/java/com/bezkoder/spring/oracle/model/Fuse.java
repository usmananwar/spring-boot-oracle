package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "FUSE")
public class Fuse {

	@Id
	@Column(name = "OBJECTID")
	private long objectId;

	@Column(name = "EASTING")
	private Integer easting;

	@Column(name = "NORTHING")
	private Integer northing;

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

	@Column(name = "SERIALNUMBER")
	private String serialNumber;

	@Column(name = "SUBTYPECD")
	private Integer subtypeCd;

	public Fuse(long objectId, Integer easting, Integer northing, Date installationDate, String manufacturer, Integer manufacturingYear, String currentRating, Integer nominalVoltage, String serialNumber, Integer subtypeCd) {
		this.objectId = objectId;
		this.easting = easting;
		this.northing = northing;
		this.installationDate = installationDate;
		this.manufacturer = manufacturer;
		this.manufacturingYear = manufacturingYear;
		this.currentRating = currentRating;
		this.nominalVoltage = nominalVoltage;
		this.serialNumber = serialNumber;
		this.subtypeCd = subtypeCd;
	}

	public Fuse() {

	}

	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}

	public Integer getEasting() {
		return easting;
	}

	public void setEasting(Integer easting) {
		this.easting = easting;
	}

	public Integer getNorthing() {
		return northing;
	}

	public void setNorthing(Integer northing) {
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

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getSubtypeCd() {
		return subtypeCd;
	}

	public void setSubtypeCd(Integer subtypeCd) {
		this.subtypeCd = subtypeCd;
	}

}
