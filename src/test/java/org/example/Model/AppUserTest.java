package org.example.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppUserTest {

    public static final String USER_NAME = "Basel Askar";
    public static final String PASSWORD = "123456";
    public static final AppRole ROLE = AppRole.ROLE_APP_ADMIN;
    private AppUser testObject;

    @Before
    public void setUp() {
        testObject = new AppUser(USER_NAME, PASSWORD, ROLE);
    }

    @Test
    public void test_instantiated_AppUser(){
        //test username
        assertNotEquals("",testObject.getUserName());
        assertNotNull(testObject.getUserName());

        //test password
        assertNotEquals("",testObject.getPassword());
        assertNotNull(testObject.getPassword());

        //test Role
        assertEquals(AppRole.ROLE_APP_ADMIN,testObject.getRole());
    }

    @Test
    public void test_toString(){
        String expected = "{User name: Basel Askar,Roles: Admin}";

        assertEquals(expected,testObject.toString());
    }
}