package br.com.ucsal.reservation.api.services;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ucsal.reservation.api.inputModels.LoginInputViewModel;
import br.com.ucsal.reservation.api.models.auth.Auth;
import br.com.ucsal.reservation.api.viewModels.UserViewModel;
import static br.com.ucsal.reservation.api.models.auth.AuthConfig.*;

@Service
public class AuthBasicService implements AuthService {

    @Autowired
    private UserService userService;

    @Override
    public Auth login(LoginInputViewModel loginInputViewModel) throws Exception {

        UserViewModel userViewModel = this.tryFindUserByUserName(loginInputViewModel.getUsername());

        boolean isEqual = appPasswordEncoder.matches(loginInputViewModel.getPassword(),
                userViewModel.getPassword());

        if (!isEqual)
            throw new Exception("login inválido");

        String str = loginInputViewModel.getUsername() + ":" + loginInputViewModel.getPassword();
        String hash = String.valueOf(Base64.getEncoder().encodeToString(str.getBytes("UTF-8")));
        return new Auth(userViewModel.getId(), userViewModel.getPermissions(), hash);
    }

    private UserViewModel tryFindUserByUserName(String username) {
        try {
            return userService.findByUsername(username);
        } catch (Exception e) {
            throw new NullPointerException("login inválido");
        }
    }

}
