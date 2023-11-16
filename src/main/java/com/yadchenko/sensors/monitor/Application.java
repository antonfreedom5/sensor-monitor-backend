package com.yadchenko.sensors.monitor;

import com.yadchenko.sensors.monitor.repositories.SearchSensorRepositoryImpl;
import com.yadchenko.sensors.monitor.services.IndexingService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = SearchSensorRepositoryImpl.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ApplicationRunner buildIndex(IndexingService indexingService) {
		return (org.springframework.boot.ApplicationArguments args) -> {
			indexingService.initiateIndexing();
		};
	}
}
