package br.com.ucsal.reservation.api.viewModels;

import java.time.LocalDateTime;

import br.com.ucsal.reservation.api.models.persistence.Reservation;

public class ReservationForLaboratoryViewModel {
    private int id;
    private boolean wasUsed;
    private LocalDateTime start;
    private LocalDateTime end;
    private int requesterId;
    private String requesterName;

    public ReservationForLaboratoryViewModel(int id, boolean wasUsed, LocalDateTime start, LocalDateTime end,
            int requesterId, String requesterName) {
        this.id = id;
        this.wasUsed = wasUsed;
        this.start = start;
        this.end = end;
        this.requesterId = requesterId;
        this.requesterName = requesterName;
    }

    private ReservationForLaboratoryViewModel(Reservation reservation) {
        this.id = reservation.getId();
        this.wasUsed = reservation.getWasUsed();
        this.start = reservation.getStart();
        this.end = reservation.getEnd();
        this.requesterId = reservation.getRequester().getId();
        this.requesterName = reservation.getRequester().getName();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean wasUsed() {
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

    public int getRequesterId() {
        return this.requesterId;
    }

    public void setRequesterId(int requesterId) {
        this.requesterId = requesterId;
    }

    public String getRequesterName() {
        return this.requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public static ReservationForLaboratoryViewModel parser(Reservation reservation) {
        return new ReservationForLaboratoryViewModel(reservation);
    }
}
