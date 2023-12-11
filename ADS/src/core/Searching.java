package core;

import java.util.Arrays;
import java.util.Scanner;

public class Searching {
      
public static int linearSearch(int[]arr,int key)
{
	for (int i=0; i<arr.length;i++) {
		if(arr[i]==key)
			return i;		
	}
	return -1;
}

public static int binarySearch(int[]arr,int key)
{
	int left=0,right=arr.length-1,mid;
	while(left<=right)
	{
		mid=(left+right)/2;
		if(key==arr[mid])
			return mid;
		if(key<arr[mid])
			right=mid-1;
		else
			left=mid+1;
	}
	return -1;
}

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int[] arr = {11,23,10,45,28,35,40,60};
	Arrays.sort(arr);
	System.out.println("Enter an element to search: ");
	int index=sc.nextInt();
	int linearSearch = linearSearch(arr, index);
	if(index!=-1)
		System.out.println("Key found at index"+index);
	else
		System.out.println("Key is  not found");
	
	binarySearch(arr, index);
	if(index!=-1)
		System.out.println("Key found at index"+index);
	else
		System.out.println("Key is  not found");
}
}
