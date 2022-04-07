package br.com.ucsal.reservation.api.models.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthConfig {
    public static final PasswordEncoder appPasswordEncoder = new BCryptPasswordEncoder();
}
