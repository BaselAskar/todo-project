package org.example.Model;

public enum AppRole {
    ROLE_APP_USER("User"),
    ROLE_APP_ADMIN("Admin");

    private final String value;

    AppRole(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
