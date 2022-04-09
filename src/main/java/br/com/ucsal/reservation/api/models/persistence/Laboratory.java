package br.com.ucsal.reservation.api.models.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.reservation.api.inputModels.LaboratoryPatchInputModel;
import br.com.ucsal.reservation.api.viewModels.LaboratoryViewModel;

public class Laboratory {

    private int id;
    private String name;
    private int number;
    private char sector;
    private List<Reservation> reservations;

    public Laboratory(int id, String name, int number, char sector) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.sector = sector;
        this.reservations = new ArrayList<Reservation>();
    }

    public Laboratory(int id, String name, int number, char sector, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.sector = sector;
        this.reservations = reservations;
    }

    public Laboratory(LaboratoryPatchInputModel lab) {
        this.id = lab.getId();
        this.name = lab.getName();
        this.number = lab.getNumber();
        this.sector = lab.getSector();
        this.reservations = null;
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

    public List<Reservation> getReservations() {
        return this.reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public static Laboratory parser(LaboratoryViewModel lab) {

        return new Laboratory(
                lab.getId(),
                lab.getName(),
                lab.getNumber(),
                lab.getSector(),
                new ArrayList<Reservation>());
    }

    public static Laboratory parser(LaboratoryPatchInputModel newLaboratoryPatchInputModel) {
        return new Laboratory(newLaboratoryPatchInputModel);
    }

}
