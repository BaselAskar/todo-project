package org.example.DAOs;

import org.example.Model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO {

    TodoItem persist(TodoItem todoItem);
    TodoItem findById(int id);
    Collection<TodoItem> findAll();
    Collection<TodoItem> findAllDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int personId);
    Collection<TodoItem> findByDeadLineBefore(LocalDate date);
    Collection<TodoItem> findByDeadLineAfter(LocalDate date);
    void remove(int id);
}
