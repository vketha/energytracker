/**
 * 
 */
package com.java.energytracker.commons.controller;

import org.springframework.web.bind.annotation.RestController;

import com.java.energytracker.commons.dto.BaseDto;
import com.java.energytracker.commons.dto.ResponseDto;

/**
 * @author vijayk
 *
 */
@RestController
public abstract class BaseController {
	
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILURE = "FAILURE";
	
	protected <V extends BaseDto> ResponseDto<V> successReponse() {
		return new ResponseDto<>(SUCCESS, "");
	}
	
	protected <V extends BaseDto> ResponseDto<V> successReponse(String message) {
		return new ResponseDto<>(SUCCESS, message);
	}
	
	protected <V> ResponseDto<V> successReponse(V content) {
		return new ResponseDto<V>(SUCCESS, "", content);
	}
	
	protected <V> ResponseDto<V> successReponse(String message, V content) {
		return new ResponseDto<V>(SUCCESS, message, content);
	}
	
	protected <V> ResponseDto<V> failureReponse() {
		return new ResponseDto<V>(FAILURE, "");
	}
	
	protected <V> ResponseDto<V> failureResponse(String message) {
		return new ResponseDto<V>(FAILURE, message);
	}
	
	protected <V> ResponseDto<V> failureResponse(V content) {
		return new ResponseDto<V>(FAILURE, "", content);
	}
	
	protected <V> ResponseDto<V> failureResponse(String message, V content) {
		return new ResponseDto<V>(FAILURE, message, content);
	}
}
