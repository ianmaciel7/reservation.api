package br.com.ucsal.reservation.api.services;

import org.springframework.stereotype.Component;

import br.com.ucsal.reservation.api.inputModels.LoginInputViewModel;

@Component
public interface AuthService {
    public String login(LoginInputViewModel loginInputViewModel) throws Exception;
}
