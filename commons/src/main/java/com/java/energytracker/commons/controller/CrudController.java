package com.java.energytracker.commons.controller;

import java.util.Optional;

import com.java.energytracker.commons.dto.BaseDto;

public interface CrudController<T extends BaseDto, ID> {
	
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILURE = "FAILURE";
			
	public boolean add(T body);
	
	public boolean update(ID id, T body);
	
	public boolean delete(ID id);
	
	public Optional<T> get(ID id);
}
