package Circular_Queue;

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

class CircularStudentQueue {
    private static final int MAX_SIZE = 100;
    private Student[] queueArray;
    private int front;
    private int rear;
    private int size;

    public CircularStudentQueue() {
        this.queueArray = new Student[MAX_SIZE];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(Student student) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue more students.");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % MAX_SIZE;
        queueArray[rear] = student;
        size++;
        System.out.println("Student enqueued to the circular queue.");
    }

    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }

        Student dequeuedStudent = queueArray[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }

        size--;
        System.out.println("Student dequeued from the circular queue.");
        return dequeuedStudent;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Students in the circular queue:");
        int current = front;
        int count = 0;
        while (count < size) {
            System.out.println("ID: " + queueArray[current].id + ", Name: " + queueArray[current].name + ", Department: " + queueArray[current].department);
            current = (current + 1) % MAX_SIZE;
            count++;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }
}

