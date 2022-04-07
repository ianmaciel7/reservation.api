package br.com.ucsal.reservation.api.repositories;

import br.com.ucsal.reservation.api.models.persistence.Reservation;

public interface ReservationRepository {
    public Reservation add(Reservation reservation);

    public Reservation update(Reservation oldReservation, Reservation newReservation);

    public void remove(Reservation reservation);

    public Reservation findById(int reservationId);
}
