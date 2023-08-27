import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Display All Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter due date (yyyy-MM-dd): ");
                    String dueDateStr = scanner.nextLine();
                    LocalDate dueDate = LocalDate.parse(dueDateStr);
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter priority: ");
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    taskList.addTask(new Task(title, dueDate, category, priority));
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    System.out.print("Enter the index of the task to mark as completed: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    taskList.markTaskAsCompleted(index - 1);
                    System.out.println("Task marked as completed!");
                    break;
                case 3:
                    List<Task> allTasks = taskList.getAllTasks();
                    for (int i = 0; i < allTasks.size(); i++) {
                        System.out.println("Task " + (i + 1) + ": " + allTasks.get(i));
                    }
                    break;
                case 4:
                    System.out.println("Thank You!!!.....");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
	}
}
