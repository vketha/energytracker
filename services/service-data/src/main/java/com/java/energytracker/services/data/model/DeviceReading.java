package com.java.energytracker.services.data.model;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class DeviceReading {
	@PrimaryKeyColumn(name = "id", ordinal = 1, type=PrimaryKeyType.PARTITIONED)
	private UUID deviceId;
	
	@PrimaryKeyColumn(name = "id", ordinal = 0, type=PrimaryKeyType.PARTITIONED)
	private UUID homeId;
	
	private Double reading;
	
	private String units;
	
	private Date date; 
	
	@Column
	private Map<String, Object> additionalInfo;

	public DeviceReading(UUID homeId, UUID deviceId, Double reading, String units, Date date) {
		this.homeId = homeId;
		this.deviceId = deviceId;
		this.reading = reading;
		this.units = units;
		this.setDate(date);
	}

	public DeviceReading(UUID homeId, UUID deviceId, Double reading, String units, Date date, Map<String, Object> additionalInfo) {
		this(homeId, deviceId, reading, units, date);
		this.additionalInfo = additionalInfo;
	}
	
	public UUID getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(UUID deviceId) {
		this.deviceId = deviceId;
	}

	public UUID getHomeId() {
		return homeId;
	}

	public void setHomeId(UUID homeId) {
		this.homeId = homeId;
	}

	public Double getReading() {
		return reading;
	}

	public void setReading(Double reading) {
		this.reading = reading;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Map<String, Object> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
