package br.com.ucsal.reservation.api.viewModels;

import java.time.LocalDateTime;

import br.com.ucsal.reservation.api.models.persistence.Reservation;

public class ReservationViewModel {
    private int id;
    private boolean wasUsed;
    private LocalDateTime start;
    private LocalDateTime end;
    private int requesterId;
    private String requesterName;
    private int laboratoryId;
    private String laboratoryName;
    private int laboratoryNumber;
    private char laboratorySector;

    public ReservationViewModel(int id, boolean wasUsed, LocalDateTime start, LocalDateTime end, int requesterId,
            String requesterName, int laboratoryId, String laboratoryName, int laboratoryNumber,
            char laboratorySector) {
        this.id = id;
        this.wasUsed = wasUsed;
        this.start = start;
        this.end = end;
        this.requesterId = requesterId;
        this.requesterName = requesterName;
        this.laboratoryId = laboratoryId;
        this.laboratoryName = laboratoryName;
        this.laboratoryNumber = laboratoryNumber;
        this.laboratorySector = laboratorySector;
    }

    private ReservationViewModel(Reservation reservation) {
        this.id = reservation.getId();
        this.wasUsed = reservation.getWasUsed();
        this.start = reservation.getStart();
        this.end = reservation.getEnd();
        this.requesterId = reservation.getRequester().getId();
        this.requesterName = reservation.getRequester().getName();
        this.laboratoryId = reservation.getLaboratory().getId();
        this.laboratoryName = reservation.getLaboratory().getName();
        this.laboratoryNumber = reservation.getLaboratory().getNumber();
        this.laboratorySector = reservation.getLaboratory().getSector();
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

    public int getLaboratoryId() {
        return this.laboratoryId;
    }

    public void setLaboratoryId(int laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public String getLaboratoryName() {
        return this.laboratoryName;
    }

    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }

    public int getLaboratoryNumber() {
        return this.laboratoryNumber;
    }

    public void setLaboratoryNumber(int laboratoryNumber) {
        this.laboratoryNumber = laboratoryNumber;
    }

    public char getLaboratorySector() {
        return this.laboratorySector;
    }

    public void setLaboratorySector(char laboratorySector) {
        this.laboratorySector = laboratorySector;
    }

    public static ReservationViewModel parser(Reservation reservation) {
        return new ReservationViewModel(reservation);
    }

}
