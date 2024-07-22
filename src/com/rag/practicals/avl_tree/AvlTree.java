package com.rag.practicals.avl_tree;

public class AvlTree {

	Node root;

	int height(Node n) {
		if (n == null) {
			return 0;
		}
		return n.height;
	}

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	Node rightRotate(Node y) {
		Node x = y.left;
		Node z = x.right;

		x.right = y;
		y.left = z;

		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;
	}

	Node leftRotate(Node x) {
		Node y = x.right;
		Node z = y.left;

		y.left = x;
		x.right = z;

		x.height = updateHeight(x);
		y.height = updateHeight(y);

		return y;
	}

	int getBalance(Node n) {
		if (n == null) {
			return 0;
		}
		return height(n.left) - height(n.right);
	}

	Node rebalance(Node z) {
		updateHeight(z);
		int balance = getBalance(z);
		
//		if the node is right heavy we do left rotation 
		if(balance > 1) {
			if(height(z.right.right) > height(z.right.left)) {
				z = leftRotate(z);
			}
			if(height(z.right.left) > height(z.right.left)) {
				 z.right = rightRotate(z.right);
				 z = leftRotate(z);
			}
		}
//		if the node left is heavy we do right rotation
		if( balance < -1) {
			if(height(z.left.left) > height(z.left.right)) {
				z = rightRotate(z);
			}
			if(height(z.left.right)> height(z.left.left)) {
				z.left =  leftRotate(z);
				z = rightRotate(z);
			}
		}
		return z;

	}
	Node insert(Node root, int key) {
		if(root ==null) {
			return new Node(key);
		}else if(root.key > key) {
			root.left = insert(root.left, key);
		}else if(key > root.key) {
			root.right = insert(root.right, key);
		}else {
			throw new RuntimeException("Duplicate key");
		}
		return rebalance(root);

		
	}

	int updateHeight(Node n) {
		int height = 1 + Math.max(height(n.left), height(n.right));
		return height;
	}

}

class Node {
	int key, height;
	Node left, right;

	Node(int d) {
		key = d;
		height = 1;
	}
}