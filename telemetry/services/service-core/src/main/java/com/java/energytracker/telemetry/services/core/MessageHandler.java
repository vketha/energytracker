/**
 * 
 */
package com.java.energytracker.telemetry.services.core;

import com.java.energytracker.telemetry.services.data.model.Event;

/**
 * @author vijayk
 *
 */
public interface MessageHandler<T extends Message> {
	
	public Event process(T message);
}
