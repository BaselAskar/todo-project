package org.example.DAOs;

import org.example.App;
import org.example.Model.AppRole;
import org.example.Model.AppUser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class AppUserDAOImplTest {

    private AppUserDAO testObject;

    @Before
    public void setUp() {

        testObject = new AppUserDAOImpl();
    }

    @Test
    public void test_persist() {

        AppUser expected = new AppUser("Basel Askar","123456", AppRole.ROLE_APP_ADMIN);

        AppUser result = testObject.persist(expected);

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void findByUserName() {
        AppUser expected = new AppUser("Maria Johanson","123456", AppRole.ROLE_APP_USER);

        AppUser result = testObject.findByUserName("Maria Johanson");

        assertNotNull(result);
        assertEquals(expected,result);
    }

    @Test
    public void findAll() {
        Collection<AppUser> expected = new ArrayList<>(Arrays.asList(
                new AppUser("Maria Johanson","123456", AppRole.ROLE_APP_USER),
                new AppUser("Mark Andrson","123456",AppRole.ROLE_APP_USER),
                new AppUser("Eman Ali","113546",AppRole.ROLE_APP_USER)
        ));

        Collection<AppUser> result = testObject.findAll();

        assertNotNull(expected);
        assertEquals(expected,result);
    }

    @Test
    public void remove() {
        Collection<AppUser> expected = new ArrayList<>(Arrays.asList(
                new AppUser("Maria Johanson","123456", AppRole.ROLE_APP_USER),
                new AppUser("Mark Andrson","123456",AppRole.ROLE_APP_USER)
        ));

        testObject.remove("Eman Ali");

        Collection<AppUser> result = testObject.findAll();

        assertEquals(expected,result);

    }
}