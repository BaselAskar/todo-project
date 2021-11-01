package org.example.Model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TodoItemTest {

    public static final int ID = 2;
    public static final String TITLE = "Change tires";
    public static final String TASK_DESCRIPTION = "It is necessary to done";
    public static final LocalDate DEAD_LINE = LocalDate.parse("2021-10-25");
    public static final AppUser CREDENTIALS = new AppUser("Basel Askar", "123456", AppRole.ROLE_APP_ADMIN);
    public static final Person CREATOR = new Person(2,"Maria","johanson","maria@gmail.com", CREDENTIALS);
    public static final boolean DONE = true;
    private TodoItem testObject;

    @Before
    public void setUp() {
        testObject = new TodoItem(ID
                , TITLE
                , TASK_DESCRIPTION
                , DEAD_LINE, DONE
                , CREATOR);
    }

    @Test
    public void test_successfully_instantiated(){
        //test Id
        assertEquals(ID,testObject.getId());
        assertNotEquals(testObject.getId(),0);

        //test Title
        assertEquals(TITLE,testObject.getTitle());
        assertNotNull(testObject.getTitle());
        assertNotEquals(testObject.getTitle(),"");

        //test Task description
        assertEquals(TASK_DESCRIPTION,testObject.getTaskDescription());
        assertNotNull(testObject.getTaskDescription());

        //test Deadline
        assertEquals(DEAD_LINE,testObject.getDeadLine());
        assertNotNull(testObject.getDeadLine());

        //test Done
        assertEquals(DONE,testObject.isDone());

        //test Creator
        assertEquals(CREATOR,testObject.getCreator());
    }


    @Test
    public void test_isOverdue() {
        LocalDate now = LocalDate.now();

        testObject.setDeadLine(now.plusDays(1));

        assertFalse(testObject.isOverdue());
    }
}