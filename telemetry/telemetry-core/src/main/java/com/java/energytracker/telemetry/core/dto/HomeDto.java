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
public class HomeDto extends BaseDto {
	
	private UUID id;
	private String name;
	private Map<String, Object> additionalInfo;
	
	public HomeDto(UUID id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public HomeDto(UUID id, String name, Map<String, Object> additionalInfo) {
		this(id, name);
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

	public Map<String, Object> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
