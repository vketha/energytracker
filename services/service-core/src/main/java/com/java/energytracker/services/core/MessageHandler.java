/**
 * 
 */
package com.java.energytracker.services.core;

import com.java.energytracker.services.data.model.DeviceReading;

/**
 * @author vijayk
 *
 */
public interface MessageHandler<T extends Message> {
	
	public DeviceReading process(T message);
}
