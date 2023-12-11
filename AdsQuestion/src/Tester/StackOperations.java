package Tester;

import java.util.Scanner;

class Stack {
    private static final int MAX_SIZE = 10;
    private int[] array;
    private int top;

    public Stack() {
        array = new int[MAX_SIZE];
        top = -1;
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack overflow. Cannot push element onto a full stack.");
        } else {
            top++;
            array[top] = data;
            System.out.println("Pushed " + data + " onto the stack.");
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow. Cannot pop element from an empty stack.");
        } else {
            System.out.println("Popped " + array[top] + " from the stack.");
            top--;
        }
    }

    public void checkNumberOfElements() {
        System.out.println("Number of elements on the stack: " + (top + 1));
    }

    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class StackOperations {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Stack stack = new Stack();
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    stack.displayStack();
                    break;
                case 2:
                    System.out.print("Enter data to push onto the stack: ");
                    int dataToPush = scanner.nextInt();
                    stack.push(dataToPush);
                    break;
                case 3:
                    stack.pop();
                    break;
                case 4:
                    stack.checkNumberOfElements();
                    break;
                case 5:
                    System.out.println("Is the stack full? " + stack.isFull());
                    break;
                case 6:
                    System.out.println("Is the stack empty? " + stack.isEmpty());
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
        System.out.println("1. Display the stack");
        System.out.println("2. Push data onto the stack");
        System.out.println("3. Pop data from the stack");
        System.out.println("4. Check number of elements on the stack");
        System.out.println("5. Check if the stack is full");
        System.out.println("6. Check if the stack is empty");
        System.out.println("7. Exit");
    }
}