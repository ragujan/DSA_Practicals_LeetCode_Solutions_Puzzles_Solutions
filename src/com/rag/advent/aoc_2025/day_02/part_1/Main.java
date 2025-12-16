package com.rag.advent.aoc_2025.day_02.part_1;

import com.rag.advent.aoc_2025.day_01.part_1.PartOne;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        String fileName;
        if (option == 1) {
            fileName = "input.txt";
        } else {
            fileName = "sample.txt";
        }

        Path p = Path.of(Main.class.getResource(fileName).toURI());
//        Path p = Path.of(Main.class.getResource("input.txt").toURI());
        List<String> lines = Files.readAllLines(p);
        long invalidIdCount = 0;
//items are separated by commas
        for (String line : lines) {
            String[] items = line.split(",");
            for (String item : items) {
                String itemTrimmed = item.trim();
                invalidIdCount += iterateThroughRange(itemTrimmed);

            }
        }
        System.out.println("Total invalid IDs: " + invalidIdCount);


    }

    public static long iterateThroughRange(String idRange) {
        String[] parts = idRange.split("-");
        long start = Long.parseLong(parts[0].trim());
        long end = Long.parseLong(parts[1].trim());
        long invalidIdCount = 0;
        for (long i = start; i <= end; i++) {
//            System.out.println(i);
            if (isInvalidId(i)) {
//                System.out.println("Invalid ID found: " + i);
                invalidIdCount +=i;
            }
        }
//        System.out.println("-----");
        return invalidIdCount;
    }

    public static boolean isInvalidId(long id) {
        String idStr = Long.toString(id);
        int length = idStr.length();

        if (length % 2 != 0) {
            return false; // can't split evenly
        }

        String firstHalf = idStr.substring(0, length / 2);
        String secondHalf = idStr.substring(length / 2);

        return firstHalf.equals(secondHalf);
    }

}
