package org.example;

import org.example.Model.AppRole;
import org.example.Model.AppUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * Todo project
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AppUser user = new AppUser("Basel","12364", AppRole.ROLE_APP_ADMIN);

        System.out.println(user);


    }
}
