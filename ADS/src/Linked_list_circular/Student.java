package Linked_list_circular;

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

class StudentCircularLinkedList {
    private Student head;

    public StudentCircularLinkedList() {
        this.head = null;
    }

    public void addStudent(int id, String name, String department) {
        Student newStudent = new Student(id, name, department);
        if (head == null) {
            head = newStudent;
            newStudent.next = head;  // Circular linking
        } else {
            Student current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newStudent;
            newStudent.next = head;  // Circular linking
        }
        System.out.println("Student added to the list.");
    }

    public void deleteStudentById(int id) {
        if (head == null) {
            System.out.println("Student list is empty.");
            return;
        }

        if (head.id == id) {
            if (head.next == head) {
                head = null;
            } else {
                Student current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = head.next;
                head = head.next;
            }
            System.out.println("Student with ID " + id + " deleted successfully.");
            return;
        }

        Student current = head;
        while (current.next != head && current.next.id != id) {
            current = current.next;
        }

        if (current.next != head) {
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
        System.out.println("All Students (circular):");
        do {
            System.out.println("ID: " + current.id + ", Name: " + current.name + ", Department: " + current.department);
            current = current.next;
        } while (current != head);
    }

    public void findStudentById(int id) {
        if (head == null) {
            System.out.println("Student list is empty.");
            return;
        }

        Student current = head;
        do {
            if (current.id == id) {
                System.out.println("Student found:");
                System.out.println("ID: " + current.id + ", Name: " + current.name + ", Department: " + current.department);
                return;
            }
            current = current.next;
        } while (current != head);

        System.out.println("Student with ID " + id + " not found.");
    }
}


