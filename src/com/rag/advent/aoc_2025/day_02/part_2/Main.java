package com.rag.advent.aoc_2025.day_02.part_2;

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
            String[] items = line.split(",");
            for (String item : items) {
                String itemTrimmed = item.trim();
                invalidIdCount += iterateThroughRange(itemTrimmed);

            }
        }
        System.out.println("Total invalid IDs: " + invalidIdCount);


    }

    public static long iterateThroughRange(String idRange) {
        String[] parts = idRange.split("-");
        long start = Long.parseLong(parts[0].trim());
        long end = Long.parseLong(parts[1].trim());
        long invalidIdCount = 0;
        for (long i = start; i <= end; i++) {
//            System.out.println(i);
            if (isValidId(i)) {
//                System.out.println("Invalid ID found: " + i);
                invalidIdCount +=i;
            }
        }
//        System.out.println("-----");
        return invalidIdCount;
    }

    public static boolean isValidId(long id){
        String s = Long.toString(id);
        int n = s.length();

        for(int  k=1; k<=n/2 ; k++){
            int status = n % k ;
            if (n % k != 0){
                continue;
            }
            String pattern = s.substring(0,k);

            boolean matches = true;

            for(int i=k;i<n; i+=k){

                String subString = s.substring(i,i+k);

                if(!subString.equals(pattern)){
                    matches = false;
                    break;
                }

            }

            if(matches){
                return true;
            }
        }
        return false;

    }

}
