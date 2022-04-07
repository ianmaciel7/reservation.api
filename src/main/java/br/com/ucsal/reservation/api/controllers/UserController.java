package br.com.ucsal.reservation.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.ucsal.reservation.api.models.auth.Role;
import br.com.ucsal.reservation.api.services.UserService;
import br.com.ucsal.reservation.api.viewModels.UserViewModel;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Secured({ Role.ADMIN, Role.USER })
    @GetMapping("/find/{userId}")
    public ResponseEntity<UserViewModel> findById(@PathVariable("userId") int userId) {
        try {
            UserViewModel userViewModel = userService.findById(userId);
            return new ResponseEntity<UserViewModel>(userViewModel, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Secured({ Role.ADMIN, Role.USER })
    @PostMapping("/add")
    public ResponseEntity<UserViewModel> add(@RequestBody UserViewModel newUser) {
        try {
            UserViewModel userViewModel = userService.add(newUser);
            return new ResponseEntity<UserViewModel>(userViewModel, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Secured({ Role.ADMIN, Role.USER })
    @PutMapping("/update")
    public ResponseEntity<UserViewModel> update(@RequestBody UserViewModel newUserViewModel) {
        try {
            UserViewModel userViewModel = userService.update(newUserViewModel);
            return new ResponseEntity<UserViewModel>(userViewModel, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Secured(Role.ADMIN)
    @DeleteMapping("/remove/{userId}")
    public ResponseEntity<Void> removeById(@PathVariable("userId") int userId) {
        try {
            userService.removeById(userId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
