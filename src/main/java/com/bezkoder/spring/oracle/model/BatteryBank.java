package com.bezkoder.spring.oracle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "mjec", name = "BATTERYBANK")
public class BatteryBank {

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
	private String manufacturingYear;

	@Column(name = "CELLVOLTAGERATED")
	private String cellRatedVoltage;

	@Column(name = "BATTERYTYPE")
	private String batteryType;

	@Column(name = "SERIALNUMBER")
	private String serialNumber;

	@Column(name = "BATTERYAMPHOUR")
	private String batteryAmpHour;

	@Column(name = "BATTERYCOUNT")
	private Integer batteryCount;

	@Column(name = "CHARGER_AC_INPUT_VOLTAGE")
	private String batteryChargerAcInputVoltage;

	@Column(name = "CHARGER_AC_INPUT_CURRENT")
	private String batteryChargerAcInputCurrent;

	@Column(name = "CHARGER_DC_OUTPUT_VOLTAGE")
	private String batteryChargerDcOutputVoltage;

	@Column(name = "CHARGER_DC_OUTPUT_CURRENT")
	private String batteryChargerDcOutputCurrent;

	@Column(name = "CHARGER_MANUFACTURER")
	private String batteryChargerManufacturer;

	@Column(name = "CHARGER_MANUFACTURING_YEAR")
	private String batteryChargerManufacturingYear;

	@Column(name = "CHARGER_TYPE")
	private String batteryChargerType;

	@Column(name = "CHARGER_SERIAL_NUMBER")
	private String batteryChargerSerialNumber;

	public BatteryBank(long objectId, String  easting, String northing, Date installationDate, String manufacturer, String manufacturingYear, String cellRatedVoltage, String batteryType, String serialNumber, String batteryAmpHour, Integer batteryCount, String batteryChargerAcInputVoltage, String batteryChargerAcInputCurrent, String batteryChargerDcOutputVoltage, String batteryChargerDcOutputCurrent, String batteryChargerManufacturer, String batteryChargerManufacturingYear,
			String batteryChargerType, String batteryChargerSerialNumber) {
		this.objectId = objectId;
		this.easting = easting;
		this.northing = northing;
		this.installationDate = installationDate;
		this.manufacturer = manufacturer;
		this.manufacturingYear = manufacturingYear;
		this.cellRatedVoltage = cellRatedVoltage;
		this.batteryType = batteryType;
		this.serialNumber = serialNumber;
		this.batteryAmpHour = batteryAmpHour;
		this.batteryCount = batteryCount;
		this.batteryChargerAcInputVoltage = batteryChargerAcInputVoltage;
		this.batteryChargerAcInputCurrent = batteryChargerAcInputCurrent;
		this.batteryChargerDcOutputVoltage = batteryChargerDcOutputVoltage;
		this.batteryChargerDcOutputCurrent = batteryChargerDcOutputCurrent;
		this.batteryChargerManufacturer = batteryChargerManufacturer;
		this.batteryChargerManufacturingYear = batteryChargerManufacturingYear;
		this.batteryChargerType = batteryChargerType;
		this.batteryChargerSerialNumber = batteryChargerSerialNumber;
	}

	public BatteryBank() {

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

	public String getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(String manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public String getCellRatedVoltage() {
		return cellRatedVoltage;
	}

	public void setCellRatedVoltage(String cellRatedVoltage) {
		this.cellRatedVoltage = cellRatedVoltage;
	}

	public String getBatteryType() {
		return batteryType;
	}

	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBatteryAmpHour() {
		return batteryAmpHour;
	}

	public void setBatteryAmpHour(String batteryAmpHour) {
		this.batteryAmpHour = batteryAmpHour;
	}

	public Integer getBatteryCount() {
		return batteryCount;
	}

	public void setBatteryCount(Integer batteryCount) {
		this.batteryCount = batteryCount;
	}

	public String getBatteryChargerAcInputVoltage() {
		return batteryChargerAcInputVoltage;
	}

	public void setBatteryChargerAcInputVoltage(String batteryChargerAcInputVoltage) {
		this.batteryChargerAcInputVoltage = batteryChargerAcInputVoltage;
	}

	public String getBatteryChargerAcInputCurrent() {
		return batteryChargerAcInputCurrent;
	}

	public void setBatteryChargerAcInputCurrent(String batteryChargerAcInputCurrent) {
		this.batteryChargerAcInputCurrent = batteryChargerAcInputCurrent;
	}

	public String getBatteryChargerDcOutputVoltage() {
		return batteryChargerDcOutputVoltage;
	}

	public void setBatteryChargerDcOutputVoltage(String batteryChargerDcOutputVoltage) {
		this.batteryChargerDcOutputVoltage = batteryChargerDcOutputVoltage;
	}

	public String getBatteryChargerDcOutputCurrent() {
		return batteryChargerDcOutputCurrent;
	}

	public void setBatteryChargerDcOutputCurrent(String batteryChargerDcOutputCurrent) {
		this.batteryChargerDcOutputCurrent = batteryChargerDcOutputCurrent;
	}

	public String getBatteryChargerManufacturer() {
		return batteryChargerManufacturer;
	}

	public void setBatteryChargerManufacturer(String batteryChargerManufacturer) {
		this.batteryChargerManufacturer = batteryChargerManufacturer;
	}

	public String getBatteryChargerManufacturingYear() {
		return batteryChargerManufacturingYear;
	}

	public void setBatteryChargerManufacturingYear(String batteryChargerManufacturingYear) {
		this.batteryChargerManufacturingYear = batteryChargerManufacturingYear;
	}

	public String getBatteryChargerType() {
		return batteryChargerType;
	}

	public void setBatteryChargerType(String batteryChargerType) {
		this.batteryChargerType = batteryChargerType;
	}

	public String getBatteryChargerSerialNumber() {
		return batteryChargerSerialNumber;
	}

	public void setBatteryChargerSerialNumber(String batteryChargerSerialNumber) {
		this.batteryChargerSerialNumber = batteryChargerSerialNumber;
	}

}
