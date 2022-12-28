package com.rag.advent.day_7_2;

public class File {
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    String name;
    int size;
}
