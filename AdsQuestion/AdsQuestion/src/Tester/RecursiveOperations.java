package Tester;

import java.util.Scanner;

public class RecursiveOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read a number from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // 1. Find the sum of digits of the number using a recursive function
        int sumOfDigits = sumOfDigitsRecursive(number);
        System.out.println("Sum of digits of the number: " + sumOfDigits);

        // 2. Find the square of the number using a recursive function
        int square = squareRecursive(number);
        System.out.println("Square of the number: " + square);

        // 3. Demonstrate tail recursion for finding the factorial of the number
        int factorial = factorialTailRecursive(number, 1);
        System.out.println("Factorial of the number using tail recursion: " + factorial);

        // 4. Check whether the number is palindrome or not
        System.out.print("Enter a number to check if it's a palindrome: ");
        int palindromeNumber = scanner.nextInt();
        if (isPalindrome(palindromeNumber)) {
            System.out.println(palindromeNumber + " is a palindrome.");
        } else {
            System.out.println(palindromeNumber + " is not a palindrome.");
        }

        scanner.close();
    }

    // Recursive function to find the sum of digits of a number
    private static int sumOfDigitsRecursive(int num) {
        if (num == 0) {
            return 0;
        } else {
            return num % 10 + sumOfDigitsRecursive(num / 10);
        }
    }

    // Recursive function to find the square of a number
    private static int squareRecursive(int num) {
        if (num == 0) {
            return 0;
        } else {
            return num + squareRecursive(num - 1);
        }
    }

    // Tail recursive function to find the factorial of a number
    private static int factorialTailRecursive(int num, int result) {
        if (num == 0 || num == 1) {
            return result;
        } else {
            return factorialTailRecursive(num - 1, num * result);
        }
    }

    // Function to check whether a number is palindrome or not
    private static boolean isPalindrome(int num) {
        int reversedNum = reverseNumber(num);
        return num == reversedNum;
    }

    // Helper function to reverse a number
    private static int reverseNumber(int num) {
        int reversedNum = 0;
        while (num != 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        return reversedNum;
    }
}