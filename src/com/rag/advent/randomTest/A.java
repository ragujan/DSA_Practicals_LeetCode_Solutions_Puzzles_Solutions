package com.rag.advent.randomTest;

import java.util.LinkedList;
import java.util.List;

public class A {
    static List<String> ab = new LinkedList<>();

    public static void main(String[] args) {

        A.ab.add("a");
        A.ab.add("b");
        A.ab.add("c");
        A.ab.add("d");

        A.ab.add("a");
        System.out.println(A.ab.indexOf("a"));
    }
}
