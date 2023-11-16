package com.yadchenko.sensors.monitor.controllers;

import com.yadchenko.sensors.monitor.entities.SensorType;
import com.yadchenko.sensors.monitor.services.SensorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sensor-type")
public class SensorTypeController {

    private final SensorTypeService sensorTypeService;

    @GetMapping()
    public List<SensorType> getAll() {
        return sensorTypeService.getAll();
    }
}
