package com.rag.practicals.circularLinkedList;

public class CircularlyLinkedList<E> {

	private static class Node<E> {
		private E element; // reference to the element stored at this node
		private Node<E> next; // reference to the subsequent node in the list

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	private Node<E> tail = null;
	private int size = 0;

	public CircularlyLinkedList() {

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty())
			return null;

		return tail.getNext().element;
	}

	public E last() {
		if (isEmpty())
			return null;

		return tail.element;
	}

	public void rotate() {
		if (tail == null)
			return;

		tail = tail.getNext();
	}
	
	public void addFirst(E e) {
		if(isEmpty()) {
			tail = new Node<>(e,null);
			tail.setNext(tail);
		}
		Node<E> head = tail.getNext();
		tail.setNext(new Node<>(e,head));
		size++;
		
	}
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
		
	}
	public E removeFirst(E e) {
		 if(isEmpty())return null;
		 
		 Node<E> head = tail.getNext();
		 if(head==tail) tail = null;
		 Node<E> headNext = head.getNext();
		 tail.setNext(headNext);
		 size--;
		 return head.element;
	}
	
	

}
