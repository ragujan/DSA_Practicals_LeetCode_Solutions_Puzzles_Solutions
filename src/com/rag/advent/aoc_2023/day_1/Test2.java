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
        solution2();
    }

    static void solution() throws FileNotFoundException {
        File myObj = new File("src/com/rag/advent/aoc_2023/day_1/input2.txt");
        Scanner myReader = new Scanner(myObj);
        int rowCount = 0;
        int total = 0;
        while (myReader.hasNextLine()) {
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
                total += Integer.parseInt(n1n2);
                System.out.println("sum is " + total);
            }
            System.out.println("line count is " + (rowCount + 1));
            rowCount++;
        }
        System.out.println("total is " + total);
    }
    public static void solution2() throws FileNotFoundException {
        File myObj = new File("src/com/rag/advent/aoc_2023/day_1/input2.txt");
        Scanner myReader = new Scanner(myObj);
        int rowCount = 0;
        int total = 0;
        while (myReader.hasNextLine()) {

            String line = myReader.nextLine();

            String regex = "(one|two|three|four|five|six|seven|eight|nine|zero|0|1|2|3|4|5|6|7|8|9)";
            regex = "(one|two|three|four|five|six|seven|eight|nine|zero|0|1|2|3|4|5|6|7|8|9)";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            List<String> firstLast = new LinkedList<>();
            Set<String> mySet  = new LinkedHashSet<>();
            int matchCount = 0;


            for (int i = 0; i <line.length() ; i++) {
                if(matcher.find(i)){
                    String number = matcher.group();
//                    System.out.println(number);
                    mySet.add(number);
                }
            }
            System.out.println(mySet);
            firstLast.addAll(mySet);
            String first = firstLast.get(0);
            String last = firstLast.get(firstLast.size()-1);
//            System.out.println("first is "+first+" last is "+last);

            NumberHolder numberHolder = new NumberHolder();
            numberMap().forEach((s, integer) -> {
                if (s.equals(first)) {
                    numberHolder.setNum1(integer);
                }
            });
            numberMap().forEach((s, integer) -> {
                if (s.equals(last)) {
                    numberHolder.setNum2(integer);
                }
            });
            String n1 = String.valueOf(numberHolder.getNum1());
            String n2 = String.valueOf(numberHolder.getNum2());
            String n1n2 = n1.concat(n2);

            System.out.println(n1n2);
            total += Integer.parseInt(n1n2);
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

        String text = "5twone2";
        String regex = "(one|two|three|four|five|six|seven|eight|nine|zero|0|1|2|3|4|5|6|7|8|9)";

        Pattern pattern = Pattern.compile(regex);
        //Retrieving the matcher object
        Matcher matcher = pattern.matcher(text);
        List<String> firstLast = new LinkedList<>();
        Set<String> mySet  = new LinkedHashSet<>();

        for (int i = 0; i <text.length() ; i++) {
            if(matcher.find(i)){
                String number = matcher.group();
                System.out.println(number);
                mySet.add(number);
            }
        }
        System.out.println(mySet);
        firstLast.addAll(mySet);
        String first = firstLast.get(0);
        String last = firstLast.get(firstLast.size()-1);
        System.out.println("first is "+first+" last is "+last);

        NumberHolder numberHolder = new NumberHolder();
        numberMap().forEach((s, integer) -> {
            if (s.equals(first)) {
                numberHolder.setNum1(integer);
            }
        });
        numberMap().forEach((s, integer) -> {
            if (s.equals(last)) {
                numberHolder.setNum2(integer);
            }
        });
        String n1 = String.valueOf(numberHolder.getNum1());
        String n2 = String.valueOf(numberHolder.getNum2());
//        this is where you get the two digits 22, 45, 78 etc
        String n1n2 = n1.concat(n2);
        System.out.println(n1n2);
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

}
