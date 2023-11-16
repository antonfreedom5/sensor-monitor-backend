package com.yadchenko.sensors.monitor.services.impl;

import com.yadchenko.sensors.monitor.entities.UnitType;
import com.yadchenko.sensors.monitor.repositories.UnitTypeRepository;
import com.yadchenko.sensors.monitor.services.UnitTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitTypeServiceImpl implements UnitTypeService {

    private final UnitTypeRepository unitTypeRepository;
    @Override
    public List<UnitType> getAll() {
        return unitTypeRepository.findAll();
    }
}
