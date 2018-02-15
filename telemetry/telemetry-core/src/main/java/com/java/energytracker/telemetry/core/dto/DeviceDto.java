/**
 * 
 */
package com.java.energytracker.telemetry.core.dto;

import java.util.Map;
import java.util.UUID;

import com.java.energytracker.commons.dto.BaseDto;

/**
 * 
 * @author vijayk
 *
 */
public class DeviceDto extends BaseDto {
	
	private UUID id;
	private String name;
	private UUID homeId;
	private Map<String, Object> additionalInfo;
	
	public DeviceDto(UUID id, String name, UUID homeId) {
		this.id = id;
		this.name = name;
		this.homeId = homeId;
	}
	
	public DeviceDto(UUID id, String name, UUID homeId, Map<String, Object> additionalInfo) {
		this(id, name, homeId);
		this.additionalInfo = additionalInfo;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public UUID getHomeId() {
		return homeId;
	}
	
	public void setHomeId(UUID homeId) {
		this.homeId = homeId;
	}
	
	public Map<String, Object> getAdditionalInfo() {
		return additionalInfo;
	}
	
	public void setAdditionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
