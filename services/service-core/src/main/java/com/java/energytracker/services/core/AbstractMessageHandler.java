/**
 * 
 */
package com.java.energytracker.services.core;

/**
 * @author vijayk
 *
 */
public abstract class AbstractMessageHandler<T extends Message> implements MessageHandler<T> {
	
	public void onMessageReceived(T message) {
		 process(message);
		// TODO: persist event
	}
}
