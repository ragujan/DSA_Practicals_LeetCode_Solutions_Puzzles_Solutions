package com.rag.advent.aoc_2024.day_01.part_1;

import java.io.File;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        File myObj = new File("src/com/rag/advent/aoc_2024/day_01/part_1/input.txt");
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
            Collections.sort(p1List);
            Collections.sort(p2List);
            System.out.println(p1List);
            System.out.println(p2List);
            for (int i = 0; i <p1List.size() ; i++) {
              int sum = Math.abs(p1List.get(i) - p2List.get(i));
              totalDistance += sum;
            }
            System.out.println("total distance is "+totalDistance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
