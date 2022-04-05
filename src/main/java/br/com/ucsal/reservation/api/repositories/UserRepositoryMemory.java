package br.com.ucsal.reservation.api.repositories;

import org.springframework.stereotype.Repository;

import br.com.ucsal.reservation.api.models.MemoryDbContext;
import br.com.ucsal.reservation.api.models.auth.Role;
import br.com.ucsal.reservation.api.models.persistence.User;

@Repository
public class UserRepositoryMemory extends BaseRepository implements UserRepository {

    private MemoryDbContext context = new MemoryDbContext();

    public UserRepositoryMemory() {
        context.users.add(new User(context.users.autoIncrement(), "user", "user", "123", Role.USER));
        context.users.add(new User(context.users.autoIncrement(), "admin", "admin", "123", Role.ADMIN));
        context.users.add(
                new User(context.users.autoIncrement(), "userAdmin", "userAdmin", "123", Role.USER + "," + Role.ADMIN));
    }

    @Override
    public User add(User user) {
        user.setId(context.reservations.autoIncrement());
        context.users.add(user);
        return context.users.stream()
                .filter((l) -> l.equals(user))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User update(User oldUser, User newUser) {
        oldUser.setName(newUser.getName());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setPermissions(newUser.getPermissions());
        oldUser.setUserName(newUser.getUserName());
        return oldUser;
    }

    @Override
    public void remove(User user) {
        context.users.remove(user);

    }

    @Override
    public User getById(int userId) {
        User user = context.users.stream()
                .filter((l) -> l.getId() == userId)
                .findFirst()
                .orElse(null);

        return user;
    }

}
