package com.rag.advent.aoc_2025.day_01.part_1;

import java.nio.file.*;
import java.util.List;

public class PartTwo {
    public static void main(String[] args) throws Exception {
        Path p = Path.of(PartOne.class.getResource("testInput.txt").toURI());
//        Path p = Path.of(PartOne.class.getResource("input.txt").toURI());
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

                int wraps = (previousPoint + rotationCount) / 100;

                System.out.print("Start: " + previousPoint + ", Rotate: " + rotationCount +
                        ", Wraps: " + wraps + ", End: " + pointAt + " | ");

                if (rotationCount == 0) {
                    System.out.print("NO COND | ");
                } else if (wraps > 0) {
                    System.out.print("WRAP | ");
                    password += wraps;
                } else {
                    System.out.print("NO WRAP | ");
                }

                System.out.println("Password: " + password);
//                int previousPoint = pointAt;
//                pointAt = (pointAt + rotationCount) % 100;
//                int total = previousPoint + rotationCount;
//
//                System.out.print("Start: " + previousPoint + ", Rotate: " + rotationCount +
//                        ", Total: " + total + ", End: " + pointAt + " | ");
//                if (rotationCount == 0) {
//                    System.out.print("NO COND | ");
//                    password = 0;
//                } else if (total <= 100 && total % 100 == 0) {
//                    System.out.print("COND 1 | ");
//                    password++;
//                } else if (total > 100 && total % 100 == 0) {
//                    System.out.print("COND 2 | ");
//                    int additionalCount = rotationCount / 100;
//                    if (rotationCount % 100 == 0) {
//                        password += additionalCount;
//                    } else {
//                        password += additionalCount + 1;
//                    }
//
//                } else if (total > 100 && total % 100 != 0) {
//                    System.out.print("COND 3 | ");
//                    int additionalCount = rotationCount / 100;
//                    System.out.println("previous password : |" + password);
//                    System.out.print("additionalCount: |" + additionalCount);
//
//                    if (additionalCount == 0) {
//                        password++;
//                    } else if (additionalCount > 0) {
//                        password += additionalCount;
//                    }
//                    // Using original logic
//                } else {
//                    System.out.print("NO COND | ");
//                }
//
//                System.out.println("Password: " + password);

            } else if (direction.equals("L")) {
                int previousPoint = pointAt;

                pointAt = (pointAt - rotationCount + 100) % 100;
                if (pointAt < 0) {
                    pointAt += 100;
                }


                if (previousPoint == 0) {
//                    don't do anything
                    System.out.println("nothing to do ");
                } else if (previousPoint - rotationCount == 0) {
                    password++;
                } else if (rotationCount == 0) {
                    // No rotation, password remains 0
                } else if (previousPoint - rotationCount < 0 && pointAt == 0) {
                    int additionalCount = rotationCount / 100;
                    if (additionalCount == 0) {
                        password++;
                    } else if (additionalCount > 0 && rotationCount % 100 == 0) {
                        password += additionalCount;
                    } else if (additionalCount > 0) {
                        password += additionalCount + 1;
                    }
                } else if (previousPoint - rotationCount < 0 && pointAt != 0) {
                    int additionalCount = rotationCount / 100;
                    if (additionalCount == 0) {
                        password++;
                    } else if (additionalCount > 0 && rotationCount % 100 == 0) {
                        password += additionalCount;
                    } else if (additionalCount > 0) {
                        password += additionalCount + 1;
                    }
                }


            }

            System.out.println("point at " + pointAt);
            System.out.println("++++");

        }
        System.out.println("---------------");
        System.out.println("password is " + password);
    }
}
