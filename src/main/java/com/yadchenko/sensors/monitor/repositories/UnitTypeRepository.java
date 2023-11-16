package com.yadchenko.sensors.monitor.repositories;

import com.yadchenko.sensors.monitor.entities.UnitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Long> {}
