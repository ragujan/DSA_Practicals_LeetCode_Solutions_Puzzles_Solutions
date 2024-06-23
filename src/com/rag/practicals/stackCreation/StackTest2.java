package com.rag.practicals.stackCreation;

public class StackTest2 {

	static final int MAX = 1000;

	int top;
//	set max size of the stack
	int a[] = new int[MAX];

	boolean isEmpty() {
		return (top < 0);
	}

	public StackTest2() {
		// TODO Auto-generated constructor stub
		top = -1;
	}

	boolean push(int x) {
		if (top >= (MAX - 1)) {
			System.out.println("Stakc Overflwo");
			return false;
		} else {
			top++;
			a[top] = x;
			return true;
		}

	}

	int pop() {
		if (top < 0) {
			System.out.println("Stack is empty");
			return 0;
		} else {
			int x = a[top--];
			return x;
		}
	}

	int peek() {
		if (top < 0) {
			System.out.println("Stack is underflow");
			return 0;
		} else {
			int x = a[top];
			return x;
		}
	}

	void print() {
		for (int i = top; i > -1; i--) {
			System.out.println(" " + a[i]);
		}
	}
}

class StackTestRun {
	public static void main(String[] args) {
		StackTest2 stack = new StackTest2();
		stack.push(33);
		stack.push(20);
		stack.push(11);
		stack.print();
		System.out.println(stack.pop() + " Popped from stack");
		System.out.println("Top element is :" + stack.peek());
		System.out.print("Elements present in stack :");
		stack.print();

	}
}
