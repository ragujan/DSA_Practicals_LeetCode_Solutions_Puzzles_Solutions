package com.rag.practical.binary_search;

public class SecondWay {
	public static int search(int[] array, int target) {
		// get the middle index
		int middleIndex = array.length/2;
		System.out.println("initial middle "+middleIndex);
		System.out.println("initial middle "+middleIndex);
		System.out.println("initial middle "+middleIndex);
		System.out.println("initial middle "+middleIndex);
		System.out.println("initial middle "+middleIndex);
		boolean indexFound = false;
		if (array[middleIndex] == target) {
			indexFound = true;
			return middleIndex;
		} else {
			while (middleIndex < array.length) {
				System.out.println("mid index "+middleIndex);
				if (array[middleIndex] == target) {
					indexFound = true;
					break;
				}
				if (array[middleIndex] < target) {
					middleIndex = (middleIndex + (array.length))/2;
				}
				if (array[middleIndex] > target) {
					middleIndex = middleIndex/2 ;
				}
			}
		}
		if(indexFound)return middleIndex;
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 2, 3, 10, 30, 40, 50, 80, 100, 102, 103, 110, 130, 140, 150, 180, 200 };
		int target =100 ;
		int val = search(array, target);
		System.out.println(val);
	}

//	public static int getMiddleIndex(int length) {
//		int middleIndex = 0;
//		if (length % 2 == 0) {
//			System.out.println("Even Number");
//			middleIndex = (length / 2) - 1;
//		} else {
//			System.out.println("Not an Even Number");
//			middleIndex = (length / 2);
//		}
//
//		System.out.println("middle Index is "+middleIndex);
//		return middleIndex;
//	}

}
