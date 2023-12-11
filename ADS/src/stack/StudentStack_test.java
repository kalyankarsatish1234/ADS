package stack;

import java.util.Scanner;

public class StudentStack_test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentStack studentStack = new StudentStack();

        while (true) {
            System.out.println("\n1. Push a student");
            System.out.println("2. Pop a student");
            System.out.println("3. Peek at the top student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
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
                    studentStack.push(new Student(id, name, department));
                    break;

                case 2:
                    Student poppedStudent = studentStack.pop();
                    if (poppedStudent != null) {
                        System.out.println("Popped student: ID - " + poppedStudent.id + ", Name - " + poppedStudent.name + ", Department - " + poppedStudent.department);
                    }
                    break;

                case 3:
                    Student peekedStudent = studentStack.peek();
                    if (peekedStudent != null) {
                        System.out.println("Peeked student: ID - " + peekedStudent.id + ", Name - " + peekedStudent.name + ", Department - " + peekedStudent.department);
                    }
                    break;

                case 4:
                    studentStack.display();
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}

