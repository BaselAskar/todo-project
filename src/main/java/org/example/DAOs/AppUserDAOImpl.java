package org.example.DAOs;

import org.example.App;
import org.example.Model.AppRole;
import org.example.Model.AppUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AppUserDAOImpl implements AppUserDAO  {

    private List<AppUser> appUsersStorage = new ArrayList<>(Arrays.asList(
            new AppUser("Maria Johanson","123456", AppRole.ROLE_APP_USER),
            new AppUser("Mark Andrson","123456",AppRole.ROLE_APP_USER),
            new AppUser("Eman Ali","113546",AppRole.ROLE_APP_USER)
    ));



    @Override
    public AppUser persist(AppUser appUser) {
        boolean wasSaved = this.appUsersStorage.add(appUser);
        if (wasSaved) return appUser;
        else return null;
    }

    @Override
    public AppUser findByUserName(String userName) {
        for (AppUser au : this.appUsersStorage){
            if (au.getUserName() == userName) return au;
        }
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return this.appUsersStorage;
    }

    @Override
    public void remove(String userName) {
        AppUser appUser = findByUserName(userName);
        this.appUsersStorage.remove(appUser);
    }
}
