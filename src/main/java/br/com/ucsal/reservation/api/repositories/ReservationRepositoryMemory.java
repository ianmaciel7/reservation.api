package br.com.ucsal.reservation.api.repositories;

import org.springframework.stereotype.Repository;

import br.com.ucsal.reservation.api.models.persistence.Laboratory;
import br.com.ucsal.reservation.api.models.persistence.MemoryDbContext;
import br.com.ucsal.reservation.api.models.persistence.MemoryList;
import br.com.ucsal.reservation.api.models.persistence.Reservation;

@Repository
public class ReservationRepositoryMemory extends BaseRepository implements ReservationRepository {

    private MemoryDbContext context = new MemoryDbContext();

    @Override
    public Reservation add(Reservation reservation) {
        reservation.setId(context.reservations.autoIncrement());
        reservation.getLaboratory().getReservations().add(reservation);
        context.reservations.add(reservation);
        return context.reservations.stream()
                .filter((l) -> l.equals(reservation))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Reservation update(Reservation oldReservation, Reservation newReservation) {

        oldReservation.getLaboratory().getReservations().remove(oldReservation);
        oldReservation.setWasUsed(newReservation.getWasUsed());
        oldReservation.setEnd(newReservation.getEnd());
        oldReservation.setStart(newReservation.getStart());
        oldReservation.setRequester(newReservation.getRequester());
        oldReservation.setLaboratory(newReservation.getLaboratory());
        oldReservation.getLaboratory().getReservations().add(newReservation);

        return oldReservation;
    }

    @Override
    public void remove(Reservation reservation) {
        reservation.getLaboratory().getReservations().remove(reservation);
        context.reservations.remove(reservation);
    }

    @Override
    public Reservation findById(int reservationId) {
        Reservation reservation = context.reservations.stream()
                .filter((l) -> l.getId() == reservationId)
                .findFirst()
                .orElse(null);

        return reservation;
    }

}
