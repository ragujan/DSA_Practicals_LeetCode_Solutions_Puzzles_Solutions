package com.rag.advent.aoc_2024.day_01.part_2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        File myObj = new File("src/com/rag/advent/aoc_2024/day_01/part_2/input.txt");
        List<Integer> p1List = new ArrayList<>();
        List<Integer> p2List = new ArrayList<>();
        int totalDistance = 0;
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                int p1 = Integer.parseInt(line.split(" {3}")[0]);
                p1List.add(p1);
                int p2 = Integer.parseInt(line.split(" {3}")[1]);
                p2List.add(p2);

            }
            System.out.println(p1List);
            System.out.println(p2List);

            for (Integer integer : p1List) {
                int p1Val = Math.abs(integer);
                int appearedCount = 0;
                for (Integer value : p2List) {
                    int p2Val = Math.abs(value);
                    if (p1Val == p2Val) {
                        appearedCount++;
                    }
                }
                System.out.println("appeared count of " + p1Val + " is " + appearedCount);
                totalDistance += p1Val * appearedCount;
            }
            System.out.println("total distance is "+totalDistance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
