package com.rag.practicals;

import java.util.*;

public class ReverseList {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		// Array of numbers to add to the LinkedList
		int[] numbers = { 1, 4, 5, 1, 3, 4, 2, 6 };

		// Add each number to the LinkedList
		for (int number : numbers) {
			list.add(number);
		}
		bubbleSort(list);
		list.forEach(e->System.out.println("e "+e));

	}

	public void doSorting(LinkedList<Integer> sortedj) {
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> sortedList = new LinkedList<>();
		// Array of numbers to add to the LinkedList
		int[] numbers = { 1, 4, 5, 1, 3, 4, 2, 6 };

		// Add each number to the LinkedList
		for (int number : numbers) {
			list.add(number);
		}
		for (int i = 0; i < list.size(); i++) {
			if (sortedList.size() == 0) {
				sortedList.add(list.get(i));
			}
			Integer comparingVal = list.get(i);
			for (int j = 0; j < sortedList.size(); j++) {
				Integer comparableVal = sortedList.get(j);
				System.out.println("comparing value is " + comparingVal);
				System.out.println("comparable value is " + comparableVal);
				if (comparableVal < comparingVal) {
//					System.out.println(comparingVal + "bigger than " + comparableVal);
					sortedList.add(j + 1, comparingVal);
				}
				if (comparableVal > comparingVal) {
					if (j > 1) {
						sortedList.add(j - 1, comparingVal);
					} else {
						sortedList.add(j + 1, comparingVal);
					}
//					sortedList.add(j + 1, comparingVal);
					// sortedList.remove(j);

					// sortedList.add(j, comparingVal);
					// sortedList.add(j+1, comparableVal);
				}
				if (comparableVal == comparingVal) {
//					sortedList.add(j + 1, comparingVal);

				}

				System.out.println("---------");
//	}

			}
			sortedList.forEach(e -> System.out.println("e " + e));

		}
	}

	public static void bubbleSort(LinkedList<Integer> list) {
		int n = list.size();
		boolean swapped;
		// Outer loop for the number of passes
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			// Inner loop for each pass
			for (int j = 0; j < n - 1 - i; j++) {
				if (list.get(j) > list.get(j + 1)) {
					// Swap the elements
					int temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
					swapped = true;
				}
			}
			// If no two elements were swapped by the inner loop, then break
			if (!swapped)
				break;
		}
	}

	public static void insertionSort(LinkedList<Integer> list) {

		for (int i = 0; i < list.size(); i++) {

		}

	}
}
