package com.yadchenko.sensors.monitor.services.mappers;

import com.yadchenko.sensors.monitor.dto.SensorDto;
import com.yadchenko.sensors.monitor.entities.Sensor;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper {
    private final String RANGE_REGEXP = "(?<=\\d)(-)(?=-?\\d)";

    public SensorDto toSensorDto(Sensor sensor) {
        String[] range = sensor.getRangeValue().split(RANGE_REGEXP);
        return new SensorDto(
            sensor.getId(),
            sensor.getName(),
            sensor.getModel(),
            range[0] != null ? Integer.parseInt(range[0]) : null,
            range[1] != null ? Integer.parseInt(range[1]) : null,
            sensor.getType(), sensor.getUnit(),
            sensor.getLocation(),
            sensor.getDescription());
    }

    public Sensor toSensor(SensorDto sensorDto) {
        Sensor sensor = new Sensor();
        sensor.setId(sensorDto.id());
        sensor.setName(sensorDto.name());
        sensor.setModel(sensorDto.model());
        sensor.setRangeValue(String.format("%d-%d", sensorDto.from(), sensorDto.to()));
        sensor.setType(sensorDto.type());
        sensor.setUnit(sensorDto.unit());
        sensor.setLocation(sensorDto.location());
        sensor.setDescription(sensorDto.description());
        return sensor;
    }
}
