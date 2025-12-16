package com.rag.advent.aoc_2025.day_02.part_1;

public class IdInvalidChecker {
    public static boolean isInvalidId(long id) {
        String idStr = Long.toString(id);
        int length = idStr.length();

        StringBuilder firstHalfBuilder = new StringBuilder();
        for (int i = 0; i < length / 2; i++) {
            firstHalfBuilder.append(idStr.charAt(i));
        }

        String firstHalf = firstHalfBuilder.toString();
        String secondHalf = idStr.substring(length / 2);

        return firstHalf.equals(secondHalf);
    }

}
