package com.rag.practicals;



public class Test{

    private Integer[] arr;
    private int capacity = 0;
    private int size = 0;

    public Test(int capacity) {
        this.capacity = capacity;
        arr = new Integer[capacity];
    }

    public void add(int x) {
        if (size < capacity) {
            arr[size++] = x;
            System.out.println();
        } else {
            throw new ArrayIndexOutOfBoundsException("Array is full");
        }
    }

    public void addByIndex(int indexValue, int x) {
        if (indexValue >= 0 && indexValue <= size && size < capacity) {
            for (int i = size; i > indexValue; i--) {
                arr[i] = arr[i - 1];
            }
            arr[indexValue] = x;
            size++;
        }
    }

    public int findIndex(int x){
        for (int i = 0; i < size; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int value) {
        int index=findIndex(value);
        if(index==-1){
            throw new IllegalArgumentException("value not found");
        }
        for (int i = index; i < size-1; i++) {
            arr[i] = arr[i + 1];
        }

//        size--;
        arr[--size] = 0;
    }

    @Override
    public String toString() {
        String out = "[";
        for (int i = 0; i < size; i++) {
            out += arr[i];
            if (i < size - 1) {
                out += ", ";
            }
        }
        out += "]";
        return out;
    }
}