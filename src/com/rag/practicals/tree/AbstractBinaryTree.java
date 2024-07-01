package com.rag.practicals.tree;

import java.util.ArrayList;
import java.util.List;

// An abstract base class providing some functionality 
// of the Binary tree interface
public abstract class AbstractBinaryTree<E>
        extends AbstractTree<E>
        implements BinaryTree<E> {

    public Position<E> sibling(Position<E> p) {
        // get the parent of the position of p's
        Position<E> parent = parent(p);
        // p must be root
        if (parent == null)
            return null;

        // p is the left child of parent
        // the sibling will the right child of the parent
        if (p == left(parent))
            return right(parent);
        else
            return left(parent);

    }

    // retunrs the number of children of position p
    public int numChildren(Position<E> p) {
        int count = 0;
        // if parent has a left child increse the count
        if (left(p) != null) {
            count++;
        }
        // if parent has a right child increse the count
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    // returns an iterable collection of the Positions representing p's
    // children

    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null) {
            snapshot.add(left(p));
        }

        if (right(p) != null) {
            snapshot.add(right(p));
        }
        return snapshot;

    }
}
