package com.yadchenko.sensors.monitor.services.impl;

import com.yadchenko.sensors.monitor.dto.PageDto;
import com.yadchenko.sensors.monitor.dto.SensorDto;
import com.yadchenko.sensors.monitor.entities.Sensor;
import com.yadchenko.sensors.monitor.repositories.SensorRepository;
import com.yadchenko.sensors.monitor.services.SensorService;
import com.yadchenko.sensors.monitor.services.mappers.SensorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    @Override
    public PageDto<SensorDto> search(String phrase, Pageable pageable) {
        PageDto<Sensor> searchResult = sensorRepository.searchBy(phrase, pageable);
        List<SensorDto> sensorDto = searchResult.content().stream().map(sensorMapper::toSensorDto).toList();
        return new PageDto<>(sensorDto, searchResult.totalElements());
    }

    @Override
    public SensorDto getById(Long id) {
        return sensorMapper.toSensorDto(sensorRepository.getById(id));
    }

    @Override
    public void save(SensorDto sensorDto) {
        sensorRepository.save(sensorMapper.toSensor(sensorDto));
    }

    @Override
    public void deleteById(Long id) {
        sensorRepository.deleteById(id);
    }
}
