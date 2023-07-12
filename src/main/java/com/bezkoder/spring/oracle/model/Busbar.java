package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "BUSBAR")
public class Busbar {

	@Id
	@Column(name = "OBJECTID")
	private long objectId;

	@Column(name = "EASTING")
	private String easting;

	@Column(name = "NORTHING")
	private String northing;

	@Temporal(TemporalType.DATE)
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

	@Column(name = "BUSBARTYPE")
	private String busbarType;

	@Column(name = "SUBTYPECD")
	private Integer subTypeCd;

	public Busbar(long objectId, String easting, String northing, Date installationDate, String manufacturer, Integer manufacturingYear, String currentRating, Integer nominalVoltage, String busbarType, Integer subTypeCd) {
		this.objectId = objectId;
		this.easting = easting;
		this.northing = northing;
		this.installationDate = installationDate;
		this.manufacturer = manufacturer;
		this.manufacturingYear = manufacturingYear;
		this.currentRating = currentRating;
		this.nominalVoltage = nominalVoltage;
		this.busbarType = busbarType;
		this.subTypeCd = subTypeCd;
	}

	public Busbar() {

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

	public Integer getSubTypeCd() {
		return subTypeCd;
	}

	public String getBusbarType() {
		return busbarType;
	}

	public void setBusbarType(String busbarType) {
		this.busbarType = busbarType;
	}

	public void setSubTypeCd(Integer subTypeCd) {
		this.subTypeCd = subTypeCd;
	}

}
