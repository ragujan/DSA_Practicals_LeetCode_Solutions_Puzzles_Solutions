package com.rag.advent.aoc_2025.day_06.part_2;

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

        long grandTotal = 0;

        int rows = lines.size();
        int cols = lines.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
        char[][] grid = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            String line = lines.get(r);
            for (int c = 0; c < cols; c++) {
                grid[r][c] = (c < line.length()) ? line.charAt(c) : ' ';
            }
        }

//        //System.out.println("grid is  " + Arrays.deepToString(grid));
//        detect the empty columns
        boolean[] emptyCols = new boolean[cols];

        for (int c = 0; c < cols; c++) {
            boolean isEmpty = true;
            for (int r = 0; r < rows; r++) {
                if (grid[r][c] != ' ') {
                    isEmpty = false;
                    break;
                }
            }
            emptyCols[c] = isEmpty;
        }
//        //System.out.println("emptyCols " + Arrays.toString(emptyCols));

//        break them into small grids, use completely empty columns as separators
//        this small grid will zero for empty columns
        List<Map<Integer, List<DigitValAndPos>>> smallGrids = new ArrayList<>();
        Map<Integer, Character> symbolMap = new HashMap<>();
        Integer symbolCount = 0;
        Integer numberSetCount = 0;

        for (int c = 0; c < cols; c++) {

            Map<Integer, List<DigitValAndPos>> smallGrid = new HashMap<>();
            if (emptyCols[c]) {
                numberSetCount++;
                continue;
            }
            for (int r = 0; r < rows; r++) {
                if (r != rows - 1) {
//                    //System.out.println("this digit will be added to " + numberSetCount);
                    int digit = grid[r][c] != ' ' ? Character.getNumericValue(grid[r][c]) : 0;
                    DigitValAndPos digitValAndPos = new DigitValAndPos(r, c, digit);
                    smallGrid.putIfAbsent(numberSetCount, new ArrayList<>());
                    smallGrid.get(numberSetCount).add(digitValAndPos);

//                    //System.out.println("at row " + r + " column " + c + " value " + digit);
                } else if (r == rows - 1 && grid[r][c] != ' ') {

                    symbolMap.putIfAbsent(symbolCount, grid[r][c]);
                    symbolCount++;

                }
            }
            smallGrids.add(smallGrid);


        }
//        printGroupedByKeyCompact(smallGrids);
        //System.out.println("smallGrids " + smallGrids);
        sumAllSmallGridDigits(smallGrids, symbolMap);


        //System.out.println(grandTotal);

//
    }

    public static void sumAllSmallGridDigits(List<Map<Integer, List<DigitValAndPos>>> smallGrids, Map<Integer, Character> symbolMap) {
        int gridCount = 1;
        Map<Integer, List<DigitValAndPos>> combinedGrid = new HashMap<>();
        Map<Integer, BigInteger> sumPerKey = new HashMap<>();

        for (Map<Integer, List<DigitValAndPos>> smallGrid : smallGrids) {
            for (Map.Entry<Integer, List<DigitValAndPos>> entry : smallGrid.entrySet()) {
                Integer key = entry.getKey();
                List<DigitValAndPos> value = entry.getValue();
                combinedGrid.putIfAbsent(key, new ArrayList<>());
                combinedGrid.get(key).addAll(value);
                //System.out.println("symbol for this " + symbolMap.get(key));
                ;
                Character symbol = symbolMap.get(key);
                //System.out.println("key " + key + " symbol " + symbol + " values ");
                StringBuilder numberFromDigit = new StringBuilder();
                for (DigitValAndPos d : value) {
                    //System.out.println("   val " + d.getVal());
                    if (d.getVal() != 0) {
                        numberFromDigit.append(String.valueOf(d.getVal()));
                    }
                }
                BigInteger number = new BigInteger(numberFromDigit.toString());
                if (symbol != null && symbol == '+') {
                    sumPerKey.putIfAbsent(key, BigInteger.ZERO);
                    sumPerKey.put(key, sumPerKey.get(key).add(number));
                } else if (symbol != null && symbol == '*') {
                    sumPerKey.putIfAbsent(key, BigInteger.ONE);
                    sumPerKey.put(key, sumPerKey.get(key).multiply(number));
                }
                //System.out.println("number formed " + number);
//                if(symbol != null && symbol == '+'){
//                    BigInteger sum = BigInteger.ZERO;
//                    for(DigitValAndPos d: value){
//                        sum = sum.add(BigInteger.valueOf(d.getVal()));
//                    }
//                    sumPerKey.putIfAbsent(key, BigInteger.ZERO);
//                    sumPerKey.put(key, sumPerKey.get(key).add(sum));
//                }else if(symbol != null && symbol == '*') {
//                    BigInteger product = BigInteger.ONE;
//                    for (DigitValAndPos d : value) {
//                        product = product.multiply(BigInteger.valueOf(d.getVal()));
//                    }
//                    sumPerKey.putIfAbsent(key, BigInteger.ZERO);
//                    sumPerKey.put(key, sumPerKey.get(key).add(product));
//                }
            }
        }

        //System.out.println("Combined Grid:");
        for (Map.Entry<Integer, List<DigitValAndPos>> entry : combinedGrid.entrySet()) {
            //System.out.println("key " + entry.getKey());
            Character symbol = symbolMap.get(entry.getKey());
            printGridItems(entry.getValue());
            //System.out.println("----");
        }
        //System.out.println("Sum per key:");
        BigInteger totalSum = BigInteger.ZERO;
        for (Map.Entry<Integer, BigInteger> entry : sumPerKey.entrySet()) {
            //System.out.println("Key " + entry.getKey() + " Sum: " + entry.getValue());
            totalSum = totalSum.add(entry.getValue());
        }
        System.out.println("total sum :"+totalSum);
    }


    public static void printGridItems(List<DigitValAndPos> digitAndPos) {
        for (DigitValAndPos d : digitAndPos) {
            //System.out.println("Row: " + d.getPosRow() + " Col: " + d.getPosCol() + " Val: " + d.getVal());
        }
    }

    public static class DigitValAndPos {
        private int posRow;
        private int posCol;
        private int val;

        public DigitValAndPos(int posRow, int posCol, int val) {
            this.posRow = posRow;
            this.posCol = posCol;
            this.val = val;
        }

        public int getPosRow() {
            return posRow;
        }

        public void setPosRow(int posRow) {
            this.posRow = posRow;
        }

        public int getPosCol() {
            return posCol;
        }

        public void setPosCol(int posCol) {
            this.posCol = posCol;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }


}
