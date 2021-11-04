package org.example.DAOs;

import org.example.Model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemTaskImp implements TodoItemTaskDAO {

    private List<TodoItemTask> todoItemTaskStorage;

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        boolean wasSaved = this.todoItemTaskStorage.add(todoItemTask);

        if (wasSaved) return todoItemTask;

        return null;
    }

    @Override
    public TodoItemTask findById(int id) {

        for (TodoItemTask todoItemTask: this.todoItemTaskStorage) {

            if (todoItemTask.getId() == id) return todoItemTask;
        }

        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return this.todoItemTaskStorage;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        List<TodoItemTask> todoItemTasksList = new ArrayList<>();

        for (TodoItemTask todoItemTask : this.todoItemTaskStorage){
            if (todoItemTask.isAssigned() == status) todoItemTasksList.add(todoItemTask);
        }

        return todoItemTasksList;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        List<TodoItemTask> todoItemTaskList = new ArrayList<>();

        for (TodoItemTask todoItemTask : this.todoItemTaskStorage){
            if (todoItemTask.getAssignee().getId() == personId) todoItemTaskList.add(todoItemTask);
        }

        return todoItemTaskList;
    }

    @Override
    public void remove(int id) {
        this.todoItemTaskStorage.remove(findById(id));
    }
}
