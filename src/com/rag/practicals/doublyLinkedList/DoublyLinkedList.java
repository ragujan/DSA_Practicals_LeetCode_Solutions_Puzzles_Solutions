package com.rag.practicals.doublyLinkedList;

public class DoublyLinkedList<E> {
	private static class Node<E> {
		// reference to the subsequent node in the list
		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> prev, Node<E> next) {
			this.element = e;
			this.prev = prev;
			this.next = next;

		}

		public E getElement() {
			return element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setPrev(Node<E> p) {
			prev = p;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty()) {
			return null;
		}
		return header.getNext().element;
	}

	public E last() {
		if (isEmpty()) {
			return null;
		}
		return trailer.getPrev().element;
	}

	public void addFirst(E e) {

	}
	public void addLast(E e ) {
	}
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e,predecessor,successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	private E removeBetween(Node<E> node) {
		Node<E> predecessor =  node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}

}
