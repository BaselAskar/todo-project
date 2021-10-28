package org.example.Model;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(int id,  TodoItem todoItem, Person assignee) {
        if (id == 0) throw new RuntimeException("id must not be 0");
        this.id = id;
        setAssignee(assignee);
        setTodoItem(todoItem);
        setAssigned();
    }

    public int getId() {
        return this.id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned() {
        this.assigned = getAssignee() != null;

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
    public boolean equals(Object obj){
        if (obj instanceof TodoItemTask){

            TodoItemTask todoItemTask = (TodoItemTask) obj;

            if (this.getId() == todoItemTask.getId()
                    && this.getTodoItem().equals(todoItemTask.getTodoItem())
                    && this.getAssignee().equals(todoItemTask.getAssignee())
                    && this.isAssigned() == todoItemTask.isAssigned()
            ){
                return true;
            }

        }

        return false;

    }

    @Override
    public int hashCode(){
        int result = this.getId();

        result = 11 * result + this.getTodoItem().hashCode();
        result = 11 * result + this.getAssignee().hashCode();



        return result;

    }


}
