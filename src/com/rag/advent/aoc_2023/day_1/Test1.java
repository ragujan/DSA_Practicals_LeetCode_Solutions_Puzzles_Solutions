package com.rag.advent.aoc_2023.day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws FileNotFoundException {
        File myObj = new File("src/com/rag/advent/aoc_2023/day_1/input.txt");
        Scanner myReader = new Scanner(myObj);
        LinkedList<String> lines = new LinkedList<>();
        int total_spaces = 0;
        int rowCount = 0;
        int total = 0;
        while (myReader.hasNextLine()) {
//            if(rowCount == 10){
//                break;
//            }
            String line = myReader.nextLine();

            String[] ch = new String[line.length()];

            for (int i = 0; i <line.length() ; i++) {
                ch[i] = String.valueOf(line.charAt(i));
            }
//            now you have [a,b,c,d,1,2,d,l]
            List<String> list = Arrays.stream(ch).toList();
            int[] numberCount = {0};
            NumberHolder numberHolder = new NumberHolder();
            list.forEach(e-> {
                if(isNumeric(e)){

                    if(numberCount[0] == 0){
                        numberHolder.setNum1(Integer.parseInt(e));
                    }
                    numberHolder.setNum2(Integer.parseInt(e));
                    numberCount[0]++;
                }

            });
            System.out.println("first number is "+numberHolder.getNum1() +" second number is "+numberHolder.getNum2());
            String n1 = String.valueOf(numberHolder.getNum1());
            String n2 = String.valueOf(numberHolder.getNum2());
            String n1n2 = n1.concat(n2);
            total += Integer.parseInt(n1n2);
            System.out.println("-------------");
            rowCount++;
        }
        System.out.println("total is "+total);
    }
    static class NumberHolder{
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
    private static boolean isNumeric(String strChar){
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
}
