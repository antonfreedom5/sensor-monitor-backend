package com.yadchenko.sensors.monitor.services.impl;

import com.yadchenko.sensors.monitor.entities.SensorType;
import com.yadchenko.sensors.monitor.repositories.SensorTypeRepository;
import com.yadchenko.sensors.monitor.services.SensorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorTypeServiceImpl implements SensorTypeService {

    private final SensorTypeRepository sensorTypeRepository;
    @Override
    public List<SensorType> getAll() {
        return sensorTypeRepository.findAll();
    }
}
