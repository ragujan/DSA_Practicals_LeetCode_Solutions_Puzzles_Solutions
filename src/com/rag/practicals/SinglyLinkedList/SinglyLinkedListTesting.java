package com.rag.practicals.SinglyLinkedList;

public class SinglyLinkedListTesting {
	private int[] numbers = { 1, 2, 3, 4, 5 };

	public static class Node {
		public int value;
		public Node nextNode;

		public Node(int x, Node nextNode) {
			this.value = x;
			this.nextNode = nextNode;
		}
	}

	public void buildList() {
	    if (numbers == null || numbers.length == 0) {
	        return ;
	    }

	    Node head = null;

	    for (int i = 1; i < numbers.length; i++) {
	        Node newNode = new Node(numbers[i], null);
	        if(head == null) {
	        	head = newNode;
	        }else {
	        	Node current = head;
	        	while(current.nextNode !=null) {
	        		current = current.nextNode;
	        	}
	        	current.nextNode = newNode;
	        }
	    }
		printNode(head);

	}

	public void printNode(Node node) {
		Node currentNode = node;
		while (currentNode.nextNode != null) {
			System.out.println("node " + node.value);
			currentNode = node.nextNode;
		}

	}

	public static void main(String[] args) {
		SinglyLinkedListTesting testing = new SinglyLinkedListTesting();
		testing.buildList();
	}
}
