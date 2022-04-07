package br.com.ucsal.reservation.api.services;

import org.springframework.stereotype.Component;

import br.com.ucsal.reservation.api.models.persistence.User;
import br.com.ucsal.reservation.api.viewModels.UserViewModel;

@Component
public interface UserService {
    public UserViewModel add(UserViewModel userViewModel) throws Exception;

    public UserViewModel update(UserViewModel newUserViewModel) throws Exception;

    public void removeById(int userId) throws Exception;

    public UserViewModel findById(int userId) throws Exception;

    public UserViewModel findByUsername(String username) throws Exception;
}
