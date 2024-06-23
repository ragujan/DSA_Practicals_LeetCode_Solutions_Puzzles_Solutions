package com.rag.practicals;

public class SortList {

	// Represent a node of the singly linked list
	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// Represent the head of the singly linked list
	public Node head = null;

	// addNode() will add a new node to the list
	public void addNode(int data) {
		// Create a new node
		Node newNode = new Node(data);

		// If the list is empty, make the new node as head
		if (head == null) {
			head = newNode;
		} else {
			// Traverse to the last node and add the new node
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	// sortList() will sort nodes of the list in ascending order using Selection
	// Sort
	public void sortList() {
		Node current = head;

		// Traverse through the list
		while (current != null) {
			if (current.next == null) {
				System.out.println("null");
			}
			System.out.println("current is " + current.data);

			Node index = current.next;

			Node min = current;
			if (current.next != null) {
				System.out.println("index is " + index.data);
				System.out.println("min is " + min.data);
			}

			// Find the minimum element in the unsorted part of the list
			while (index != null) {
				System.out.println("index now " + index.data);
				System.out
						.println("index.data " + index.data + "< min.data " + min.data + " " + (index.data < min.data));
				if (index.data < min.data) {
					min = index;
					System.out.println("min is set to " + (min.data));
				}
				index = index.next;
			}

			// Swap the minimum element with the current element
			int temp = current.data;
			System.out.println("temp is " + temp);
			System.out.println("before current data is " + current.data);
			current.data = min.data;
			System.out.println("min is " + min.data);
			System.out.println("current data is " + current.data);
			min.data = temp;
			System.out.println("min is " + min.data);

			// Move to the next node
			current = current.next;
			if (current != null) {

				System.out.println("current is " + current.data);
			}
			System.out.println("-------------");
			System.out.println("-------------");

		}
	}

	// display() will display all the nodes present in the list
	public void display() {
		Node current = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		while (current != null) {
			// Print each node's data
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SortList sList = new SortList();

		// Add data to the list
		sList.addNode(8);
		sList.addNode(3);
		sList.addNode(7);
		sList.addNode(4);

		// Display original list
		System.out.println("Original list:");
		sList.display();

		// Sort the list using Selection Sort
		sList.sortList();

		// Display sorted list
		System.out.println("Sorted list:");
		sList.display();
	}
}
