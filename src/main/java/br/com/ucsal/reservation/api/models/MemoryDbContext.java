package br.com.ucsal.reservation.api.models;

import br.com.ucsal.reservation.api.models.persistence.Laboratory;
import br.com.ucsal.reservation.api.models.persistence.Reservation;
import br.com.ucsal.reservation.api.models.persistence.User;

public class MemoryDbContext {
    public static MemoryList<Laboratory> laboratories = new MemoryList<Laboratory>();
    public static MemoryList<Reservation> reservations = new MemoryList<Reservation>();
    public static MemoryList<User> users = new MemoryList<User>();
}
