package br.com.ucsal.reservation.api.controllers;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @GetMapping("/admin")
    @Secured("ROLE_ADMIN")
    public String admin(Principal principal) {
        return "sucesso" + principal;
    }

    @GetMapping("/user")
    public String user() {
        return "sucesso";
    }
}
