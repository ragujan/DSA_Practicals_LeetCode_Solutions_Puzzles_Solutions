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
		return root;
	}

	// Given a binary search tree and a key, this function deletes the key and
	// returns the new root
	Node deleteNode(Node root, int key) {
		// Base case
		if (root == null) {
			return root;
		}

		// If the key to be deleted is smaller than the root's key, then it lies in the
		// left subtree
		if (key < root.key) {
			root.left = deleteNode(root.left, key);
		}
		// If the key to be deleted is greater than the root's key, then it lies in the
		// right subtree
		else if (key > root.key) {
			root.right = deleteNode(root.right, key);
		}
		// If key is same as root's key, then this is the node to be deleted
		else {
			// Node with only one child or no child
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			// Node with two children: Get the inorder successor (smallest in the right
			// subtree)
			root.key = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteNode(root.right, root.key);
		}

		return root;
	}

	int minValue(Node root) {
		int minV = root.key;

		while (root.left != null) {
			minV = root.left.key;
			root = root.left;
		}
		return minV;

	}

	public void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		inOrderTraversal(root.left);
		System.out.println("key is " + root.key);
		inOrderTraversal(root.right);

	}
	public void preOrderTraversal(Node root) {
		
		if (root == null) {
			return;
		}

		System.out.println("key is " + root.key);
		inOrderTraversal(root.left);
		inOrderTraversal(root.right);

	}
	public void postOrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		inOrderTraversal(root.left);
		inOrderTraversal(root.right);
		System.out.println("key is " + root.key);

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
		System.out.println("In order ");
		tree.inOrderTraversal(tree.root);
		System.out.println("pre order ");
		tree.preOrderTraversal(tree.root);
		System.out.println("post order ");
		tree.postOrderTraversal(tree.root);

		tree.root = tree.deleteNode(tree.root, 50);// Key to be found

		System.out.println("after deleting ");
		tree.postOrderTraversal(tree.root);
//		System.out.println("deleted tree "+deleted.key);
//		int key = 6;
//
//		// Searching in a BST
//		if (tree.search(tree.root, key) == null)
//			System.out.println(key + " not found");
//		else
//			System.out.println(key + " found");
//
//		key = 60;
//
//		// Searching in a BST
//		if (tree.search(tree.root, key) == null)
//			System.out.println(key + " not found");
//		else
//			System.out.println(key + " found");
	}
}
