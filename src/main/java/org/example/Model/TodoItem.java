package org.example.Model;

import java.time.*;

/*
*
* */



public class TodoItem {
    private final int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;



    public TodoItem(int id, String title, String taskDescription, LocalDate deadLine, boolean done, Person creator) {
        if (id == 0) throw new RuntimeException("id must not be 0");
        this.id = id;
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
        setDone(done);
        setCreator(creator);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.equals("")) throw new RuntimeException("Title must not be null or empty");
        this.title = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        LocalDate today = LocalDate.now();
        if (deadLine.isBefore(today)) throw new RuntimeException("deadLine must be after today");
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public boolean isOverdue(){
        LocalDate now = LocalDate.now();

        if (now.isAfter(getDeadLine())) return true;
        else return false;
    }


    @Override
    public boolean equals(Object obj){
        if (obj instanceof TodoItem){

            TodoItem todoItem = (TodoItem) obj;

            if (this.getId() == todoItem.getId()
                    && this.getTitle().equals(todoItem.getTitle())
                    && this.getDeadLine().equals(todoItem.getDeadLine())
                    && this.getCreator().equals(todoItem.getCreator())
                    && this.getTaskDescription().equals(todoItem.getTaskDescription())
                    ){
                return true;
            }

        }

        return false;

    }

    @Override
    public int hashCode(){
        int result = this.getId();

        result = 12 * result + this.getTitle().hashCode();
        result = 13 * result + this.getTaskDescription().hashCode();
        result = 13 * result + this.getDeadLine().hashCode();
        result = 13 * result + this.getCreator().hashCode();

        return result;

    }

}
