/**
 * 
 */
package com.java.energytracker.telemetry.services.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.java.energytracker.telemetry.services.data.model.DeviceReading;

/**
 * @author vijayk
 *
 */
public interface DeviceReadingRepository extends CassandraRepository<DeviceReading> {

}
