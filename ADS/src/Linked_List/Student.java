package Linked_List;

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

class StudentDoublyLinkedList {
    private Student head;
    private Student tail;

    public StudentDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addStudent(int id, String name, String department) {
        Student newStudent = new Student(id, name, department);
        if (head == null) {
            head = newStudent;
            tail = newStudent;
        } else {
            tail.next = newStudent;
            newStudent.prev = tail;
            tail = newStudent;
        }
        System.out.println("Student added to the list.");
    }

    public void deleteStudentById(int id) {
        if (head == null) {
            System.out.println("Student list is empty.");
            return;
        }

        Student current = head;
        while (current != null && current.id != id) {
            current = current.next;
        }

        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }

            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }

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
        System.out.println("All Students (from head to tail):");
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



