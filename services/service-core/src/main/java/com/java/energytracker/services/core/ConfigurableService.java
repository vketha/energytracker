/**
 * 
 */
package com.java.energytracker.services.core;

/**
 * @author vijayk
 *
 */
public interface ConfigurableService<T extends ServiceConfiguration> extends Service {
	
	public void init(T configuration);
}
