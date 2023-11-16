package com.yadchenko.sensors.monitor.services;

import com.yadchenko.sensors.monitor.entities.SensorType;
import java.util.List;

public interface SensorTypeService {
    List<SensorType> getAll();
}
