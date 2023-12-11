package Doubly_Circular_List;

import java.util.Scanner;

class Student {
    int id;
    String name;
    String department;
    Student prev;
    Student next;

    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.prev = null;
        this.next = null;
    }
}

class StudentDoublyCircularLinkedList {
    private Student head;

    public StudentDoublyCircularLinkedList() {
        this.head = null;
    }

    public void addStudent(int id, String name, String department) {
        Student newStudent = new Student(id, name, department);
        if (head == null) {
            head = newStudent;
            newStudent.next = head;
            newStudent.prev = head;
        } else {
            Student tail = head.prev;
            tail.next = newStudent;
            newStudent.prev = tail;
            newStudent.next = head;
            head.prev = newStudent;
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
                Student tail = head.prev;
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
            System.out.println("Student with ID " + id + " deleted successfully.");
            return;
        }

        Student current = head.next;
        while (current != head && current.id != id) {
            current = current.next;
        }

        if (current != head) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
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
        System.out.println("All Students (doubly circular):");
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

