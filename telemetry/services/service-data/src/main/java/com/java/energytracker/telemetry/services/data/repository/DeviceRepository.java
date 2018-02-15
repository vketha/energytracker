/**
 * 
 */
package com.java.energytracker.telemetry.services.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.java.energytracker.telemetry.services.data.model.Device;

/**
 * @author vijayk
 *
 */
public interface DeviceRepository extends CassandraRepository<Device> {

}
