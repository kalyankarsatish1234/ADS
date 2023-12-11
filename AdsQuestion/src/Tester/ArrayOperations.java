package Tester;

import java.util.Scanner;

public class ArrayOperations {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the count of elements: ");
        int count = scanner.nextInt();

        int[] array = new int[count];
        initializeArray(array);

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice (1-7): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayArray(array);
                    break;
                case 2:
                    reverseArray(array);
                    break;
                case 3:
                    replaceNthElement(array);
                    break;
                case 4:
                    findSum(array);
                    break;
                case 5:
                    findMax(array);
                    break;
                case 6:
                    findAverage(array);
                    break;
                case 7:
                    displayEvenOdd(array);
                    break;
                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 8);

        scanner.close();
    }

    private static void initializeArray(int[] array) {
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
    }

    private static void displayArray(int[] array) {
        System.out.print("Array elements: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void reverseArray(int[] array) {
        System.out.print("Reversed array: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static void replaceNthElement(int[] array) {
        System.out.print("Enter the position (1-" + array.length + ") to replace: ");
        int position = scanner.nextInt();

        if (position >= 1 && position <= array.length) {
            System.out.print("Enter the new value: ");
            int newValue = scanner.nextInt();
            array[position - 1] = newValue;
            System.out.println("Array after replacement: ");
            displayArray(array);
        } else {
            System.out.println("Invalid position. Please enter a valid position.");
        }
    }

    private static void findSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println("Sum of array elements: " + sum);
    }

    private static void findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Maximum element in the array: " + max);
    }

    private static void findAverage(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        double average = (double) sum / array.length;
        System.out.println("Average of array elements: " + average);
    }

    private static void displayEvenOdd(int[] array) {
        System.out.print("Even numbers: ");
        for (int num : array) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        System.out.print("Odd numbers: ");
        for (int num : array) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Display the array");
        System.out.println("2. Reverse the array");
        System.out.println("3. Replace nth element from the array");
        System.out.println("4. Find the addition of all elements of the array");
        System.out.println("5. Find the maximum number from the array");
        System.out.println("6. Print the average of all elements from the array");
        System.out.println("7. Display even and odd numbers from the array separately");
        System.out.println("8. Exit");
    }
}