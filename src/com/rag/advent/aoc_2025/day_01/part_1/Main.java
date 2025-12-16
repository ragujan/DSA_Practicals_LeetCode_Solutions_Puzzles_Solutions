package com.rag.advent.aoc_2025.day_01.part_1;


class Main {
    public static void main(String[] args) {

        System.out.println("=== LEFT ROTATION TEST CASES ===");

        System.out.println("\n=============== LEFT ROTATION TEST CASES ===============\n");

// No pass, no landing on 0
        System.out.println("\n--- Case Group: No pass, no landing on 0 ---");
        testLeft(50, 10, "Simple left, no pass, no zero");
        testLeft(20, 5, "Small left, no pass, no zero");

// Pass zero once
        System.out.println("\n--- Case Group: Pass zero once ---");
        testLeft(10, 20, "Pass zero once");
        testLeft(5, 15, "Pass zero once small");

// Pass zero multiple times
        System.out.println("\n--- Case Group: Pass zero multiple times ---");
        testLeft(10, 120, "Pass zero twice");
        testLeft(30, 250, "Pass zero twice large");
        testLeft(40, 350, "Pass zero three times");

// Land exactly on 0 without passing through
        System.out.println("\n--- Case Group: Land on zero, no pass ---");
        testLeft(30, 30, "Land on zero, no pass");
        testLeft(50, 50, "Land on zero, no pass from mid");

// Land on zero after passing
        System.out.println("\n--- Case Group: Pass zero and land on zero ---");
        testLeft(5, 105, "Pass once, land on zero");
        testLeft(20, 120, "Pass once, land on zero");

// Edge cases
        System.out.println("\n--- Case Group: Edge Cases ---");
        testLeft(0, 1, "Start at 0, move left 1");
        testLeft(1, 1, "End on 0 exact");
        testLeft(0, 100, "Full loop left, land on 0");
        testLeft(99, 200, "Two full passes");


    }

    public static void testLeft(int start, int rotationCount, String description) {
        int pointAt = start;
        int password = 0;

        int previousPoint = pointAt;
        if (pointAt == rotationCount) {
            password++;
        } else {

            if (pointAt < rotationCount) {
//            pointAt = ((pointAt - rotationCount) % 100)+100;
//        }else{
                pointAt = ((pointAt - rotationCount) % 100);
                if (pointAt != 0) {
                    pointAt += 100;
                }
            }


            System.out.print(description + " | Start: " + previousPoint + ", Rotate: " + rotationCount +
                    ", End: " + pointAt + " | ");

            if (previousPoint - rotationCount < 0 && ((rotationCount - previousPoint) % 100 !=0)) {
                System.out.print("COND L | ");
                int additionalCount = (rotationCount - previousPoint + 99) / 100;
                password += additionalCount;
            }

            if (pointAt == 0) {
                password++;
            }
        }


        System.out.println("3Password: " + password);
    }

}