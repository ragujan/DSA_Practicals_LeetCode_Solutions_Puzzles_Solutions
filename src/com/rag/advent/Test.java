package com.rag.advent;

import java.util.Scanner;


public class Test {
    public static void main(String[] args) {

        Scanner myobj = new Scanner(System.in);
        System.out.println("Enter to start with");
        if (myobj.hasNextInt()) {
            String input = myobj.nextLine();
            Test t = new Test();
            t.doThis(input);
        }else{
            System.out.println("Invalid input! program stopped ");
        }


    }

    public void doThis(String fromNumberStr) {
        int fromNumber = Integer.parseInt(fromNumberStr);

        int calucalationTotal = 0;
        String evidenceFactorial = "";
        String finalStatementText = "The factorial of " + fromNumber + " is ";
        if (fromNumber < 0) {

            finalStatementText = "Invalid input! program stopped ";
            System.out.println(finalStatementText);
            return;
        }
        for (int i = fromNumber; i > 0; i--) {

            calucalationTotal = i * (calucalationTotal);
            if (calucalationTotal == 0) {
                calucalationTotal = i;

            }
            if (i != 1) {
                evidenceFactorial += Integer.toString(fromNumber - (i - 1)) + " X ";
            } else {
                evidenceFactorial += Integer.toString(fromNumber - (i - 1));
            }

        }
        evidenceFactorial = fromNumber + "! = " + evidenceFactorial;
        finalStatementText = finalStatementText + calucalationTotal;
        System.out.println(evidenceFactorial);
        System.out.println(finalStatementText);
    }
}
