package com.rag.advent.aoc_2025.day_02.part_1;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IdCheckTest {

    @Test
    public void testEqualHalves() {
        assertTrue(isInvalidId(123123)); // "123" == "123"
        assertTrue(isInvalidId(1212));   // "12" == "12"
        assertTrue(isInvalidId(11));     // "1" == "1"
    }

    @Test
    public void testNotEqualHalves() {
        assertFalse(isInvalidId(123456)); // "123" != "456"
        assertFalse(isInvalidId(10));     // "1" != "0"
        assertFalse(isInvalidId(12345));  // odd length: "12" != "345"
    }

    @Test
    public void testSingleDigit() {
        assertFalse(isInvalidId(1)); // first half empty
        assertFalse(isInvalidId(0)); // first half empty
    }

    @Test
    public void testLargeNumber() {
        assertTrue(isInvalidId(999999)); // "999" == "999"
        assertTrue(isInvalidId(100100)); // "100" == "100"
    }

    // Local copy of the logic just like in your main class
    public boolean isInvalidId(long id) {
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
