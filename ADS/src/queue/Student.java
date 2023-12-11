package queue;

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

class LinearStudentQueue {
    private static final int MAX_SIZE = 100;
    private Student[] queueArray;
    private int front;
    private int rear;
    private int size;

    public LinearStudentQueue() {
        this.queueArray = new Student[MAX_SIZE];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(Student student) {
        if (size == MAX_SIZE) {
            System.out.println("Queue is full. Cannot enqueue more students.");
            return;
        }
        rear = (rear + 1) % MAX_SIZE;
        queueArray[rear] = student;
        size++;
        System.out.println("Student enqueued to the queue.");
    }

    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        Student dequeuedStudent = queueArray[front];
        front = (front + 1) % MAX_SIZE;
        size--;
        System.out.println("Student dequeued from the queue.");
        return dequeuedStudent;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Students in the queue:");
        int current = front;
        for (int i = 0; i < size; i++) {
            System.out.println("ID: " + queueArray[current].id + ", Name: " + queueArray[current].name + ", Department: " + queueArray[current].department);
            current = (current + 1) % MAX_SIZE;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}


    