package stack;

import java.util.Scanner;

class Student {
    int id;
    String name;
    String department;

    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}

class StudentStack {
    private static final int MAX_SIZE = 100;
    private Student[] stackArray;
    private int top;

    public StudentStack() {
        this.stackArray = new Student[MAX_SIZE];
        this.top = -1;
    }

    public void push(Student student) {
        if (top == MAX_SIZE - 1) {
            System.out.println("Stack overflow. Cannot add more students.");
            return;
        }
        stackArray[++top] = student;
        System.out.println("Student added to the stack.");
    }

    public Student pop() {
        if (top == -1) {
            System.out.println("Stack underflow. Cannot pop from an empty stack.");
            return null;
        }
        Student poppedStudent = stackArray[top--];
        System.out.println("Student popped from the stack.");
        return poppedStudent;
    }

    public Student peek() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        }
        return stackArray[top];
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack contents:");
        for (int i = top; i >= 0; i--) {
            System.out.println("ID: " + stackArray[i].id + ", Name: " + stackArray[i].name + ", Department: " + stackArray[i].department);
        }
    }
}

