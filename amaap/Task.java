package amaap;

import java.sql.Date;

class Task {
    private String description;
    private int taskId;
    private Date dueDate;
    private int priority;
    private boolean isDone;

    public Task(int taskId,String description, Date dueDate, int priority) {
    	this.taskId=taskId;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public boolean isDone() {
        return isDone;
    }
    public int getTaskId() {
		return taskId;
	}

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return  getTaskId()+". --> "+getDescription() + " --> Due date: " + getDueDate() + " --> Priority: " + getPriority() ;
    }
}
