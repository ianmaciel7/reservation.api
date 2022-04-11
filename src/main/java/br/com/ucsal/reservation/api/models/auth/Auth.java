package br.com.ucsal.reservation.api.models.auth;

import java.util.List;

public class Auth {
    private int id;
    private List<String> type;
    private String hash;

    public Auth(int id, List<String> type, String hash) {
        this.id = id;
        this.type = type;
        this.hash = hash;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getType() {
        return this.type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
