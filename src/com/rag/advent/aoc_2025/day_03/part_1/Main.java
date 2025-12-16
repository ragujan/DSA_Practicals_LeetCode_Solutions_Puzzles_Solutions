package com.rag.advent.aoc_2025.day_03.part_1;

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

        int totalBatteryJoltage = 0;

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
            System.out.println("line "+line);
            String number = line;

            int firstBigger = 0;
            int secondBigger = 0;
            int max = 0;
            for (int i = 0; i < number.length(); i++) {
                for (int j = i + 1; j < number.length(); j++) {
                    int d1 = number.charAt(i) - '0';
                    int d2 = number.charAt(j) - '0';
                    int value = d1 * 10 + d2;
                    max = Math.max(max, value);
                }
            }

            totalBatteryJoltage += max;

        }

        System.out.println("Total battery joltage: " + totalBatteryJoltage);


    }



}
