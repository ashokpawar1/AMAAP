package amaap;

import java.sql.Date;
import java.util.Scanner;


public class ToDoList {
	public static void main(String[] args) {
    	TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to task manager");
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Remove over due Tasks");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter task description: ");
                    scanner.nextLine();
                    String description = scanner.nextLine();
                    System.out.println("Enter due date for task [yyyy-MM-dd]: ");
                    String dueDateStr = scanner.nextLine();
                    Date dueDate = Date.valueOf(dueDateStr);
                    System.out.println("Enter priority 1.low   2.medium   3.high ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    taskManager.addTask(description, dueDate, priority);
                    taskManager.Reminder();
                    taskManager.removeOverdueTasks();
                    if (TaskManager.flag==0) {
                    	System.out.println("task submited successfully");
					}
                    break;
                case 2:
                	taskManager.removeOverdueTasks();
                    System.out.println("Sort tasks by \n1.priority\n2.due date");
                    int choice1 =scanner.nextInt();
                    taskManager.listTasks(choice1);
                    taskManager.Reminder();
                    break;
                case 3:
                    System.out.println("Enter task id to mark as done: ");
                    int taskIndex = scanner.nextInt();
                    scanner.nextLine();
                    taskManager.markTaskAsDone(taskIndex);
                    taskManager.removeCompletedTasks();
                    break;
                case 4:
                    taskManager.removeOverdueTasks();
                    break;
                case 5:
                    System.out.println("thank you for visiting!!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter valid choice");
            }
        }
    }
}
