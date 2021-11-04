package org.example.Sequencers;

public class TodoItemTaskSequencer {
    private static int currentTodoItemTaskId;

    public static int nextTodoItemTaskId(){ return ++currentTodoItemTaskId;}

    public static int getCurrentTodoItemTaskId(){ return currentTodoItemTaskId;};

    public static void setCurrentTodoItemTaskId(int id){ currentTodoItemTaskId = id;}

}
