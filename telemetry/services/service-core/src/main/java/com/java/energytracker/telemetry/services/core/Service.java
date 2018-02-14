/**
 * 
 */
package com.java.energytracker.telemetry.services.core;

/**
 * @author vijayk
 *
 */
public interface Service {

	void start();
	
	void suspend();
	
	void resume();

	void stop();	
}
