package com.rag.advent.aoc_2025.day_03.part_2;

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

        BigInteger totalBatteryJoltage = BigInteger.valueOf(0);

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
//            System.out.println("line "+line);
            String number = line;

            BigInteger max = calculationOfBatteryJoltage(number);

            totalBatteryJoltage = totalBatteryJoltage.add(max);

        }

        System.out.println("Total battery joltage: " + totalBatteryJoltage);


    }

    static BigInteger calculationOfBatteryJoltage(String number){

        int k = 12;

        int toRemove = number.length()-k;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : number.toCharArray()) {
            while(toRemove>0 && !stack.isEmpty() &&  c > stack.peekLast()){
                stack.pollLast();
                toRemove--;
            }
            stack.addLast(c);
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(char c: stack){
            if(count++<k){
                sb.append(c);
            }
        }

        return new BigInteger(sb.toString());
    }


}
