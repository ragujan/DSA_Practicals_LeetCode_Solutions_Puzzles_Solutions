package com.rag.advent.day_7_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Test {
    void doStuff(List<String> lines) {
        Dir current = new Dir("", null, new LinkedList<>(), new HashMap<>());
        Dir root = current;
        String mode = "";
        int i =0;
        for (String line : lines) {

            String[] words = line.split(" ");
            if(line.startsWith("$")){
                switch (words[1]){
                   case "cd"->{
                       System.out.println(words[2]);

                   }
                }
            }
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.doStuff(Util.inputFile());

    }
}
