package br.com.ucsal.reservation.api.services;

import org.springframework.stereotype.Component;

import br.com.ucsal.reservation.api.viewModels.UserViewModel;

@Component
public interface UserService {
    public UserViewModel add(UserViewModel userViewModel) throws Exception;

    public UserViewModel update(UserViewModel newUserViewModel) throws Exception;

    public void removeById(int userId) throws Exception;

    public UserViewModel getById(int userId) throws Exception;
}
