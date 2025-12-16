package com.rag.advent.aoc_2025.day_01.part_1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeftRotationExperimentTest {

    @Test
    public void test_NoWrap_PositiveDifference() {
        int[] result = LeftRotationExperiment.rotateAndCount(80, 10);
        assertEquals(70, result[0]); // newValue
        assertEquals(0, result[1]);  // password
    }

    @Test
    public void test_ExactZero_NoWrap() {
        int[] result = LeftRotationExperiment.rotateAndCount(50, 50);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    public void test_FullTwoWrapsEndsSamePosition() {
        int[] result = LeftRotationExperiment.rotateAndCount(50, 200);
        assertEquals(50, result[0]);
        assertEquals(2, result[1]);
    }

    @Test
    public void test_WrapWithExactZeroLanding() {
        int[] result = LeftRotationExperiment.rotateAndCount(50, 250);
        assertEquals(0, result[0]);
        assertEquals(3, result[1]);
    }

    @Test
    public void test_WrapLandingNotZero() {
        int[] result = LeftRotationExperiment.rotateAndCount(50, 260);
        assertEquals(90, result[0]);
        assertEquals(3, result[1]);
    }

    @Test
    public void test_NegativeRotation_NoWrap_RightRotation() {
        int[] result = LeftRotationExperiment.rotateAndCount(30, -10);
        assertEquals(40, result[0]); // moves right
        assertEquals(0, result[1]);  // right rotation no full left wrap
    }
}
