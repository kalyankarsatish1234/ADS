package linear_data_structure;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String department;
    Student next;

    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    public StudentLinkedList() {
        this.head = null;
    }

    public void addStudent(int id, String name, String department) {
        Student newStudent = new Student(id, name, department);
        if (head == null) {
            head = newStudent;
        } else {
            Student current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudent;
        }
        System.out.println("Student added to the list.");
    }

    public void deleteStudentById(int id) {
        if (head == null) {
            System.out.println("Student list is empty.");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Student with ID " + id + " deleted successfully.");
            return;
        }

        Student current = head;
        while (current.next != null && current.next.id != id) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Student with ID " + id + " deleted successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void printAllStudents() {
        if (head == null) {
            System.out.println("Student list is empty.");
            return;
        }

        Student current = head;
        System.out.println("All Students:");
        while (current != null) {
            System.out.println("ID: " + current.id + ", Name: " + current.name + ", Department: " + current.department);
            current = current.next;
        }
    }

    public void findStudentById(int id) {
        if (head == null) {
            System.out.println("Student list is empty.");
            return;
        }

        Student current = head;
        while (current != null) {
            if (current.id == id) {
                System.out.println("Student found:");
                System.out.println("ID: " + current.id + ", Name: " + current.name + ", Department: " + current.department);
                return;
            }
            current = current.next;
        }

        System.out.println("Student with ID " + id + " not found.");
    }
}



