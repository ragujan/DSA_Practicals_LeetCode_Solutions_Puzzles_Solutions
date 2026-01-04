package com.rag.advent.aoc_2025.day_06.part_1;

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

//        numbers with space in between
//        at the bottom the operation symbol is presented

        Map<Integer, List<BigInteger>> verticalNumbersMap = new HashMap<>();
        Map<Integer, Character> operationMap = new HashMap<>();
        int operationPos = 0;
        for (int i = 0; i < lines.size(); i++) {

            String line = lines.get(i);
            System.out.println("line " + line);
//            if last line you have to insert the characters into the operation map

            int columnPos = 0;

            if (i == lines.size() - 1) {
                String[] symbols = line.trim().split(" ");
                for (int j = 0; j < symbols.length; j++) {

                    System.out.println("operation " + symbols[j]);
                    String symbolStr = symbols[j].trim();
                    if (!symbolStr.isEmpty()) {
                        Character operation = symbolStr.charAt(0);
                        operationMap.put(operationPos, operation);
                        operationPos++;
                    }
                }

            } else {
                String[] numbers = line.trim().split(" ");
                for (int j = 0; j < numbers.length; j++) {
                    if (!numbers[j].trim().isEmpty()) {
                        System.out.println("number string " + numbers[j]);
                        BigInteger number = new BigInteger(numbers[j]);
                        verticalNumbersMap.putIfAbsent(columnPos, new ArrayList<>());
                        verticalNumbersMap.get(columnPos).add(number);
                        columnPos++;
                    }

                }

            }


        }
        System.out.println("verticalNumbersMap " + verticalNumbersMap);
        System.out.println("operationMap " + operationMap);

        BigInteger finalResult = calculateResults(verticalNumbersMap, operationMap);
        System.out.println("Final Result: " + finalResult);

//
    }

    public static BigInteger calculateResults(Map<Integer, List<BigInteger>> verticalNumberMap, Map<Integer, Character> operationMap) {
        BigInteger finalResult = BigInteger.ZERO;

        for (Map.Entry<Integer, Character> entry : operationMap.entrySet()) {
            Integer symbolId = entry.getKey();
            Character character = entry.getValue();
            List<BigInteger> verticalNumbers = verticalNumberMap.get(symbolId);

            BigInteger columnResult = BigInteger.ZERO;

            for (BigInteger num : verticalNumbers) {
                if (character == '+') {
                    columnResult = columnResult.add(num);
                } else if (character == '*') {
                    columnResult = columnResult.equals(BigInteger.ZERO) ? num : columnResult.multiply(num);
                }
            }
            finalResult = finalResult.add(columnResult);

        }
        return finalResult;
    }

}
