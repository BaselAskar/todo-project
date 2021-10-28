package org.example.Model;

import java.util.UUID;

/*
* @a
*/


public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    public Person(int id, String firstName, String lastName, String email,AppUser credentials) {
        if (id <= 0) throw new RuntimeException();
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setCredentials(credentials);
    }


    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new RuntimeException("first name must not be null");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new RuntimeException("last name must not be null");
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) throw new RuntimeException("email must not be null");
        this.email = email;
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }


    @Override
    public String toString(){
        return "{id: " + getId()
                + ", name: " + getFirstName() + " " + getLastName() +
                ", email: " + getEmail() + "}";
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Person){

            Person person = (Person) obj;

            if (this.getId() == person.getId()
                    && this.getFirstName().equals(person.getFirstName())
                    && this.getLastName().equals(person.getLastName())
                    && this.getEmail().equals(person.getEmail())
            ){
                return true;
            }

        }

        return false;
    }

    @Override
    public int hashCode(){
        int result = this.getId();

        result = 13 * result + this.getFirstName().hashCode();
        result = 13 * result + this.getLastName().hashCode();
        result = 13 * result + this.getEmail().hashCode();

        return result;
    }
}

