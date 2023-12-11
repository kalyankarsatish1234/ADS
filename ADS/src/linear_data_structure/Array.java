package linear_data_structure;

import java.util.Iterator;
import java.util.Scanner;

public class Array {
	
	public static void display(int[] arr) {
		System.out.println("Elements in array is");
		for (int element : arr) {
			System.out.println(element);
		}
	}
	
	//Method to reverse given array
	public static void reverseArray(int[] arr) {
		int start=0,end=arr.length-1,temp;
		 temp=arr[start];
		 arr[start]=arr[end];
		 arr[end]=temp;
		 start++;
		 end--;
	}
	
	public static void replaceElement(int[] arr,int index,int newvalue) {
		arr[index]=newvalue;
	}
	
	public static int findSum(int[] arr) {
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum=sum+arr[i];
		}
		return sum;
	}
	
	// To find maximum element in an array
	public static int findMax(int[] arr) {
		int max=arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
	}
	
	//To find average of elements
	public static float findaverage(int[] arr) {
		int sum=findSum(arr);
		float average=sum/arr.length;
		return average;
	}
	
	
	public static void displayEvenOddNumber(int[] arr) {
		System.out.println("Even numbers in array");
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2==0) {
				System.out.println(arr[i]+ " ");
			}
		}
		
		System.out.println("Odd numbers in array");
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2 != 0) {
				System.out.println(arr[i]+" ");
			}
		}
	}
	
	
   // Main method to create a menu based program
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			
		System.out.println("Enter the count of element");
		int size=sc.nextInt();
		int[] arr=new int[size];
		
		System.out.println("Enter an elements of an array");
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
		}
			boolean exit=false;
			while(!exit) {
				System.out.println("1.Display array");
				System.out.println("2.Reverse array");
				System.out.println("3.Replace the nth element from array and print");
				System.out.println("4.Find the addition of all elements of array");
				System.out.println("5.Find the maximum number from array");
				System.out.println("6.Print the average of array");
				System.out.println("7.Display even and odd number from array");
				System.out.println("0.exit");
			
			System.out.println("Enter your choice");
			try {
				switch (sc.nextInt()) {
				
				case 1:
					display(arr);
					break;
				
				case 2:
					reverseArray(arr);
					System.out.println("Elements after reversing an array is \n"); 
					display(arr);
					break;
				
				case 3:
					System.out.println("Enter the index of element to be replaced");
					int index=sc.nextInt();
					System.out.println("Enter the new element to be replaced");
					int newvalue=sc.nextInt();
					replaceElement(arr, index, newvalue);
					display(arr);
					break;
				
				case 4:
					int sumofelement=findSum(arr);
					System.out.println("Sum of elements in an array is: "+ sumofelement);
                    break;
                
				case 5:
					int maxElement=findMax(arr);
					System.out.println("Maximum element in an array is: "+ maxElement);
					break;
					
				case 6:
					float aveargeOfElement=findaverage(arr);
					System.out.println("The average of elements in an array is: "+ aveargeOfElement);
					break;
					
				case 7:
					displayEvenOddNumber(arr);
					break;
				
				case 0:
					exit=true;
					break;
					
				default:
					System.out.println("Invalid choice");
					break;
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Please try");
			}
			}
		}
		
	}

	
}
