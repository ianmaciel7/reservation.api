package br.com.ucsal.reservation.api.viewModels;

import java.util.List;

import br.com.ucsal.reservation.api.models.persistence.User;

public class UserViewModel {
    private int id;
    private String name;
    private String userName;
    private String password;
    private List<String> permissions;

    private UserViewModel(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.permissions = user.getPermissions();
        this.userName = user.getUserName();
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

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public static UserViewModel parser(User user) {
        return new UserViewModel(user);
    }
}
