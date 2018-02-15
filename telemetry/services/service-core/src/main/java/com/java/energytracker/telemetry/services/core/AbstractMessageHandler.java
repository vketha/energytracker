/**
 * 
 */
package com.java.energytracker.telemetry.services.core;

import com.java.energytracker.telemetry.services.data.model.DeviceReading;

/**
 * @author vijayk
 *
 */
public abstract class AbstractMessageHandler<T extends Message> implements MessageHandler<T> {
	
	public void onMessageReceived(T message) {
		DeviceReading event = process(message);
		// TODO: persist event
	}
}
