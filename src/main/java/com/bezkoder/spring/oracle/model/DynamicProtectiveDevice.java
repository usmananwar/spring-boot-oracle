package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "DYNAMICPROTECTIVEDEVICE")
public class DynamicProtectiveDevice {

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

	@Column(name = "CURRENTRATING")
	private String currentRatting;

	@Column(name = "NOMINALVOLTAGE")
	private Integer nominalVoltage;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "SERIALNUMBER")
	private String serialNumber;

	@Column(name = "INTERRUPTINGMEDIUM")
	private String interruptingMedium;

	@Column(name = "SUBTYPECD")
	private Integer subtypeCd;


	public DynamicProtectiveDevice(long objectId, Integer easting, Integer northing, Date installationDate, String manufacturer, Integer manufacturingYear, String currentRatting, Integer nominalVoltage, String type, String serialNumber, String interruptingMedium, Integer subtypeCd) {
		this.objectId = objectId;
		this.easting = easting;
		this.northing = northing;
		this.installationDate = installationDate;
		this.manufacturer = manufacturer;
		this.manufacturingYear = manufacturingYear;
		this.currentRatting = currentRatting;
		this.nominalVoltage = nominalVoltage;
		this.type = type;
		this.serialNumber = serialNumber;
		this.interruptingMedium = interruptingMedium;
		this.subtypeCd = subtypeCd;
	}

	public DynamicProtectiveDevice() {

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

	public String getInterruptingMedium() {
		return interruptingMedium;
	}

	public void setInterruptingMedium(String interruptingMedium) {
		this.interruptingMedium = interruptingMedium;
	}

	public Integer getSubtypeCd() {
		return subtypeCd;
	}

	public void setSubtypeCd(Integer subtypeCd) {
		this.subtypeCd = subtypeCd;
	}
}
