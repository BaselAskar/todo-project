package org.example.DAOs;

import org.example.Model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemImp implements TodoItemDAO{

    List<TodoItem> todoItemStorage = new ArrayList<>();


    @Override
    public TodoItem persist(TodoItem todoItem) {
        boolean wasSaved = this.todoItemStorage.add(todoItem);
        if (wasSaved) return todoItem;
        return null;
    }

    @Override
    public TodoItem findById(int id) {
        for (TodoItem todoItem : this.todoItemStorage){
            if (todoItem.getId() == id) return todoItem;
        }

        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return this.todoItemStorage;
    }

    @Override
    public Collection<TodoItem> findAllDoneStatus(boolean done) {
        List<TodoItem> todoItemDoneList = new ArrayList<>();

        for (TodoItem todoItem : this.todoItemStorage){
            if (todoItem.isDone()) todoItemDoneList.add(todoItem);
        }

        return todoItemDoneList;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        List<TodoItem> todoItemList = new ArrayList<>();

        for (TodoItem todoItem : this.todoItemStorage){
            if (todoItem.getTitle() == title) todoItemList.add(todoItem);
        }

        return todoItemList;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        List<TodoItem> todoItemList = new ArrayList<>();

        for (TodoItem todoItem : this.todoItemStorage){
            if(todoItem.getCreator().getId() == personId) todoItemList.add(todoItem);
        }

        return todoItemList;
    }

    @Override
    public Collection<TodoItem> findByDeadLineBefore(LocalDate date) {
        List<TodoItem> todoItemList = new ArrayList<>();

        for (TodoItem todoItem : this.todoItemStorage){
            if (todoItem.getDeadLine().isBefore(date)) todoItemList.add(todoItem);
        }

        return todoItemList;
    }

    @Override
    public Collection<TodoItem> findByDeadLineAfter(LocalDate date) {
        List<TodoItem> todoItemList = new ArrayList<>();

        for (TodoItem todoItem : this.todoItemStorage){
            if (todoItem.getDeadLine().isAfter(date)) todoItemList.add(todoItem);
        }

        return todoItemList;

    }

    @Override
    public void remove(int id) {
        this.todoItemStorage.remove(findById(id));
    }
}
