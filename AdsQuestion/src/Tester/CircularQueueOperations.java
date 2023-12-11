package Tester;

import java.util.Scanner;

class CircularQueue {
    private static final int MAX_SIZE = 5;
    private int[] queue;
    private int front, rear, size;

    public CircularQueue() {
        queue = new int[MAX_SIZE];
        front = -1;
        rear = -1;
        size = 0;
    }

    public void showCircularQueue() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty.");
        } else {
            System.out.print("Circular Queue: ");
            int i = front;
            do {
                System.out.print(queue[i] + " ");
                i = (i + 1) % MAX_SIZE;
            } while (i != (rear + 1) % MAX_SIZE);
            System.out.println();
        }
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Circular Queue is full. Cannot enqueue element.");
        } else {
            if (isEmpty()) {
                front = 0; // If the circular queue is empty, set front to 0
            }
            rear = (rear + 1) % MAX_SIZE;
            queue[rear] = data;
            size++;
            System.out.println("Enqueued " + data + " into the Circular Queue.");
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty. Cannot dequeue element.");
        } else {
            System.out.println("Dequeued " + queue[front] + " from the Circular Queue.");
            front = (front + 1) % MAX_SIZE;
            size--;
            if (isEmpty()) {
                // If the circular queue becomes empty after dequeue, reset front and rear
                front = -1;
                rear = -1;
            }
        }
    }

    public void checkNumberOfElements() {
        System.out.println("Number of elements in the Circular Queue: " + size);
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class CircularQueueOperations {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue();
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    circularQueue.showCircularQueue();
                    break;
                case 2:
                    System.out.print("Enter data to enqueue into the Circular Queue: ");
                    int dataToEnqueue = scanner.nextInt();
                    circularQueue.enqueue(dataToEnqueue);
                    break;
                case 3:
                    circularQueue.dequeue();
                    break;
                case 4:
                    circularQueue.checkNumberOfElements();
                    break;
                case 5:
                    System.out.println("Is the Circular Queue full? " + circularQueue.isFull());
                    break;
                case 6:
                    System.out.println("Is the Circular Queue empty? " + circularQueue.isEmpty());
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
        System.out.println("1. Show the contents of Circular Queue");
        System.out.println("2. Enqueue data into the Circular Queue");
        System.out.println("3. Dequeue data from the Circular Queue");
        System.out.println("4. Check number of elements in the Circular Queue");
        System.out.println("5. Check if the Circular Queue is full");
        System.out.println("6. Check if the Circular Queue is empty");
        System.out.println("7. Exit");
    }
    
}

