package br.com.ucsal.reservation.api.models.persistence;

import java.time.LocalDateTime;
import java.util.Date;

import br.com.ucsal.reservation.api.inputModels.ReservationInputModel;
import br.com.ucsal.reservation.api.viewModels.ReservationViewModel;

public class Reservation {
    private int id;
    private boolean wasUsed;
    private LocalDateTime start;
    private LocalDateTime end;
    private int requesterId;
    private User requester;
    private int laboratoryId;
    private Laboratory laboratory;

    private Reservation(int id, boolean wasUsed, LocalDateTime start, LocalDateTime end, User requester,
            Laboratory laboratory) {
        this.id = id;
        this.wasUsed = wasUsed;
        this.start = start;
        this.end = end;
        this.requester = requester;
        this.laboratory = laboratory;
    }

    private Reservation(ReservationViewModel reservationViewModel, Laboratory laboratory, User requester) {
        this.id = reservationViewModel.getId();
        this.wasUsed = reservationViewModel.getWasUsed();
        this.start = reservationViewModel.getStart();
        this.end = reservationViewModel.getEnd();
        this.requester = requester;
        this.laboratory = laboratory;
    }

    private Reservation(ReservationInputModel reservationInputModel, Laboratory laboratory, User requester) {
        this.id = reservationInputModel.getId();
        this.wasUsed = reservationInputModel.getWasUsed();
        this.start = reservationInputModel.getStart();
        this.end = reservationInputModel.getEnd();
        this.requester = requester;
        this.laboratory = laboratory;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWasUsed() {
        return this.wasUsed;
    }

    public boolean getWasUsed() {
        return this.wasUsed;
    }

    public void setWasUsed(boolean wasUsed) {
        this.wasUsed = wasUsed;
    }

    public LocalDateTime getStart() {
        return this.start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return this.end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public User getRequester() {
        return this.requester;
    }

    public void setRequester(User requester) {
        this.requesterId = requester.getId();
        this.requester = requester;
    }

    public Laboratory getLaboratory() {
        return this.laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratoryId = laboratory.getId();
        this.laboratory = laboratory;
    }

    public static Reservation parser(ReservationViewModel reservationViewModel, Laboratory laboratory,
            User requester) {
        return new Reservation(reservationViewModel, laboratory, requester);
    }

    public static Reservation parser(ReservationInputModel reservationInputModel, Laboratory laboratory,
            User requester) {
        return new Reservation(reservationInputModel, laboratory, requester);
    }
}
