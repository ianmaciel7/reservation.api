package br.com.ucsal.reservation.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ucsal.reservation.api.repositories.LaboratoryRepository;
import br.com.ucsal.reservation.api.repositories.LaboratoryRepositoryMemory;
import br.com.ucsal.reservation.api.repositories.ReservationRepository;
import br.com.ucsal.reservation.api.repositories.ReservationRepositoryMemory;
import br.com.ucsal.reservation.api.repositories.UserRepository;
import br.com.ucsal.reservation.api.repositories.UserRepositoryMemory;
import br.com.ucsal.reservation.api.services.AuthBasicService;
import br.com.ucsal.reservation.api.services.AuthService;
import br.com.ucsal.reservation.api.services.LaboratoryService;
import br.com.ucsal.reservation.api.services.LaboratoryServiceImpl;
import br.com.ucsal.reservation.api.services.ReservationService;
import br.com.ucsal.reservation.api.services.ReservationServiceImpl;
import br.com.ucsal.reservation.api.services.UserService;
import br.com.ucsal.reservation.api.services.UserServiceImpl;

@Configuration
public class ApplicationConfig {

    @Bean
    public AuthService authService() {
        return new AuthBasicService();
    }

    @Bean
    public LaboratoryRepository laboratoryRepository() {
        return new LaboratoryRepositoryMemory();
    }

    @Bean
    public LaboratoryService laboratoryService() {
        return new LaboratoryServiceImpl();
    }

    @Bean
    public ReservationService reservationService() {
        return new ReservationServiceImpl();
    }

    @Bean
    public ReservationRepository reservationRepository() {
        return new ReservationRepositoryMemory();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryMemory();
    }
}