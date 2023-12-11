package Tester;

import java.util.Scanner;

class SimpleQueue {
    private static final int MAX_SIZE = 10;
    private int[] queue;
    private int front, rear, size;

    public SimpleQueue() {
        queue = new int[MAX_SIZE];
        front = -1;
        rear = -1;
        size = 0;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element.");
        } else {
            if (isEmpty()) {
                front = 0; // If the queue is empty, set front to 0
            }
            rear++;
            queue[rear] = data;
            size++;
            System.out.println("Enqueued " + data + " into the queue.");
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
        } else {
            System.out.println("Dequeued " + queue[front] + " from the queue.");
            front++;
            size--;
            if (isEmpty()) {
                // If the queue becomes empty after dequeue, reset front and rear
                front = -1;
                rear = -1;
            }
        }
    }

    public void checkNumberOfElements() {
        System.out.println("Number of elements in the queue: " + size);
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class QueueOperations {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue();
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    queue.showQueue();
                    break;
                case 2:
                    System.out.print("Enter data to enqueue into the queue: ");
                    int dataToEnqueue = scanner.nextInt();
                    queue.enqueue(dataToEnqueue);
                    break;
                case 3:
                    queue.dequeue();
                    break;
                case 4:
                    queue.checkNumberOfElements();
                    break;
                case 5:
                    System.out.println("Is the queue full? " + queue.isFull());
                    break;
                case 6:
                    System.out.println("Is the queue empty? " + queue.isEmpty());
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Show the queue");
        System.out.println("2. Enqueue data into the queue");
        System.out.println("3. Dequeue data from the queue");
        System.out.println("4. Check number of elements in the queue");
        System.out.println("5. Check if the queue is full");
        System.out.println("6. Check if the queue is empty");
        System.out.println("7. Exit");
    }
}