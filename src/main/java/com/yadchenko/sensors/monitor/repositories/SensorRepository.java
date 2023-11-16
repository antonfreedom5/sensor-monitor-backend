package com.yadchenko.sensors.monitor.repositories;

import com.yadchenko.sensors.monitor.entities.Sensor;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends SearchSensorRepository<Sensor, Long> {
}
