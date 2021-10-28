package org.example.Model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TodoItemTaskTest {


    public static final int TODO_ITEM_TASK_ID = 2;
    public static final int TODO_ITEM_ID = 2;
    public static final String TITLE = "Change tires";
    public static final String TASK_DESCRIPTION = "it must be quickly";
    public static final LocalDate LOCAL_DATE = LocalDate.parse("2021-10-25");
    public static final boolean DONE = false;
    public static final int PERSON_ID = 2;
    public static final String FIRST_NAME = "Basel";
    public static final String LAST_NAME = "Askar";
    public static final String EMAIL = "basel@gmail.com";
    public static final AppUser USER = new AppUser("Basel Askar","12345",AppRole.ROLE_APP_USER);

    //Constants objects
    public static final Person CREATOR = new Person(PERSON_ID,FIRST_NAME,LAST_NAME,EMAIL,USER);
    public static final TodoItem TODO_ITEM = new TodoItem(TODO_ITEM_ID, TITLE, TASK_DESCRIPTION
            , LOCAL_DATE, DONE, CREATOR);

    //Fields
    private TodoItemTask testObject;


    @Before
    public void setUp() {
        testObject = new TodoItemTask(TODO_ITEM_TASK_ID, TODO_ITEM,CREATOR);
    }

    @Test
    public void test_successfully_instantiated(){
        //test Id
        assertEquals(TODO_ITEM_TASK_ID,testObject.getId());
        assertNotEquals(testObject.getId(),0);

        //test TodoItem
        assertEquals(TODO_ITEM,testObject.getTodoItem());

        //test person
        assertEquals(CREATOR,testObject.getAssignee());

        //test assigned
        assertTrue(testObject.isAssigned());
    }

    @Test
    public void test_getSummary(){

        String expected = "Basel Askar assign Change tires";

        assertEquals(testObject.toString(),expected);
    }

}