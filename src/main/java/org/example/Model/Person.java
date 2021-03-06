package org.example.Model;

import org.example.Sequencers.PersonIdSequencer;

import java.util.Objects;
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

    public Person(String firstName, String lastName, String email, AppUser credentials) {
        PersonIdSequencer.nextPersonId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.credentials = credentials;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && firstName.equals(person.firstName) && lastName.equals(person.lastName) && email.equals(person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}

