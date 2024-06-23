package com.rag.practicals.dequeue;

public class ArrayQueue<E> {
    private E[] data;
    private int frontIndex =0;
    private int size = 0;

    public ArrayQueue(){
    }
    public ArrayQueue(int capacity){
        data = (E[]) new Object[capacity];
    }
    
    public int size() {
    	return size;
    }
    public boolean isEmpty() {
    	return (size==0);
    }
    
//    Insert an element at the rear of the queue
    public void enqueue(E e) throws IllegalStateException {
    	if(size == data.length)throw new IllegalStateException("QUeue is full");
    	int available = (size + frontIndex) % data.length;
    	data[available] = e;
    	size++;
    }
    // remove an element at the rear of the queue
    public E dequeue(){
        if(isEmpty()) return null;

        E value = data[frontIndex];
        data[frontIndex] = null;
        frontIndex = (frontIndex+1)%data.length;
        size--;
        return value;

    }
    public E first(){
        if(isEmpty())return null;
        return data[frontIndex];
    }

    
    
}
