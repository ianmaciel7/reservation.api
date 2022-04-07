package br.com.ucsal.reservation.api.models;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.ucsal.reservation.api.models.auth.Role;
import br.com.ucsal.reservation.api.models.persistence.Laboratory;
import br.com.ucsal.reservation.api.models.persistence.Reservation;
import br.com.ucsal.reservation.api.models.persistence.User;

public class MemoryDbContext {
    public static MemoryList<Laboratory> laboratories = new MemoryList<Laboratory>();
    public static MemoryList<Reservation> reservations = new MemoryList<Reservation>();
    public static MemoryList<User> users = new MemoryList<User>();

    static {
        users.add(new User(users.autoIncrement(), "user", "user", "123", getArrayList(Role.USER)));
        users.add(new User(users.autoIncrement(), "admin", "admin", "123", getArrayList(Role.ADMIN)));
        users.add(new User(users.autoIncrement(), "userAdmin", "userAdmin", "123", getArrayList(Role.ADMIN, Role.USER)));

        laboratories.add(new Laboratory(laboratories.autoIncrement(), "Teste 1", 400, 'c'));
        laboratories.add(new Laboratory(laboratories.autoIncrement(), "Teste 2", 500, 'c'));
        laboratories.add(new Laboratory(laboratories.autoIncrement(), "Teste 3", 600, 'c'));
    }

    private static ArrayList<String> getArrayList(String... a) {
        return new ArrayList<String>(Arrays.asList(a));
    }
}
