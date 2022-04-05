package br.com.ucsal.reservation.api.models.persistence;

import br.com.ucsal.reservation.api.viewModels.UserViewModel;

public class User {
    private int id;
    private String name;
    private String userName;
    private String password;
    private String permissions;

    public User(int id, String name, String userName, String password, String permissions) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.permissions = permissions;
    }

    private User(UserViewModel userViewModel) {
        this.id = userViewModel.getId();
        this.name = userViewModel.getName();
        this.password = userViewModel.getPassword();
        this.permissions = userViewModel.getPermissions();
        this.userName = userViewModel.getUserName();
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

    public String getPermissions() {
        return this.permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public static User parser(UserViewModel userViewModel) {
        return new User(userViewModel);
    }

}
