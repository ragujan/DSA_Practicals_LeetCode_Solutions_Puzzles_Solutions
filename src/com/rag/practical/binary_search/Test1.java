package com.rag.practical.binary_search;

public class Test1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 3, 4, 8, 9, 10, 13 };
		int target = 4;
		int index = binarySearch(arr, target);
		System.out.println("index of target " + target + " is " + index);
	}

	private static int binarySearch(int[] arr, int target) {
		int low = 0;
		
		int high = arr.length-1;
		
		while(low <= high) {
			int mid = low + (high-low)/2;
			
			if(arr[mid] == target)
				return mid;
			
			if(arr[mid] <target)
				low = mid+1;
			
			else 
				high = mid-1;
			
		}
		return -1;

	}
}
