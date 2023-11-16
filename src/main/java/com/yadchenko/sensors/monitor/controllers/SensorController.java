package com.yadchenko.sensors.monitor.controllers;

import com.yadchenko.sensors.monitor.dto.PageDto;
import com.yadchenko.sensors.monitor.dto.SensorDto;
import com.yadchenko.sensors.monitor.services.SensorService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/sensor")
public class SensorController {

    private final SensorService sensorService;

    @GetMapping("/{id}")
    public SensorDto getById(@PathVariable Long id) {
        return sensorService.getById(id);
    }

    @PostMapping("/search")
    @PageableAsQueryParam
    public PageDto<SensorDto> search(@Parameter(hidden = true) Pageable pageable, @RequestBody @Nullable String phrase) {
        return sensorService.search(phrase, pageable);
    }

    @PostMapping("/save")
    @PageableAsQueryParam
    public void saveOrUpdate(@RequestBody SensorDto sensorDto) {
        sensorService.save(sensorDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sensorService.deleteById(id);
    }
}
