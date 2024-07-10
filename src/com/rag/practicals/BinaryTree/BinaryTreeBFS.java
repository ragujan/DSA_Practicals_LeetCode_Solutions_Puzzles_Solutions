package com.rag.practicals.BinaryTree;

public class BinaryTreeBFS {

	Node root;

	public BinaryTreeBFS() {
		root = null;
	}

	public void insert(int value) {
		root = insertRec(root, value);
	}

	public int getHeight() {
		return height(root);
	}

	public Node insertRec(Node rootNode, int value) {
		if (rootNode == null) {
			return new Node(value);
		}

		// value is smaller than root so
		// it will be added to the left side of the node
		if (value < rootNode.value) {
			rootNode.left = insertRec(rootNode.left, value);
		}
		// value is bigger than the root so
		// it will be added as the right side of the root node
		if (value > rootNode.value) {
			rootNode.right = insertRec(rootNode.right, value);
		}
		return rootNode;
	}

	void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printCurrentLevel(root, i);
	}

	// Print nodes at the current level
	void printCurrentLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.println(root.value + " ");
		else if (level > 1) {
			printCurrentLevel(root.left, level - 1);
			printCurrentLevel(root.right, level - 1);
		}
	}

	// Method for in-order traversal
	public void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.value + " ");
			inOrderTraversal(root.right);
		}
	}

	// computes the height of the tree
	// nodes along the longest path from the root node
	// down to the farthest leaf node
	public int height(Node root) {
		if (root == null) {
			return 0;
		} else {

			// left height of the root
			int lheight = height(root.left);
			int rheight = height(root.right);

			// compare the left and the right heights
			// then return the highest height and add 1
			if (lheight > rheight) {
				return lheight + 1;
			} else {
				return rheight + 1;
			}
		}

	}

	public static void main(String[] args) {
		BinaryTreeBFS tree = new BinaryTreeBFS();

		System.out.println("------ bro bor ");
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.printLevelOrder();
		// Print in-order traversal
//		System.out.println("In-order traversal:");
//		tree.inOrderTraversal(tree.root);
		System.out.println("height is " + tree.getHeight());

	}

}
