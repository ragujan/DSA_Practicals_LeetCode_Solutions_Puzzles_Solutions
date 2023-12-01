package com.rag.advent.aoc_2023.day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) throws FileNotFoundException {
        testM();
//        solution();
    }

    static void solution() throws FileNotFoundException {
        File myObj = new File("src/com/rag/advent/aoc_2023/day_1/input2.txt");
        Scanner myReader = new Scanner(myObj);
        int rowCount = 0;
        int total = 0;
        while (myReader.hasNextLine()) {

            if(rowCount == 15){
                break;
            }
            String line = myReader.nextLine();

            String regex = "(one|two|three|four|five|six|seven|eight|nine|zero|0|1|2|3|4|5|6|7|8|9)";

            Pattern pattern = Pattern.compile(regex);
            //Retrieving the matcher object
            Matcher matcher = pattern.matcher(line);
            List<String> firstLast = new LinkedList<>();
            int matchCount = 0;
            boolean matchFound = false;
            while (matcher.find()) {

                String matchGroup = matcher.group();
                if (matchCount == 0) {
                    matchFound = true;
                    firstLast.add(0, matchGroup);
                }
                firstLast.add(1, matchGroup);
                matchCount++;

            }

            if (!matchFound) {
                System.out.println("the size is zero here " + rowCount);

            } else {
                NumberHolder numberHolder = new NumberHolder();
                numberMap().forEach((s, integer) -> {
                    if (s.equals(firstLast.get(0))) {
                        numberHolder.setNum1(integer);
                    }
                });
                numberMap().forEach((s, integer) -> {
                    if (s.equals(firstLast.get(1))) {
                        numberHolder.setNum2(integer);
                    }
                });
                System.out.println("first num is " + numberHolder.getNum1() + " last num is " + numberHolder.getNum2());
                String n1 = String.valueOf(numberHolder.getNum1());
                String n2 = String.valueOf(numberHolder.getNum2());
                String n1n2 = n1.concat(n2);
                System.out.println("num is " + n1n2);
//                total +=(numberHolder.getNum1() + numberHolder.getNum2());
                total += Integer.parseInt(n1n2);
                System.out.println("sum is " + total);
            }
            System.out.println("line count is " + (rowCount + 1));
            rowCount++;
        }
        System.out.println("total is " + total);
    }

    static class NumberHolder {
        Integer num1;
        Integer num2;

        public NumberHolder() {
        }

        public NumberHolder(Integer num1, Integer num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        public Integer getNum1() {
            return num1;
        }

        public void setNum1(Integer num1) {
            this.num1 = num1;
        }

        public Integer getNum2() {
            return num2;
        }

        public void setNum2(Integer num2) {
            this.num2 = num2;
        }
    }

    private static boolean isNumeric(String strChar) {
        boolean isNumeric = true;
        try {
            Integer caloryCount = Integer.parseInt(strChar);
            if (caloryCount < 0) {
                isNumeric = false;
            }
        } catch (NumberFormatException e) {
            isNumeric = false;
        }
        return isNumeric;
    }

    private static Map<String, Integer> numberMap() {
        Map<String, Integer> numberMap = new HashMap<>();

        // Adding mappings for numbers 0-9
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);
        numberMap.put("0", 0);
        numberMap.put("1", 1);
        numberMap.put("2", 2);
        numberMap.put("3", 3);
        numberMap.put("4", 4);
        numberMap.put("5", 5);
        numberMap.put("6", 6);
        numberMap.put("7", 7);
        numberMap.put("8", 8);
        numberMap.put("9", 9);
        return numberMap;
    }

    private static Map<Integer, String> numberMap2() {
        Map<Integer, String> numberMap = new HashMap<>();
        // Adding mappings for numbers 0-9
        numberMap.put(0, "zero");
        numberMap.put(1, "one");
        numberMap.put(2, "two");
        numberMap.put(3, "three");
        numberMap.put(4, "four");
        numberMap.put(5, "five");
        numberMap.put(6, "six");
        numberMap.put(7, "seven");
        numberMap.put(8, "eight");
        numberMap.put(9, "nine");

        return numberMap;
    }

    public static void testM() {

        String regex = "(one|two|three|four|five|six|seven|eight|nine|zero)";
        String text = "ragbagonejiklathreebogkanefiveragtwonine";
        regex = "(one|two|three|four|five|six|seven|eight|nine|zero|0|1|2|3|4|5|6|7|8|9)";
        text = "81fourtwo";

        Pattern pattern = Pattern.compile(regex);
        //Retrieving the matcher object
        Matcher matcher = pattern.matcher(text);
        List<String> firstLast = new LinkedList<>();
        int matchCount = 0;
        while (matcher.find()) {
            String matchGroup = matcher.group();
            System.out.println("Found: " + matchGroup);
            if (matchCount == 0) {
                firstLast.add(0, matchGroup);
            }
            firstLast.add(1, matchGroup);
            matchCount++;

        }
//        System.out.println("first and last numbers are " + firstLast.get(0) + " and " + firstLast.get(1));
        NumberHolder numberHolder = new NumberHolder();
        numberMap().forEach((s, integer) -> {
            if (s.equals(firstLast.get(0))) {
                numberHolder.setNum1(integer);
            }
        });
        numberMap().forEach((s, integer) -> {
            if (s.equals(firstLast.get(1))) {
                numberHolder.setNum2(integer);
            }
        });
        String n1 = String.valueOf(numberHolder.getNum1());
        String n2 = String.valueOf(numberHolder.getNum2());
        String n1n2 = n1.concat(n2);
        System.out.println("num 1 is " + numberHolder.getNum1() + " num 2 is " + numberHolder.getNum2());
        System.out.println("sum is " + n1n2);

    }

    private static List<String> numberTextList() {
        List<String> numberTextList = new ArrayList<>();

        // Adding textual representations of numbers to the list
        numberTextList.add("zero");
        numberTextList.add("one");
        numberTextList.add("two");
        numberTextList.add("three");
        numberTextList.add("four");
        numberTextList.add("five");
        numberTextList.add("six");
        numberTextList.add("seven");
        numberTextList.add("eight");
        numberTextList.add("nine");

        return numberTextList;
    }

    public static int matchCharCountInDifferentIndex(String word1, String word2) {
        Map<Character, Integer> word_count_1 = new HashMap<>();
        Map<Character, Integer> word_count_2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                word_count_1.compute(word1.charAt(i), (k, v) -> v == null ? 1 : v + 1);
                word_count_2.compute(word2.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            }
        }

        int count = 0;
        for (Map.Entry<Character, Integer> e : word_count_2.entrySet()) {
            count += Math.min(e.getValue(), word_count_1.getOrDefault(e.getKey(), 0));
        }

        System.out.printf("word1=%s word2=%s result=%d%n", word_count_1, word_count_2, count);
        return count;
    }
}
