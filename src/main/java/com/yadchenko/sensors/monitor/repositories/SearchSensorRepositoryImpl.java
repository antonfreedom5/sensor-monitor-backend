package com.yadchenko.sensors.monitor.repositories;

import com.yadchenko.sensors.monitor.dto.PageDto;
import com.yadchenko.sensors.monitor.entities.Sensor;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;

@Transactional
public class SearchSensorRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
    implements SearchSensorRepository<T, ID> {

    private final String[] SEARCH_FIELDS = new String[]{ "name", "model", "location", "description", "type.name", "unit.name", "rangeValue" };

    private final EntityManager entityManager;

    public SearchSensorRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    public SearchSensorRepositoryImpl(
        JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public PageDto<Sensor> searchBy(String terms, Pageable pageable) {
        var result = Search.session((Session) entityManager).search(Sensor.class)
            .where(f -> terms == null ? f.matchAll() : terms.split(" ").length > 1
                ? f.phrase().fields(SEARCH_FIELDS).matching(terms)
                : f.wildcard().fields(SEARCH_FIELDS)
                .matching("*" + terms + "*"))
            .fetch(pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize());
        return new PageDto<>(result.hits(), result.total().hitCount());
    }
}
