package com.yadchenko.sensors.monitor.controllers;

import com.yadchenko.sensors.monitor.entities.UnitType;
import com.yadchenko.sensors.monitor.services.UnitTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/unit-type")
public class UnitTypeController {

    private final UnitTypeService unitTypeService;

    @GetMapping()
    public List<UnitType> getAll() {
        return unitTypeService.getAll();
    }
}
