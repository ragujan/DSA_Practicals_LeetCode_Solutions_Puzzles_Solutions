package com.rag.advent.aoc_2025.day_05.part_2;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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
        List<String> lines = Files.readAllLines(p);
//        the input consists of
        // fresh ingredient id range, and
        // after a empty line
        // list of available ids will be listed


        List<BigInteger[]> freshIngredientIdRanges = new ArrayList<>();

//        need to sort the ranges by start value


//        merged ranges
        List<BigInteger[]> mergedRanges = new ArrayList<>();

        boolean emptyLineEncountered = false;
        for (String line : lines) {

            System.out.println("line " + line);
            if (line.trim().isEmpty()) {
                System.out.println("----");
                emptyLineEncountered = true;
                continue;
            }
            if (!emptyLineEncountered) {

                BigInteger rangeStart = new BigInteger((line.split("-")[0]));
                BigInteger rangeEnd = new BigInteger(line.split("-")[1]);

                System.out.println("rangeStart " + rangeStart + " rangeEnd " + rangeEnd);


                BigInteger[] range = new BigInteger[2];
                range[0] = rangeStart;
                range[1] = rangeEnd;
                freshIngredientIdRanges.add(range);
            }
        }

        List<BigInteger[]> sortedRanges = new ArrayList<>(freshIngredientIdRanges);
        sortedRanges.sort(Comparator.comparing(e -> e[0]));

        System.out.println("Sorted Ranges: " + sortedRanges);


//        merge overlapping ranges

// Merge overlapping ranges
        for (BigInteger[] range : sortedRanges) {

            if (mergedRanges.isEmpty()) {
                mergedRanges.add(range);
                continue;
            }

            BigInteger[] last = mergedRanges.getLast();

            // if last.end < current.start → no overlap
            if (last[1].compareTo(range[0]) < 0) {
                mergedRanges.add(range);
            } else {
                // overlap → extend end
                last[1] = last[1].max(range[1]);
            }
        }

        for (BigInteger[] range : mergedRanges) {
            System.out.println("Merged range: " + Arrays.toString(range));
        }

//      now check if the available ids fall within any of the merged ranges
//
        BigInteger availableIdCount = new BigInteger("0");

//        just count the range sizes and increment availableIdCount
        for (BigInteger[] range : mergedRanges) {
            BigInteger start = range[0];
            BigInteger end = range[1];
            System.out.println("start "+start+ " end "+end);
//            since both start and end are inclusive, we need to add 1 to the difference
            BigInteger rangeSize = end.subtract(start).add(BigInteger.ONE);
            System.out.println("rangeSize "+rangeSize);
           availableIdCount = availableIdCount.add(rangeSize);

        }


        System.out.println("Total available ingredient IDs that can be used: " + availableIdCount);


//
    }


}
