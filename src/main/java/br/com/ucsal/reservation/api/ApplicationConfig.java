package br.com.ucsal.reservation.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ucsal.reservation.api.repositories.LaboratoryRepository;
import br.com.ucsal.reservation.api.repositories.LaboratoryRepositoryMemory;
import br.com.ucsal.reservation.api.services.LaboratoryService;
import br.com.ucsal.reservation.api.services.LaboratoryServiceImpl;

@Configuration
public class ApplicationConfig {

    @Bean
    public LaboratoryRepository laboratoryRepository() {
        return new LaboratoryRepositoryMemory();
    }

    @Bean
    public LaboratoryService laboratoryService() {
        return new LaboratoryServiceImpl();
    }
}