/**
 * 
 */
package com.java.energytracker.telemetry.core.dto;

import java.util.Date;

import com.java.energytracker.commons.dto.BaseDto;

/**
 * @author vijayk
 *
 */
public class DeviceReadingDto extends BaseDto {
	private Double value;
	private String units;
	private Date date;
	
	public DeviceReadingDto(Double value, String units) {
		this.value = value;
		this.units = units;
	}
	
	public DeviceReadingDto(Double value, String units, Date date) {
		this(value, units);
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
