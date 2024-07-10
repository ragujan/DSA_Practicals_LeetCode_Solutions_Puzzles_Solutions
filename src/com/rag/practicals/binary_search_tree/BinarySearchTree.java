package com.rag.practicals.binary_search_tree;

public class BinarySearchTree {

	Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	Node insert(Node node, int key) {
		if (node == null) {
			node = new Node(key);
		}

		if (key < node.key) {
			node.left = insert(node.left, key);
		}
		if (key > node.key) {
			node.right = insert(node.right, key);
		}

		return node;
	}

	Node search(Node root, int key) {
		if (root == null || root.key == key) {
			return root;
		}

		if (root.key < key) {
			return search(root.right, key);
		}
		if (root.key > key) {
			return search(root.left, key);
		}
		return null;
	}

	Node deleteNode(Node node, int key) {
		if (root == null) {
			return root;
		}

		if (key < root.key) {
			root.left = deleteNode(node.left, key);
		}
		if (key > root.key) {
			root.right = deleteNode(node.right, key);
		}
//		node to be deleted
		if (key == root.key) {
			
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
			
			root.key = minValue(root.right);
			root.right = deleteNode(root.right,root.key);

		}
		return root;
	}
	
	int minValue(Node root) {
		int minV = root.key;
		
		while(root.left != null) {
			minV = root.left.key;
			root = root.left;
		}
		return minV;
		
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		// Inserting nodes
		tree.root = tree.insert(tree.root, 50);
		tree.insert(tree.root, 30);
		tree.insert(tree.root, 20);
		tree.insert(tree.root, 40);
		tree.insert(tree.root, 70);
		tree.insert(tree.root, 60);
		tree.insert(tree.root, 80);

		// Key to be found
		int key = 6;

		// Searching in a BST
		if (tree.search(tree.root, key) == null)
			System.out.println(key + " not found");
		else
			System.out.println(key + " found");

		key = 60;

		// Searching in a BST
		if (tree.search(tree.root, key) == null)
			System.out.println(key + " not found");
		else
			System.out.println(key + " found");
	}
}
