package org.example.DAOs;

import org.example.Model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDAOImp implements PersonDAO{

    private List<Person> personsStorage = new ArrayList<>();

    @Override
    public Person persist(Person person) {
        boolean wasSaved = this.personsStorage.add(person);
        if (wasSaved) return person;
        else return null;
    }

    @Override
    public Person findById(int id) {
        for (Person p : this.personsStorage){
            if (p.getId() == id) return p;
        }

        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for (Person p : this.personsStorage){
            if (p.getEmail() == email) return p;
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return this.personsStorage;
    }

    @Override
    public void remove(int id) {
        Person person = findById(id);
        this.personsStorage.remove(person);
    }
}
