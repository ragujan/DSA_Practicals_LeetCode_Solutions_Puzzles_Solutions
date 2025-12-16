package com.rag.advent.aoc_2025.day_01.part_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.*;
import java.util.*;

public class Day01 {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Which part do you want to run? (1 or 2)");
        int choice = input.nextInt();

        if (choice == 1) {
            solvePart1();
        } else {
            solvePart2();
        }
    }

    public static void solvePart1() throws Exception {
        Scanner sc = new Scanner(new File("src/com/rag/advent/aoc_2025/day_01/part_1/input.txt"));

        int pos = 50;
        int count = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            char direction = line.charAt(0);
            int distance = Integer.parseInt(line.substring(1));

            if (direction == 'R') {
                pos = (pos + distance) % 100;
            } else {
                pos = (pos - distance + 100) % 100;
            }

            if (pos == 0) count++;
        }

        System.out.println("Part 1 answer: " + count);
        sc.close();
    }

    public static void solvePart2() throws Exception {
        Scanner sc = new Scanner(new File("src/com/rag/advent/aoc_2025/day_01/part_1/input.txt"));

        int pos = 50;
        int count = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            char direction = line.charAt(0);
            int distance = Integer.parseInt(line.substring(1));

            int step = (direction == 'R') ? 1 : -1;

            for (int i = 0; i < distance; i++) {
                pos = (pos + step + 100) % 100;
                if (pos == 0) count++;
            }
        }

        System.out.println("Part 2 answer: " + count);
        sc.close();
    }
}