package br.com.ucsal.reservation.api.repositories;

import br.com.ucsal.reservation.api.models.persistence.User;

public interface UserRepository {
    public User add(User user);

    public User update(User oldUser, User newUser);

    public void remove(User user);

    public User getById(int userId);
}
