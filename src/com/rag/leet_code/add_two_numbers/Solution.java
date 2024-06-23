package com.rag.leet_code.add_two_numbers;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

class Solution {
	ListNode nodeToBeBuilt = new ListNode();

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		String val = "0";
		BigInteger sum1 = BigInteger.ZERO;
		BigInteger sum2 = BigInteger.ZERO;
		try {
			sum1 = new BigInteger(getSum(l1).toString());
			sum2 = new BigInteger(getSum(l2).toString());
			BigInteger totalSum = sum1.add(sum2);
			val = totalSum.toString();
		} catch (NumberFormatException ex) {
			System.out.println("Number format exception");
		}

		buildIntegerListForNode(val);

		buildListNode();

		return nodeToBeBuilt;
	}

	private StringBuilder getSum(ListNode listNode) {
		boolean endFound = false;
		ListNode currentNode = listNode;
		List<Integer> firstSumList = new LinkedList<>();
		StringBuilder firstSum = new StringBuilder("");
		while (!endFound) {

			int val = currentNode.val;
			firstSumList.add(val);
			if (currentNode.next == null) {
				endFound = true;
				break;
			}
			currentNode = currentNode.next;
		}
		for (int i = firstSumList.size() - 1; i >= 0; i--) {
			firstSum.append(firstSumList.get(i));
		}
		return firstSum;
	}

	List<Integer> intVales = new LinkedList<>();

	public void buildIntegerListForNode(String sum) {
		String sumStr = sum;
		StringBuilder builder = new StringBuilder(sumStr);
		for (int i = sumStr.length() - 1; i >= 0; i--) {
			char digitChar = sumStr.charAt(i);
			int intVal = digitChar - '0';
			intVales.add(intVal);
		}
		intVales.forEach(e -> System.out.println("int values " + intVales));

	}

	public void buildListNode() {

		ListNode currentNode = null;
//        initializing the first node regarless
		this.nodeToBeBuilt = new ListNode();
		if (this.nodeToBeBuilt.next == null) {
			this.nodeToBeBuilt.val = intVales.get(0);
//          check if the intValues has more than 1 elements before adding the next node
			ListNode nextNode = null;
			if (intVales.size() > 1) {
				nextNode = new ListNode(intVales.get(0 + 1));
			}
			this.nodeToBeBuilt.next = nextNode;
			currentNode = nextNode;
		}
		if ((this.nodeToBeBuilt.next == null) && (this.nodeToBeBuilt.val != intVales.get(0))) {

		}
		int count = 1;
		while (currentNode != null) {

			if (count == intVales.size() - 1) {
				currentNode.next = null;
				break;
			}
			ListNode nextNode = new ListNode(intVales.get(count + 1));
			currentNode.next = nextNode;
			currentNode = nextNode;
			count++;
		}

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}