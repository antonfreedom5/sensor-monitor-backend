package com.yadchenko.sensors.monitor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;

@Entity
@Data
public class SensorType {
    @Id
    private Long id;
    @FullTextField
    private String name;
}
