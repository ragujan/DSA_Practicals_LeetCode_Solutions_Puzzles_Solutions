package com.rag.leet_code.random;

public class A {
    String nameA;
    String ageB;
    B b = new B("B");

    public A (String a){
        System.out.println(a);
    }
}
class Test{
    public static void main(String[] args) {
        A a = new A("a");
        B b = new B("b");
    }
}