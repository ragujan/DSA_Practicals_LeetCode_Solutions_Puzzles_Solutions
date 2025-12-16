package com.rag.advent.aoc_2025.day_01.part_1;


class Main2 {
    public static void main(String[] args) {
        System.out.println("=== LEFT ROTATION TEST CASES ===\n");

        // No pass, no landing on 0
        System.out.println("--- Case Group: No pass, no landing on 0 ---");
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
        testLeft(0, 0, "No rotation");
    }

    public static void testLeft(int start, int rotationCount, String description) {
        int password = 0;
        int previousPoint = start;

        // Handle no rotation
        if (rotationCount == 0) {
            System.out.println(description + " | Start: " + previousPoint +
                    ", Rotate: " + rotationCount + ", End: " + previousPoint +
                    " | NO ROTATION | Password: 0");
            return;
        }

        // Calculate new position
        int pointAt = ((previousPoint - rotationCount) % 100 + 100) % 100;

        // Calculate how many times we pass through 0
        if (previousPoint >= rotationCount) {
            // Simple case: no wrapping around 0
            if (pointAt == 0) {
                password = 1; // Land exactly on 0
            } else {
                // Don't pass through 0
            }
        } else {
            // Complex case: we wrap around 0
            // Calculate absolute distance traveled backward
            int distanceTraveled = rotationCount;

            if (pointAt == 0) {
                // We land exactly on 0 after passing through it
                password = (distanceTraveled + previousPoint) / 100;
            } else {
                // We pass through 0 but don't land on it
                password = ((distanceTraveled - previousPoint) + 99) / 100;
            }
        }

        System.out.println(description + " | Start: " + previousPoint +
                ", Rotate: " + rotationCount + ", End: " + pointAt +
                " | Password: " + password);
    }
}