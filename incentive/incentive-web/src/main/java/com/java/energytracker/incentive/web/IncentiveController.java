/**
 * 
 */
package com.java.energytracker.incentive.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.energytracker.commons.controller.BaseController;
import com.java.energytracker.commons.dto.ResponseDto;
import com.java.energytracker.incentive.core.dto.IncentiveDto;
import com.java.energytracker.incentive.core.services.IncentiveService;

/**
 * 
 * @author vijayk
 *
 */
@RestController
@RequestMapping(value = "/home")
public class IncentiveController extends BaseController {

	private IncentiveService incentiveService;
	
	@RequestMapping(value = "{homeId}/incentives")
	public ResponseDto<List<IncentiveDto>> getIncentivesByHome(@PathVariable UUID homeId) {
		return successReponse(new ArrayList<IncentiveDto>());
	}
}
