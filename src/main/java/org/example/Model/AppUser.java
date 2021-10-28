package org.example.Model;

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
        if (userName == null ||userName == "") throw new RuntimeException("It's not allowed to be user name null or empty");
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null ||password == "") throw new RuntimeException("It's not allowed to be password null or empty");

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
    public boolean equals(Object user){

        if (user instanceof AppUser){

            AppUser appUser = (AppUser) user;

            if (this.getUserName() == appUser.getUserName()
                    && this.getRole() == appUser.getRole()) return true;

        }

        return false;
    }

    @Override
    public int hashCode(){

        int result = 21;

        result = 15 * getUserName().hashCode();
        result = 15 * getRole().hashCode();

        return result;
    }


    @Override
    public String toString(){
        return "{User name: " + getUserName()
                + ",Roles: " + getRole().getValue() + "}";
    }
}
