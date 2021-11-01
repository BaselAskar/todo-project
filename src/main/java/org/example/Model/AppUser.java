package org.example.Model;

import java.util.Objects;

public class AppUser {
    private String userName;
    private String password;
    private AppRole role;

    public AppUser(String userName, String password,AppRole role) {
        setUserName(userName);
        setPassword(password);
        setRole(role);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName == null ||userName.equals("")) throw new RuntimeException("It's not allowed to be user name null or empty");
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null ||password.equals("")) throw new RuntimeException("It's not allowed to be password null or empty");

        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        if (role == null)  throw new RuntimeException("It's not allowed to be role null");
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return userName.equals(appUser.userName) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, role);
    }

    @Override
    public String toString(){
        return "{User name: " + this.getUserName()
                + ",Roles: " + this.getRole().getValue() + "}";
    }
}
