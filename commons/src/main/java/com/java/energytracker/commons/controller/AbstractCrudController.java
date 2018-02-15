/**
 * 
 */
package com.java.energytracker.commons.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.energytracker.commons.dto.BaseDto;
import com.java.energytracker.commons.dto.ResponseDto;

/**
 * 
 * @author vijayk
 *
 */
@RestController
public abstract class AbstractCrudController<T extends BaseDto, ID> implements CrudController<T, ID> {
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseDto<T> addEntity(@RequestBody T body) {
		boolean result = add(body);
		
		return result ? successReponse("Created Successfully") : failureResponse("Failed to create entity"); 
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseDto<T> updateEntity(@PathVariable ID id, @RequestBody T body) {
		boolean result = update(id, body);
		
		return result ? successReponse("Updated Successfully") : failureResponse("Failed to update entity"); 
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseDto<T> deleteEntity(@PathVariable ID id) {
		boolean result = delete(id);
		
		return result ? successReponse("Deleted Successfully") : failureResponse("Failed to delete entity"); 
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseDto<T> getEntity(@PathVariable ID id) {
		Optional<T> result = get(id);
		
		return result.isPresent() ? successReponse(result.get()) : failureResponse("Entity not found"); 
	}
	
	
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
