package Circular_Queue;

import java.util.Scanner;

public class StudentCircularQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularStudentQueue CircularStudentQueue = new CircularStudentQueue();

        while (true) {
            System.out.println("\n1. Enqueue a student");
            System.out.println("2. Dequeue a student");
            System.out.println("3. Display the circular queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student department: ");
                    String department = scanner.nextLine();
                    CircularStudentQueue.enqueue(new Student(id, name, department));
                    break;

                case 2:
                    Student dequeuedStudent = CircularStudentQueue.dequeue();
                    if (dequeuedStudent != null) {
                        System.out.println("Dequeued student: ID - " + dequeuedStudent.id + ", Name - " + dequeuedStudent.name + ", Department - " + dequeuedStudent.department);
                    }
                    break;

                case 3:
                	CircularStudentQueue.displayQueue();
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}


