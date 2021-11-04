package org.example.Sequencers;

public class TodoItemIdSequencer {
    private static int currentTodoItemId;

    public static int nextTodoItemId(){ return ++currentTodoItemId;}

    public static int getCurrentTodoItemId(){ return currentTodoItemId;};

    public static void setCurrentTodoItemId(int id){ currentTodoItemId = id;}

}
