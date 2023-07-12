package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "transformer")
public class Transformer {

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

	@Column(name = "SUBTYPECD")
	private Integer subtypeCd;

	@Column(name = "SERIALNUMBER")
	private String serialNumber;

	@Column(name = "VECTORGROUP")
	private String vectorGroup;

	@Column(name = "LOWSIDEVOLTAGE")
	private Integer lowSideVoltage;

	@Column(name = "HIGHSIDEVOLTAGE")
	private Integer highSideVoltage;

	@Column(name = "RATEDKVA")
	private Integer rating;

	@Column(name = "COOLINGTYPE")
	private String coolingType;

	@Column(name = "IMPEDANCE")
	private String impedance;

	@Column(name = "EASTING")
	private Integer easting;

	@Column(name = "NORTHING")
	private Integer northing;

	@Column(name = "HV_RATED_CURRENT")
	private String hvRatedCurrent;

	@Column(name = "LV_RATED_CURRENT")
	private String lvRatedCurrent;

	@Column(name = "OLTC_MANUFACTURER")
	private String oltcManufacturer;

	@Column(name = "OLTC_MANUFACTUREYEAR")
	private String oltcManufacturerYear;

	@Column(name = "OLTC_TYPE")
	private String oltcType;

	@Column(name = "OLTC_TAPSNO")
	private String oltcTapsNo;

	@Column(name = "OLTC_SERIALNUMBER")
	private String oltcSerialNumber;

	@Column(name = "INTERRUPTION_MEDUIM")
	private String insulation;



	public Transformer() {

	}

	public Transformer(long objectId, Date installationDate, Integer manufacturingYear, String manufacturer, Integer subtypeCd,
					   String serialNumber, String vectorGroup, Integer lowSideVoltage, Integer highSideVoltage, Integer rating,
					   String coolingType, String impedance, Integer easting, Integer northing, String hvRatedCurrent,
					   String lvRatedCurrent, String oltcManufacturer, String oltcManufacturerYear, String oltcType,
					   String oltcTapsNo, String oltcSerialNumber, String insulation) {
		this.objectId = objectId;
		this.installationDate = installationDate;
		this.manufacturingYear = manufacturingYear;
		this.manufacturer = manufacturer;
		this.subtypeCd = subtypeCd;
		this.serialNumber = serialNumber;
		this.vectorGroup = vectorGroup;
		this.lowSideVoltage = lowSideVoltage;
		this.highSideVoltage = highSideVoltage;
		this.rating = rating;
		this.coolingType = coolingType;
		this.impedance = impedance;
		this.easting = easting;
		this.northing = northing;
		this.hvRatedCurrent = hvRatedCurrent;
		this.lvRatedCurrent = lvRatedCurrent;
		this.oltcManufacturer = oltcManufacturer;
		this.oltcManufacturerYear = oltcManufacturerYear;
		this.oltcType = oltcType;
		this.oltcTapsNo = oltcTapsNo;
		this.oltcSerialNumber = oltcSerialNumber;
		this.insulation = insulation;
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

	public Integer getSubtypeCd() {
		return subtypeCd;
	}

	public void setSubtypeCd(Integer subtypeCd) {
		this.subtypeCd = subtypeCd;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getVectorGroup() {
		return vectorGroup;
	}

	public void setVectorGroup(String vectorGroup) {
		this.vectorGroup = vectorGroup;
	}

	public Integer getLowSideVoltage() {
		return lowSideVoltage;
	}

	public void setLowSideVoltage(Integer lowSideVoltage) {
		this.lowSideVoltage = lowSideVoltage;
	}

	public Integer getHighSideVoltage() {
		return highSideVoltage;
	}

	public void setHighSideVoltage(Integer highSideVoltage) {
		this.highSideVoltage = highSideVoltage;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getCoolingType() {
		return coolingType;
	}

	public void setCoolingType(String coolingType) {
		this.coolingType = coolingType;
	}

	public String getImpedance() {
		return impedance;
	}

	public void setImpedance(String impedance) {
		this.impedance = impedance;
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

	public String getHvRatedCurrent() {
		return hvRatedCurrent;
	}

	public void setHvRatedCurrent(String hvRatedCurrent) {
		this.hvRatedCurrent = hvRatedCurrent;
	}

	public String getLvRatedCurrent() {
		return lvRatedCurrent;
	}

	public void setLvRatedCurrent(String lvRatedCurrent) {
		this.lvRatedCurrent = lvRatedCurrent;
	}

	public String getOltcManufacturer() {
		return oltcManufacturer;
	}

	public void setOltcManufacturer(String oltcManufacturer) {
		this.oltcManufacturer = oltcManufacturer;
	}

	public String getOltcManufacturerYear() {
		return oltcManufacturerYear;
	}

	public void setOltcManufacturerYear(String oltcManufacturerYear) {
		this.oltcManufacturerYear = oltcManufacturerYear;
	}

	public String getOltcType() {
		return oltcType;
	}

	public void setOltcType(String oltcType) {
		this.oltcType = oltcType;
	}

	public String getOltcTapsNo() {
		return oltcTapsNo;
	}

	public void setOltcTapsNo(String oltcTapsNo) {
		this.oltcTapsNo = oltcTapsNo;
	}

	public String getOltcSerialNumber() {
		return oltcSerialNumber;
	}

	public void setOltcSerialNumber(String oltcSerialNumber) {
		this.oltcSerialNumber = oltcSerialNumber;
	}

	public String getInsulation() {
		return insulation;
	}

	public void setInsulation(String insulation) {
		this.insulation = insulation;
	}

	@Override
	public String toString() {
		return "Transformer [objectId=" + objectId + ", installationDate=" + installationDate + ", manufacturingYear=" + manufacturingYear + ", manufacturer=" + manufacturer + "]";
	}

}
