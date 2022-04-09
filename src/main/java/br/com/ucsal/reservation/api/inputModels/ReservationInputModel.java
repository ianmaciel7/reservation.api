package br.com.ucsal.reservation.api.inputModels;

import java.time.LocalDateTime;

public class ReservationInputModel {
    private int id;
    private boolean wasUsed;
    private LocalDateTime start;
    private LocalDateTime end;
    private int requesterId;
    private int laboratoryId;

    public ReservationInputModel(int id, LocalDateTime start, LocalDateTime end, int requesterId,
            int laboratoryId) {
        this.id = id;
        this.wasUsed = false;
        this.start = start;
        this.end = end;
        this.requesterId = requesterId;
        this.laboratoryId = laboratoryId;
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

    public int getRequesterId() {
        return this.requesterId;
    }

    public void setRequesterId(int requesterId) {
        this.requesterId = requesterId;
    }

    public int getLaboratoryId() {
        return this.laboratoryId;
    }

    public void setLaboratoryId(int laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

}
