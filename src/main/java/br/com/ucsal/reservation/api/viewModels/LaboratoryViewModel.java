package br.com.ucsal.reservation.api.viewModels;

import java.util.List;

import br.com.ucsal.reservation.api.models.persistence.Laboratory;
import br.com.ucsal.reservation.api.models.persistence.Reservation;

public class LaboratoryViewModel {
    private int id;
    private String name;
    private int number;
    private char sector;
    private List<ReservationForLaboratoryViewModel> reservations;

    public LaboratoryViewModel(int id, String name, int number, char sector, List<ReservationForLaboratoryViewModel> reservations) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.sector = sector;
        this.reservations = reservations;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public char getSector() {
        return this.sector;
    }

    public void setSector(char sector) {
        this.sector = sector;
    }

    public boolean isIdle() {
        return this.reservations.isEmpty();
    }

    public List<ReservationForLaboratoryViewModel> getReservations() {
        return this.reservations;
    }

    public void setReservations(List<ReservationForLaboratoryViewModel> reservations) {
        this.reservations = reservations;
    }

    public static LaboratoryViewModel parser(Laboratory lab) {

        List<ReservationForLaboratoryViewModel> reservations = lab.getReservations()
                .stream()
                .map(x -> ReservationForLaboratoryViewModel.parser(x))
                .toList();

        return new LaboratoryViewModel(
                lab.getId(),
                lab.getName(),
                lab.getNumber(),
                lab.getSector(),
                reservations);
    }

}
