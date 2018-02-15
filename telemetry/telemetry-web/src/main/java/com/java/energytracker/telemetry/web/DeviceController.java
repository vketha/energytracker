package com.java.energytracker.telemetry.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.energytracker.commons.controller.AbstractCrudController;
import com.java.energytracker.commons.dto.ResponseDto;
import com.java.energytracker.telemetry.core.dto.DeviceDto;
import com.java.energytracker.telemetry.core.dto.DeviceReadingDto;
import com.java.energytracker.telemetry.core.services.DeviceService;

@RestController
@RequestMapping(value = "/device")
public class DeviceController extends AbstractCrudController<DeviceDto, UUID> {
	
	@Autowired
	private DeviceService deviceService;

	@Override
	public boolean add(DeviceDto body) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean update(UUID id, DeviceDto body) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(UUID id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Optional<DeviceDto> get(UUID id) {
		// TODO Auto-generated method stub
		return Optional.of(new DeviceDto(UUID.randomUUID(), "Home", UUID.randomUUID()));
	}
	
	@RequestMapping(value = "{deviceId}/readings", method = RequestMethod.GET)
	public ResponseDto<List<DeviceReadingDto>> getReadingsByDevice(UUID deviceId) {
		return successReponse(new ArrayList<DeviceReadingDto>());		
	}
	
	@RequestMapping(value = "{deviceId}/readings/aggregate", method = RequestMethod.GET)
	public ResponseDto<DeviceReadingDto> getReadingsAggregateDevice(UUID deviceId, @RequestParam Date from, @RequestParam Date to) {
		return successReponse(new DeviceReadingDto(0.0, ""));		
	}
}
