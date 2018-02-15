/**
 * 
 */
package com.java.energytracker.telemetry.services.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.java.energytracker.telemetry.services.data.model.Home;

/**
 * @author vijayk
 *
 */
public interface HomeRepository extends CassandraRepository<Home> {

}
