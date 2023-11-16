package com.yadchenko.sensors.monitor.repositories;

import com.yadchenko.sensors.monitor.dto.PageDto;
import com.yadchenko.sensors.monitor.entities.Sensor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.io.Serializable;

@NoRepositoryBean
public interface SearchSensorRepository <T, ID extends Serializable> extends JpaRepository<T, ID> {
    PageDto<Sensor> searchBy(String terms, Pageable pageable);
}
