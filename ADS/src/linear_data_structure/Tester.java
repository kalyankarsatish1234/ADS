package linear_data_structure;
import java.util.Scanner;


public class Tester {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentLinkedList studentList = new StudentLinkedList();

        while (true) {
            System.out.println("\n1. Add a student");
            System.out.println("2. Delete a student by ID");
            System.out.println("3. Print all students");
            System.out.println("4. Find a student by ID");
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
                    studentList.addStudent(id, name, department);
                    break;

                case 2:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    studentList.deleteStudentById(deleteId);
                    break;

                case 3:
                    studentList.printAllStudents();
                    break;

                case 4:
                    System.out.print("Enter student ID to find: ");
                    int findId = scanner.nextInt();
                    studentList.findStudentById(findId);
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


