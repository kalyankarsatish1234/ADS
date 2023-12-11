package sorting;

import java.util.Arrays;

public class MergeSorting {
    public static void meregeSort(int[] arr,int left,int right){
    	//if partition is invalid or have single element , then return
    	if(left>=right)
    		return;
    	//divide array into two equal part
    	int mid=(left+right)/2;
    	// sort left partition[left to mid]
    	meregeSort(arr, left, mid);
    	//sort right partition [mid+1 to right]
    	meregeSort(arr,mid+1, right);
    	//create a temp array to accomodate both partition
    int[] temp = new int[right-left+1];
    //merege two sorted partition into temp array
    int i=left,j=mid+1,k=0;
     //compare two elements from both partitions and copy smaller one[until one partition is done]
    while(i <=mid && j<=right) {
    if(arr[i]<arr[j])
    	temp[k++]=arr[i++];
    else
    	temp[k++]=arr[j++];
    }
    //copy remaining elements from other partition
    while(i<=mid)
    	temp[k++]=arr[i++];
    while(j <= right)
    	temp[k++]=arr[j++];
    
    //overwrite temp array back to original array
    for(i=0;i < temp.length;i++)
    	arr[left + i] = temp[i];
}
    
    public static void main(String[] args) {
		int[] arr = {8,3,9,1,5,7,2,6,4};
		System.out.println(Arrays.toString(arr));
		meregeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}