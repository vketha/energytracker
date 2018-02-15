/**
 * 
 */
package com.java.energytracker.telemetry.services.core;

import com.java.energytracker.telemetry.services.data.model.DeviceReading;

/**
 * @author vijayk
 *
 */
public interface MessageHandler<T extends Message> {
	
	public DeviceReading process(T message);
}
