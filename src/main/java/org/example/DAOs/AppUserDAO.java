package org.example.DAOs;

import org.example.Model.AppUser;

import java.util.Collection;

public interface AppUserDAO {

    AppUser persist(AppUser appUser);
    AppUser findByUserName(String userName);
    Collection<AppUser> findAll();
    void remove(String userName);
}
