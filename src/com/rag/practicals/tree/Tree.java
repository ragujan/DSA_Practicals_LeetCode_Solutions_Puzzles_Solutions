package com.rag.practicals.tree;

import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {
    // returns the position of the root of the tree
    Position<E> root();

    // returns the position of the parent of position p
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    // returns an iterable collection containing the children of position p
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    // returns the number of children of position p
    int numChildren(Position<E> p) throws IllegalArgumentException;

    // returns true if position p has at least one child
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    // returns true if position p does not have any children
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    // returns true if the position p is the root of the trace
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    // returns the number of positions that are contained in the tree
    int size();

    // Returns true if the tree does not contain any positions
    boolean isEmpty();

    // Returns an iterator for all elements in the tree
    Iterator<E> iterator();

    // Returns an iterable collection of all positions of the tree.
    Iterable<Position<E>> positions();

}
