package com.yadchenko.sensors.monitor.dto;

import com.yadchenko.sensors.monitor.entities.SensorType;
import com.yadchenko.sensors.monitor.entities.UnitType;

public record SensorDto(
    Long id,
    String name,
    String model,
    Integer from,
    Integer to,
    SensorType type,
    UnitType unit,
    String location,
    String description) {}
