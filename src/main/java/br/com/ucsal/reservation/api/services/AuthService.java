package br.com.ucsal.reservation.api.services;

import org.springframework.stereotype.Component;

import br.com.ucsal.reservation.api.inputModels.LoginInputViewModel;
import br.com.ucsal.reservation.api.models.auth.Auth;

@Component
public interface AuthService {
    public Auth login(LoginInputViewModel loginInputViewModel) throws Exception;
}
