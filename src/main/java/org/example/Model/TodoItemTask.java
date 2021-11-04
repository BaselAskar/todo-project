package org.example.Model;

import org.example.Sequencers.TodoItemTaskSequencer;

import java.util.Objects;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(int id,  TodoItem todoItem,boolean assigned, Person assignee) {
        if (id <= 0) throw new RuntimeException("id must not be 0");
        this.id = id;
        setAssignee(assignee);
        setTodoItem(todoItem);
        setAssigned(assigned);
    }

    public TodoItemTask(boolean assigned, TodoItem todoItem, Person assignee) {
        TodoItemTaskSequencer.nextTodoItemTaskId();
        this.assigned = assigned;
        this.todoItem = todoItem;
        this.assignee = assignee;
    }

    public int getId() {
        return this.id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;

    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {

        this.assignee = assignee;
    }

    @Override
    public String toString(){
        if (isAssigned()){
            return assignee.getFirstName() + " " + assignee.getLastName()
                    + " assign " + todoItem.getTitle();
        }else {
          return todoItem.getTitle() + "are not assigned";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemTask that = (TodoItemTask) o;
        return id == that.id && assigned == that.assigned && todoItem.equals(that.todoItem) && Objects.equals(assignee, that.assignee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, todoItem, assignee);
    }
}
