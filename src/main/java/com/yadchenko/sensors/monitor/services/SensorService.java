package com.yadchenko.sensors.monitor.services;

import com.yadchenko.sensors.monitor.dto.PageDto;
import com.yadchenko.sensors.monitor.dto.SensorDto;
import org.springframework.data.domain.Pageable;

public interface SensorService {

    PageDto<SensorDto> search(String phrase, Pageable pageable);
    SensorDto getById(Long id);

    void save(SensorDto sensorDto);

    void deleteById(Long id);
}
