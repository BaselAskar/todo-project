package org.example.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    public static final int ID = 1;
    public static final String FIRST_NAME = "Basel";
    public static final String LAST_NAME = "Askar";
    public static final String EMAIL = "basel@gmail.com";
    public static final AppUser APP_USER = new AppUser("Basel Askar", "123456", AppRole.ROLE_APP_ADMIN);
    private Person testObject;

    @Before
    public void setUp() {
        testObject = new Person(ID, FIRST_NAME, LAST_NAME, EMAIL, APP_USER);
    }

    @Test
    public void test_successfully_instantiated(){
        //test Id
        assertEquals(ID,testObject.getId());
        assertNotEquals(ID,0);

        //test First name
        assertEquals(FIRST_NAME,testObject.getFirstName());
        assertNotNull(testObject.getFirstName());

        //test Last name
        assertEquals(LAST_NAME,testObject.getLastName());
        assertNotNull(testObject.getLastName());

        //test Email
        assertEquals(EMAIL,testObject.getEmail());
        assertNotNull(testObject.getEmail());
    }


    @Test
    public void test_getSummary(){
        String expected = "{id: 1, name: Basel Askar, email: basel@gmail.com}";
        assertEquals(testObject.toString(),expected);
    }

}