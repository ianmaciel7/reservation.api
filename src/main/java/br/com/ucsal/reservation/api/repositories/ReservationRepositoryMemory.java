package br.com.ucsal.reservation.api.repositories;

import org.springframework.stereotype.Repository;

import br.com.ucsal.reservation.api.models.MemoryDbContext;
import br.com.ucsal.reservation.api.models.MemoryList;
import br.com.ucsal.reservation.api.models.persistence.Laboratory;
import br.com.ucsal.reservation.api.models.persistence.Reservation;

@Repository
public class ReservationRepositoryMemory extends BaseRepository implements ReservationRepository {

    private MemoryDbContext context = new MemoryDbContext();

    @Override
    public Reservation add(Reservation reservation) {
        reservation.setId(context.reservations.autoIncrement());
        context.reservations.add(reservation);
        return context.reservations.stream()
                .filter((l) -> l.equals(reservation))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Reservation update(Reservation oldReservation, Reservation newReservation) {
        oldReservation.setWasUsed(newReservation.getWasUsed());
        oldReservation.setEnd(newReservation.getEnd());
        oldReservation.setStart(newReservation.getStart());
        oldReservation.setRequester(newReservation.getRequester());
        oldReservation.setLaboratory(newReservation.getLaboratory());
        return oldReservation;
    }

    @Override
    public void remove(Reservation reservation) {
        context.reservations.remove(reservation);
    }

    @Override
    public Reservation getById(int reservationId) {
        Reservation reservation = context.reservations.stream()
                .filter((l) -> l.getId() == reservationId)
                .findFirst()
                .orElse(null);

        return reservation;
    }

}
