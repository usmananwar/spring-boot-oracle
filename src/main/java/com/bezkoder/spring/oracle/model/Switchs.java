package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "SWITCH")
public class Switchs {

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
	private String currentRatting;

	@Column(name = "NOMINALVOLTAGE")
	private Integer nominalVoltage;

	@Column(name = "MODEL")
	private String model;

	@Column(name = "SERIALNUMBER")
	private String serialNumber;

	@Column(name = "MOUNTINGTYPE")
	private String mountingType;

	@Column(name = "SUBTYPECD")
	private Integer subtypeCd;

	public Switchs(long objectId, Integer easting, Integer northing, Date installationDate, String manufacturer, Integer manufacturingYear, String currentRatting, Integer nominalVoltage, String model, String serialNumber, String mountingType, Integer subtypeCd) {
		this.objectId = objectId;
		this.easting = easting;
		this.northing = northing;
		this.installationDate = installationDate;
		this.manufacturer = manufacturer;
		this.manufacturingYear = manufacturingYear;
		this.currentRatting = currentRatting;
		this.nominalVoltage = nominalVoltage;
		this.model = model;
		this.serialNumber = serialNumber;
		this.mountingType = mountingType;
		this.subtypeCd = subtypeCd;
	}

	public Switchs() {

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

	public String getCurrentRatting() {
		return currentRatting;
	}

	public void setCurrentRatting(String currentRatting) {
		this.currentRatting = currentRatting;
	}

	public Integer getNominalVoltage() {
		return nominalVoltage;
	}

	public void setNominalVoltage(Integer nominalVoltage) {
		this.nominalVoltage = nominalVoltage;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getMountingType() {
		return mountingType;
	}

	public void setMountingType(String mountingType) {
		this.mountingType = mountingType;
	}

	public Integer getSubtypeCd() {
		return subtypeCd;
	}

	public void setSubtypeCd(Integer subtypeCd) {
		this.subtypeCd = subtypeCd;
	}

}
