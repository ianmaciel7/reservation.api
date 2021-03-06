package br.com.ucsal.reservation.api.inputModels;

public class LaboratoryPatchInputModel {
    private int id;
    private String name;
    private int number;
    private char sector;

    public LaboratoryPatchInputModel(int id, String name, int number, char sector) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.sector = sector;
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
}
