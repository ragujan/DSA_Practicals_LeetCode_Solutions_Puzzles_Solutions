package com.rag.advent.aoc_2025.day_01.part_1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PartOne {
    public static void main(String[] args) throws Exception {
//        Path p = Path.of(PartOne.class.getResource("testInput.txt").toURI());
        Path p = Path.of(PartOne.class.getResource("input.txt").toURI());
        List<String> lines = Files.readAllLines(p);

        int pointAt = 50;
        int password = 0;

        for (String dialRotation : lines) {
            System.out.println(dialRotation);
            String direction = dialRotation.substring(0, 1);
            int rotationCount = Integer.parseInt(dialRotation.substring(1));

            if (direction.equals("R")) {
                int previousPoint = pointAt;
                pointAt = (pointAt + rotationCount) % 100;
                int rotationsOver100 = (previousPoint + rotationCount) / 100;
                password += rotationsOver100;
                if (pointAt == 0) password++;

            } else if (direction.equals("L")) {
                int previousPoint = pointAt;
                pointAt = (pointAt - rotationCount + 100) % 100;
                int rotationsOver100 = (rotationCount - previousPoint + 99) / 100;
                password += rotationsOver100;

                if (pointAt == 0) password++;
            }

            System.out.println("point at " + pointAt);
            System.out.println("++++");

        }
        System.out.println("---------------");
        System.out.println("password is " + password);
    }
}
