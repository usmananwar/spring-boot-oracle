package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "POLE")
public class Pole {

	@Id
	@Column(name = "OBJECTID")
	private long objectId;

	@Column(name = "EASTING")
	private Integer easting;

	@Column(name = "NORTHING")
	private Integer northing;

	@Column(name = "HEIGHT")
	private Integer height;

	@Temporal( TemporalType.DATE)
	@Column(name = "INSTALLATIONDATE")
	private Date installationDate;

	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "MANUFACTURINGYEAR")
	private Integer manufacturingYear;

	@Column(name = "FOUNDATION_TYPE")
	private String foundationType;

	@Column(name = "MATERIAL")
	private String material;

	@Column(name = "SUBTYPECD")
	private Integer subtypeCd;

	public Pole(long objectId, Integer easting, Integer northing, Integer height, Date installationDate, String manufacturer, Integer manufacturingYear, String foundationType, String material, Integer subtypeCd) {
		this.objectId = objectId;
		this.easting = easting;
		this.northing = northing;
		this.height = height;
		this.installationDate = installationDate;
		this.manufacturer = manufacturer;
		this.manufacturingYear = manufacturingYear;
		this.foundationType = foundationType;
		this.material = material;
		this.subtypeCd = subtypeCd;
	}

	public Pole() {

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

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
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

	public String getFoundationType() {
		return foundationType;
	}

	public void setFoundationType(String foundationType) {
		this.foundationType = foundationType;
	}

	public String  getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getSubtypeCd() {
		return subtypeCd;
	}

	public void setSubtypeCd(Integer subtypeCd) {
		this.subtypeCd = subtypeCd;
	}
}
