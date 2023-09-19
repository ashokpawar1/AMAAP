package amaap;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class TaskManager {
    private ArrayList<Task> tasks;
    static int flag=0;
    private int nextTaskId;

    public TaskManager() {
        tasks = new ArrayList<>();
        nextTaskId=1;
    }

    public void addTask(String description, Date dueDate, int priority) {
    	int taskId = nextTaskId++;
        tasks.add(new Task(taskId,description, dueDate, priority));
    }

    public void listTasks(int choice) {
    	if(tasks.size()==0)
    	{
    		System.out.println("you dont have any pending tasks");
    		return;
    	}
        System.out.println("Your Tasks:");
        switch (choice) {
            case 1:
            	PriorityComparator priorityComparator=new PriorityComparator(tasks);
            	Collections.sort(tasks,priorityComparator);
                break;
            case 2:
            	DateComparator dateComparator=new DateComparator(tasks);
            	Collections.sort(tasks,dateComparator);
                break;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void markTaskAsDone(int taskId) {
    	boolean taskFound = false;
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                task.markAsDone();
//                System.out.println("Removed completed task --> " + task.getDescription());
                taskFound = true;
                break;
            }
        }
        if (!taskFound) {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    public void removeCompletedTasks() {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.isDone()) {
                iterator.remove();
                System.out.println("Removed completed tasks.");
            }
        }   
    }

    public void Reminder() {
        LocalDate currentDate = LocalDate.now();
        LocalDate oneDayAhead = currentDate.plusDays(1);

        for (Task task : tasks) {
            LocalDate dueDate = task.getDueDate().toLocalDate();
            if (dueDate.equals(oneDayAhead)) {
                System.out.println("You need to complte your task : '" + task.getDescription()+"' upto to tommarow");
            }
            else if (dueDate.equals(currentDate)) {
            	System.out.println("You need to complte your task : '" + task.getDescription()+"' Today only");
			}
        }
    }
    
    public void removeOverdueTasks() {
        LocalDate currentDate = LocalDate.now();
        Iterator<Task> iterator = tasks.iterator();

        while (iterator.hasNext()) {
            Task task = iterator.next();
            LocalDate dueDate = task.getDueDate().toLocalDate();

            if (dueDate.isBefore(currentDate)) {
                System.out.println("Removed overdue task: " + task.getDescription());
                iterator.remove();
                flag=1;
            }
        }
    }
}
