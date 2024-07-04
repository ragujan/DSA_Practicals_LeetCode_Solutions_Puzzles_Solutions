package com.rag.practicals.BinaryTree;

public class BinaryTree {
    Node root ;
    public BinaryTree() {
        this.root = null;
    }

    // Method to insert a node
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node rootNode, int value) {
        if (rootNode == null) {
            rootNode = new Node(value);
            return rootNode;
        }
        if (value < rootNode.value) {
            rootNode.left = insertRec(rootNode.left, value);
        } else if (value > rootNode.value) {
            rootNode.right = insertRec(rootNode.right, value);
        }
        return rootNode;
    }

    // Method for in-order traversal
    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

    int count = 0;
    // Method for pre-order traversal
    public void preOrderTraversal(Node root) {
    	System.out.println("----");
    	count++;
    	System.out.println("count "+count);
        if (root != null) {
            System.out.println(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }else {
        	System.out.println("root is null");
        }
    }

    // Method for post-order traversal
    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

   
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print in-order traversal
        System.out.println("In-order traversal:");
        tree.inOrderTraversal(tree.root);

        // Print pre-order traversal
        System.out.println("\nPre-order traversal:");
        tree.preOrderTraversal(tree.root);

        // Print post-order traversal
        System.out.println("\nPost-order traversal:");
        tree.postOrderTraversal(tree.root);
    }
}


 class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
