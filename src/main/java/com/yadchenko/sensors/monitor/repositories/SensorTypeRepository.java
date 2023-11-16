package com.yadchenko.sensors.monitor.repositories;

import com.yadchenko.sensors.monitor.entities.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {}
