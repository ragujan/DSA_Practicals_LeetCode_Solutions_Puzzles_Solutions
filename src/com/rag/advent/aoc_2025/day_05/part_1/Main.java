package com.rag.advent.aoc_2025.day_05.part_1;

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
        List<BigInteger> availableIds = new ArrayList<>();
        for (String line : lines) {

            System.out.println("line " + line);
            if (line.trim().isEmpty()) {
                System.out.println("----");
                emptyLineEncountered = true;
                continue;
            }
            if (emptyLineEncountered) {
//                we need to put available ids processing here
                BigInteger availableId = new BigInteger(line.trim());
                availableIds.add(availableId);
                System.out.println("availableId " + availableId);
            } else {

                BigInteger rangeStart =  new BigInteger((line.split("-")[0]));
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
        System.out.println("Available IDs: " + availableIds);

//      now check if the available ids fall within any of the merged ranges
//
        Collections.sort(availableIds);
        int availableIdCount = 0;

//        using two pointer system
        int i = 0; // pointer for mergedRanges
        int j = 0; // pointer for availableIds

        while( j< availableIds.size() && i<mergedRanges.size() ){
            BigInteger[] currentRange = mergedRanges.get(i);
            BigInteger availableId = availableIds.get(j);

            // availableId = 2
//             currentRange = [5,10]

//            availableId.compareTo(currentRange[0]) < 0 true
            if(availableId.compareTo(currentRange[0])<0){
                j++;

//             availableId = 12
//             currentRange = [5,10]
//                availableId.compareTo(currentRage[1])>0 true
            }else if(availableId.compareTo(currentRange[1]) > 0){
                i++;
            }else{
                // availableId is within the current range
                availableIdCount++;
                j++;
            }



        }

        System.out.println("Total available ingredient IDs that can be used: " + availableIdCount);


//
    }


}
