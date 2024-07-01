package com.rag.practicals.tree;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> right;
        private Node<E> left;

        public Node(E element, Node<E> above, Node<E> rightChild, Node<E> leftChild) {
            this.element = element;
            this.parent = above;
            this.right = rightChild;
            this.left = leftChild;
        }

        @Override
        public E getElement() throws IllegalStateException {

            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

    }
    // End of the node class

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, right, left);
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {

    }

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }

        Node<E> node = (Node<E>) p;

        if (node.getParent() == node) {
            throw new IllegalArgumentException("P is no longer in the tree");
        }

        return node;

    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();

    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();

    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty())
            throw new IllegalStateException("Tree is not empty");

        root = createNode(e, null, null, null);
        size = 1;
        return root;

    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("p already has a  left child");
        }
        Node<E> leftChild = createNode(e, parent, null, null);
        parent.setLeft(leftChild);
        size++;
        return leftChild;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("p already has a right child");
        }
        Node<E> rightChild = createNode(e, parent, null, null);
        size++;
        return rightChild;
    }

    // Replaces the element at Position p with e and returns the replaced element.
    public E set(Position<E> p, E e) throws IllegalArgumentException {

        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    // Attaches trees t1, and t2 as left and right subtress of external p
    public void attach(Position<E> p,
            LinkedBinaryTree<E> t1,
            LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);

        if (isInternal(p)) {
            throw new IllegalArgumentException("P must be a leaf");
        }

        size += t1.size() + t2.size();

        // sub tree t1 is not empty
        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        // sub tree t2 is not empty
        if (!t1.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;

        }

    }

    // remove the node at position p and replaces it with its child
    // p1--a--p2
    // p1--c1
    // which will be turned into
    // c1--a--p2
    // 

    public E removes(Position<E> p) throws IllegalArgumentException {
            Node<E> node = validate(p);
            if(numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");

            Node<E> child = (node.getLeft() !=null ? node.getLeft():node.getRight());

            if(child !=null){
                child.setParent(node.getParent());
            }

            // if node is the element aka the  root
            if(node == root){
                root = child;
            }else{
                Node<E> parent = node.getParent();
                // if the replacement node is the left child of the parent
                // set the replacement node's child as new left child of the parent
                if(node == parent.getLeft()){
                    parent.setLeft(child);
                }else{
                    parent.setRight(child);
                }
            }
            size--;
            E temp = node.getElement();
            node.setElement(null);
            node.setLeft(null);
            node.setRight(null);
            node.setParent(node);
            return temp;

            

    }

   

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Iterable<Position<E>> positions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'positions'");
    }

}
