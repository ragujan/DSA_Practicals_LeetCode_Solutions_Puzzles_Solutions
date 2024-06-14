package com.rag.practicals.stackCreation;

import java.util.EmptyStackException;

public class StackTest {
	private int[] data;
	private int capacity;
	private int size;
	private int top;

	public StackTest(int capacity) {
		this.capacity = capacity;
		this.data = new int[capacity];
		this.top = -1;
	}

	public boolean isFull() {
		return top == capacity - 1;
	}

	public void push(int value) {
		if (!isFull()) {
			top++;
			data[top] = value;
			size++;
		} else {
			throw new StackOverflowError("Stack is Full");
		}
	}

	public boolean isEmpty() {
		return top != -1;
	}

	public int pop() {
		if (!this.isEmpty()) {
			top--;
			size--;
			return data[top];
		} else {
			throw new EmptyStackException();
		}
	}

	public int peek() {

		if (!this.isEmpty()) {
			return data[top];

		} else {
			throw new EmptyStackException();
		}
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			out.append(data[i]);

			if (i == data.length - 1) {
				out.append("]");
			} else {
				out.append(",");
			}

			if (size == 0) {
				out.append("]");
			}

		}
		return out.toString();

	}
}
