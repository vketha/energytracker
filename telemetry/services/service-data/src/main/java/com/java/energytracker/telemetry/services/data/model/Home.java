package com.java.energytracker.telemetry.services.data.model;

import java.util.Map;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Home {
	@PrimaryKeyColumn(name = "id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	
	private String name;
	
	private Map<String, Object> additionalInfo;
	
	public Home(UUID id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Home(UUID id, String name, Map<String, Object> additionalInfo) {
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
