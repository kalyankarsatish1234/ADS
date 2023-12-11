package core;

import java.util.Arrays;

public class Sorting {

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
             System.out.println(Arrays.toString(arr));
		}
	}

	public static void main(String[] args) {

		int[] arr = { 2, 5, 6, 4, 6, 3 };
         System.out.println("Before sorting"+Arrays.toString(arr));
         selectionSort(arr);
         System.out.println("After sorting"+Arrays.toString(arr));
	}
}
