/**
 * 
 */
package com.java.energytracker.telemetry.services.core;

import com.java.energytracker.telemetry.services.data.model.Event;

/**
 * @author vijayk
 *
 */
public abstract class AbstractMessageHandler<T extends Message> implements MessageHandler<T> {
	
	public void onMessageReceived(T message) {
		Event event = process(message);
		// TODO: persist event
	}
}
