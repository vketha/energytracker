package com.java.energytracker.telemetry.services.data.model;

import java.util.Map;
import java.util.UUID;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Device {
	@PrimaryKeyColumn(name = "id", ordinal = 1, type=PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
	private UUID id;
	
	private String name;
	
	@PrimaryKeyColumn(name = "id", ordinal = 0, type=PrimaryKeyType.PARTITIONED)
	private UUID homeId;
	
	private Map<String, Object> additionalInfo;

	public Device(UUID id, String name, UUID homeId) {
		this.id = id;
		this.name = name;
		this.homeId = homeId;
	}
	
	public Device(UUID id, String name, UUID homeId, Map<String, Object> additionaInfo) {
		this(id, name, homeId);
		this.additionalInfo = additionaInfo;
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

	public UUID getHomeId() {
		return homeId;
	}

	public void setHomeId(UUID homeId) {
		this.homeId = homeId;
	}		
}
