package com.yadchenko.sensors.monitor.services;

import com.yadchenko.sensors.monitor.entities.Sensor;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class IndexingService {

    private final EntityManager entityManager;

    @Transactional
    public void initiateIndexing() throws InterruptedException {
        System.out.println("indexing...");
        SearchSession searchSession = Search.session((Session) entityManager);
        MassIndexer indexer = searchSession.massIndexer( Sensor.class )
            .threadsToLoadObjects( 4 );
        indexer.startAndWait();
    }
}