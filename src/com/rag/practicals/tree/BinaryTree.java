package com.rag.practicals.tree;


// An interface for a binary tree, in which each node has at most two children
public interface BinaryTree<E> extends Tree<E>{
    // Returns the Position of p's left child, if there is no returns null
    Position<E> left(Position<E> p)throws IllegalArgumentException;
    // Returns the position of p's right child, if there is no returns null
    Position<E> right(Position<E> p)throws IllegalArgumentException;
    // Returns the position of p's sibling, if there is no returns null
    Position<E> sibling(Position<E> p)throws IllegalArgumentException;
}
