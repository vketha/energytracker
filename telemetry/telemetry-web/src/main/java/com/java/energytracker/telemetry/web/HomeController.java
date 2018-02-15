/**
 * 
 */
package com.java.energytracker.telemetry.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.energytracker.commons.controller.AbstractCrudController;
import com.java.energytracker.commons.dto.ResponseDto;
import com.java.energytracker.telemetry.core.dto.DeviceDto;
import com.java.energytracker.telemetry.core.dto.HomeDto;
import com.java.energytracker.telemetry.core.services.HomeService;

/**
 * 
 * @author vijayk
 *
 */
@RequestMapping(value = "/home")
public class HomeController extends AbstractCrudController<HomeDto, UUID> {

	@Autowired
	private HomeService homeService;
	
	@Override
	public boolean add(HomeDto body) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean update(UUID id, HomeDto body) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(UUID id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Optional<HomeDto> get(UUID id) {
		// TODO Auto-generated method stub
		return Optional.of(new HomeDto(UUID.randomUUID(), "Home"));
	}

	@RequestMapping(value = "{homeId}", method = RequestMethod.GET)
	public ResponseDto<List<DeviceDto>> getDevicesByHome(UUID homeId) {
		return successReponse(new ArrayList<DeviceDto>());
	}
}
